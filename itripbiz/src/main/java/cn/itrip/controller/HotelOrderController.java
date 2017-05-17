package cn.itrip.controller;

import cn.itrip.beans.dtos.Dto;
import cn.itrip.beans.pojo.*;
import cn.itrip.beans.vo.order.ItripAddHotelOrderVO;
import cn.itrip.beans.vo.order.PreAddOrderVO;
import cn.itrip.common.DtoUtil;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.ValidationToken;
import cn.itrip.service.itripHotel.ItripHotelService;
import cn.itrip.service.itripHotelRoom.ItripHotelRoomService;
import cn.itrip.service.itripHotelTempStore.ItripHotelTempStoreService;
import io.swagger.annotations.Api;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping(value = "/addhotelorder",method= RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public Dto<Object> addHotelOrder(@RequestBody ItripAddHotelOrderVO itripAddHotelOrderVO, HttpServletRequest request){
        //ItripComment
        Dto<Object> dto = new Dto<Object>();
        String tokenString  = request.getHeader("token");
        logger.debug("token name is from header : " + tokenString);
        ItripUser currentUser = validationToken.getCurrentUser(tokenString);
        if(null != currentUser && null != itripAddHotelOrderVO){
            List<ItripImage> itripImages = null;
            ItripHotelOrder itripHotelOrder = new ItripHotelOrder();
            itripHotelOrder.setUserId(currentUser.getId());
            itripHotelOrder.setOrderType(itripAddHotelOrderVO.getOrderType());
            try {
//                if(itripAddHotelOrderVO.getIsHavingImg() == 1 ){
//                    itripImages = new ArrayList<ItripImage>();
//                    //loop input imgs array
//                    int i = 1;
//                    for (ItripImage itripImage : itripAddHotelOrderVO.getItripImages()) {
//                        itripImage.setPosition(i);
//                        itripImage.setCreatedBy(currentUser.getId());
//                        itripImage.setCreationDate(itripComment.getCreationDate());
//                        itripImage.setType("2");
//                        itripImages.add(itripImage);
//                        i++;
//                    }
//                }
//                itripCommentService.itriptxAddItripComment(itripComment,(null == itripImages?new ArrayList<ItripImage>():itripImages));
//                dto = DtoUtil.returnSuccess("新增评论成功");
            } catch (Exception e) {
                e.printStackTrace();
                dto = DtoUtil.returnFail("新增评论失败","100003");
            }
        }else if(null != currentUser && null == itripAddHotelOrderVO){
            dto = DtoUtil.returnFail("不能提交空，请填写评论信息","100004");
        }else{
            dto = DtoUtil.returnFail("token失效，请重登录","100005");
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
                dto.setData(preItripOrderVo);
            }
        } catch (Exception e) {
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
