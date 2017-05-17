package cn.itrip.controller;

import cn.itrip.beans.dtos.Dto;
import cn.itrip.beans.pojo.*;
import cn.itrip.beans.vo.order.ItripAddHotelOrderVO;
import cn.itrip.common.*;
import cn.itrip.service.itripHotelOrder.ItripHotelOrderService;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by donghai on 2017/5/15.
 */
@Controller
@Api(value = "API", basePath = "/http://api.itrap.com/api")
@RequestMapping(value = "/api/hotelorder")
public class HotelOrderController {
    private Logger logger = Logger.getLogger(HotelController.class);

    @Resource
    private ItripHotelOrderService itripHotelOrderService;

    @Resource
    private ValidationToken validationToken;

    @Resource
    private SystemConfig systemConfig;

    @ApiOperation(value = "生成订单接口", httpMethod = "POST",
            protocols = "HTTP",produces = "application/json",
            response = Dto.class,notes = "生成订单接口"+
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>"+
            "<p>100003 : 生成订单失败 </p>"+
            "<p>100004 : 不能提交空，请填写订单信息</p>"+
            "<p>100005 : token失效，请重登录 </p>")
    @RequestMapping(value = "/addhotelorder",method= RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public Dto<Object> addHotelOrder(@RequestBody ItripAddHotelOrderVO itripAddHotelOrderVO, HttpServletRequest request){
        //ItripComment

        systemConfig.getMachineCode();
        Dto<Object> dto = new Dto<Object>();
        String tokenString  = request.getHeader("token");
        logger.debug("token name is from header : " + tokenString);
        ItripUser currentUser = validationToken.getCurrentUser(tokenString);
        if(null != currentUser && null != itripAddHotelOrderVO){
            ItripHotelOrder itripHotelOrder = new ItripHotelOrder();
            itripHotelOrder.setUserId(currentUser.getId());
            itripHotelOrder.setOrderType(itripAddHotelOrderVO.getOrderType());
            itripHotelOrder.setHotelId(1L);
            itripHotelOrder.setHotelName("北京大酒店");
            itripHotelOrder.setRoomId(itripAddHotelOrderVO.getRoomId());
            itripHotelOrder.setCount(itripAddHotelOrderVO.getCount());
            itripHotelOrder.setBookingDays(itripAddHotelOrderVO.getBookingDays());
            itripHotelOrder.setCheckInDate(itripAddHotelOrderVO.getCheckInDate());
            itripHotelOrder.setCheckOutDate(itripAddHotelOrderVO.getCheckOutDate());
            itripHotelOrder.setNoticePhone(itripAddHotelOrderVO.getNoticePhone());
            itripHotelOrder.setNoticeEmail(itripAddHotelOrderVO.getNoticeEmail());
            itripHotelOrder.setBookingDays(
                            DateUtil.getBetweenDates(
                                    itripAddHotelOrderVO.getCheckInDate(),itripAddHotelOrderVO.getCheckOutDate()
                            ).size());
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
                itripHotelOrderService.addItripHotelOrder(itripHotelOrder,itripAddHotelOrderVO.getRoomPrice());
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
        return dto;
    }
}
