package cn.itrip.controller;

import cn.itrip.beans.dtos.Dto;
import cn.itrip.beans.pojo.ItripComment;
import cn.itrip.beans.pojo.ItripHotelOrder;
import cn.itrip.beans.pojo.ItripImage;
import cn.itrip.beans.pojo.ItripUser;
import cn.itrip.beans.vo.order.ItripAddHotelOrderVO;
import cn.itrip.common.DtoUtil;
import cn.itrip.common.ValidationToken;
import cn.itrip.service.itripHotelOrder.ItripHotelOrderService;
import io.swagger.annotations.Api;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/addhotelorder",method= RequestMethod.POST,produces = "application/json")
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
}
