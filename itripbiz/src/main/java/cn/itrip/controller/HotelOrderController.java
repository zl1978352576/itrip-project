package cn.itrip.controller;

import cn.itrip.beans.dtos.Dto;
import cn.itrip.beans.pojo.*;
import cn.itrip.beans.vo.order.ItripAddHotelOrderVO;
import cn.itrip.beans.vo.order.PreAddOrderVO;
import cn.itrip.beans.vo.store.StoreVO;
import cn.itrip.common.*;
import cn.itrip.service.itripHotel.ItripHotelService;
import cn.itrip.service.itripHotelOrder.ItripHotelOrderService;
import cn.itrip.service.itripHotelRoom.ItripHotelRoomService;
import cn.itrip.service.itripHotelTempStore.ItripHotelTempStoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by donghai on 2017/5/15.
 */
@Controller
@Api(value = "API", basePath = "/http://api.itrap.com/api")
@RequestMapping(value = "/api/hotelorder")
public class HotelOrderController {
    private Logger logger = Logger.getLogger(HotelController.class);

    @Resource
    private ValidationToken validationToken;

    @Resource
    private ItripHotelService hotelService;

    @Resource
    private ItripHotelRoomService roomService;

    @Resource
    private ItripHotelTempStoreService tempStoreService;

    @Resource
    private SystemConfig systemConfig;

    @Resource
    private ItripHotelTempStoreService itripHotelTempStoreService;

    @Resource
    private ItripHotelOrderService itripHotelOrderService;

    @ApiOperation(value = "生成订单", httpMethod = "POST",
            protocols = "HTTP",produces = "application/json",
            response = Dto.class,notes = "生成订单"+
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>"+
            "<p>100001 : 获取评分失败 </p>"+
            "<p>100002 : hotelId不能为空</p>")
    @RequestMapping(value = "/addhotelorder",method= RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public Dto<Object> addHotelOrder(@RequestBody ItripAddHotelOrderVO itripAddHotelOrderVO, HttpServletRequest request){
        //ItripComment

        Dto<Object> dto = new Dto<Object>();
        String tokenString  = request.getHeader("token");
        logger.debug("token name is from header : " + tokenString);
        ItripUser currentUser = validationToken.getCurrentUser(tokenString);
        Map<String, Object> validateStoreMap = new HashMap<String, Object>();
        validateStoreMap.put("startTime", itripAddHotelOrderVO.getCheckInDate());
        validateStoreMap.put("endTime", itripAddHotelOrderVO.getCheckOutDate());
        validateStoreMap.put("hotelId", itripAddHotelOrderVO.getHotelId());
        validateStoreMap.put("roomId", itripAddHotelOrderVO.getRoomId());
        validateStoreMap.put("count", itripAddHotelOrderVO.getCount());
        Boolean flag = false;
        try {
            flag = itripHotelTempStoreService.validateRoomStore(validateStoreMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(flag){
            if(null != currentUser && null != itripAddHotelOrderVO){
                //计算订单的预定天数
                Integer days = DateUtil.getBetweenDates(
                        itripAddHotelOrderVO.getCheckInDate(),itripAddHotelOrderVO.getCheckOutDate()
                ).size();
                ItripHotelOrder itripHotelOrder = new ItripHotelOrder();
                itripHotelOrder.setUserId(currentUser.getId());
                itripHotelOrder.setOrderType(itripAddHotelOrderVO.getOrderType());
                itripHotelOrder.setHotelId(itripAddHotelOrderVO.getHotelId());
                itripHotelOrder.setHotelName(itripAddHotelOrderVO.getHotelName());
                itripHotelOrder.setRoomId(itripAddHotelOrderVO.getRoomId());
                itripHotelOrder.setCount(itripAddHotelOrderVO.getCount());
                itripHotelOrder.setBookingDays(itripAddHotelOrderVO.getBookingDays());
                itripHotelOrder.setCheckInDate(itripAddHotelOrderVO.getCheckInDate());
                itripHotelOrder.setCheckOutDate(itripAddHotelOrderVO.getCheckOutDate());
                itripHotelOrder.setNoticePhone(itripAddHotelOrderVO.getNoticePhone());
                itripHotelOrder.setNoticeEmail(itripAddHotelOrderVO.getNoticeEmail());
                itripHotelOrder.setBookingDays(days);
                //支付之前生成的订单的初始状态为未支付
                itripHotelOrder.setOrderStatus(0);
                try {
                    //生成MD5
                    StringBuilder md5String = new StringBuilder();
                    md5String.append(itripHotelOrder.getHotelId());
                    md5String.append(itripHotelOrder.getRoomId());
                    md5String.append(System.currentTimeMillis());
                    md5String.append(Math.random()*1000000);
                    String md5 = MD5.getMd5(md5String.toString(), 6);

                    //生成订单编号
                    StringBuilder orderNo = new StringBuilder();
                    orderNo.append(systemConfig.getMachineCode());
                    orderNo.append(DateUtil.format(new Date(), "yyyyMMddHHmmss"));
                    orderNo.append(md5);
                    itripHotelOrder.setOrderNo(orderNo.toString());
                    itripHotelOrderService.addItripHotelOrder(itripHotelOrder);
                    //计算订单的总金额
                    itripHotelOrder.setPayAmount(itripHotelOrderService.getOrderPayAmount(days, itripAddHotelOrderVO.getRoomId()));
                    dto = DtoUtil.returnSuccess("生成订单成功");
                } catch (Exception e) {
                    e.printStackTrace();
                    dto = DtoUtil.returnFail("生成订单失败","100003");
                }
            }else if(null != currentUser && null == itripAddHotelOrderVO){
                dto = DtoUtil.returnFail("不能提交空，请填写订单信息","100004");
            }else{
                dto = DtoUtil.returnFail("token失效，请重登录","100005");
            }
        }else{
            dto = DtoUtil.returnFail("库存不足","100006");
        }
        return dto;
    }

    @RequestMapping(value = "/getpreorderinfo",method= RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public Dto<PreAddOrderVO> getPreOrderInfo(@RequestBody PreAddOrderVO preAddOrderVO){
        ItripHotel hotel=null;
        ItripHotelRoom room=null;
        PreAddOrderVO preItripOrderVo=null;
        Dto<PreAddOrderVO> dto = new Dto<PreAddOrderVO>();
        try {
            if(EmptyUtils.isEmpty(preAddOrderVO.getHotelId())){
                dto=DtoUtil.returnFail("hotelId不能为空","100006");
            }else if(EmptyUtils.isEmpty(preAddOrderVO.getRoomId())){
                dto=DtoUtil.returnFail("roomId不能为空","100007");
            }else{
                preItripOrderVo=new PreAddOrderVO();
                hotel=hotelService.getItripHotelById(preAddOrderVO.getHotelId());
                room=roomService.getItripHotelRoomById(preAddOrderVO.getRoomId());
                Map param=new HashMap();
                param.put("startTime", preAddOrderVO.getCheckInDate());
                param.put("endTime", preAddOrderVO.getCheckOutDate());
                param.put("roomId", preAddOrderVO.getRoomId());
                param.put("hotelId", preAddOrderVO.getHotelId());
                preItripOrderVo.setCheckInDate(preAddOrderVO.getCheckInDate());
                preItripOrderVo.setCheckOutDate(preAddOrderVO.getCheckOutDate());
                preItripOrderVo.setHotelName(hotel.getHotelName());
                preItripOrderVo.setRoomId(room.getId());
                preItripOrderVo.setPrice(room.getRoomPrice());
                preItripOrderVo.setHotelId(preAddOrderVO.getHotelId());
                List<StoreVO> storeVOList=tempStoreService.queryRoomStore(param);
                if(EmptyUtils.isNotEmpty(storeVOList)){
                    preItripOrderVo.setCount(storeVOList.get(0).getStore());
                }else{
                    preItripOrderVo.setCount(0);
                }
                dto.setData(preItripOrderVo);
            }
        } catch (Exception e) {
            e.printStackTrace();
            dto=DtoUtil.returnFail("系统异常","100008");
            return dto;
        }
        return dto;
    }

    @RequestMapping(value = "/validateroomstore",method= RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public Dto<Map<String,Boolean>> validateRoomStore(@RequestBody PreAddOrderVO preAddOrderVO) {
        Dto<Map<String,Boolean>> dto = new Dto<Map<String,Boolean>>();
        try {
            if(EmptyUtils.isEmpty(preAddOrderVO.getHotelId())){
                dto=DtoUtil.returnFail("hotelId不能为空","100006");
            }else if(EmptyUtils.isEmpty(preAddOrderVO.getRoomId())){
                dto=DtoUtil.returnFail("roomId不能为空","100007");
            }else{
                Map param=new HashMap();
                param.put("startTime", preAddOrderVO.getCheckInDate());
                param.put("endTime", preAddOrderVO.getCheckOutDate());
                param.put("roomId", preAddOrderVO.getRoomId());
                param.put("hotelId", preAddOrderVO.getHotelId());
                param.put("count", preAddOrderVO.getCount());
                boolean flag=tempStoreService.validateRoomStore(param);
                Map<String,Boolean> map=new HashMap<String,Boolean>();
                map.put("flag",flag);
                dto.setData(map);
            }
        } catch (Exception e) {
            dto=DtoUtil.returnFail("系统异常","100008");
            return dto;
        }
        return dto;
    }



}
