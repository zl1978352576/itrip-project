package cn.itrip.controller;

import cn.itrip.beans.dtos.Dto;
import cn.itrip.beans.pojo.ItripHotelRoom;
import cn.itrip.beans.vo.ItripImageVO;
import cn.itrip.beans.vo.hotelroom.ItripHotelRoomVO;
import cn.itrip.common.DtoUtil;
import cn.itrip.service.itripHotelRoom.ItripHotelRoomService;
import cn.itrip.service.itripImage.ItripImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 酒店房间Controller
 * <p/>
 * 包括API接口：
 * 1、根据入住时间，退房时间 等条件查询酒店房间列表
 * 2、根据type 和target id 查询酒店房间图片
 * 3、查询床型的接口
 * <p/>
 * <p/>
 * 注：错误码（100301 ——100400）
 * <p/>
 * Created by hanlu on 2017/5/9.
 */

@Controller
@Api(value = "API", basePath = "/http://api.itrap.com/api")
@RequestMapping(value = "/api/hotelroom")
public class HotelRoomController {
    private Logger logger = Logger.getLogger(HotelRoomController.class);

    @Resource
    private ItripImageService itripImageService;

    @Resource
    private ItripHotelRoomService itripHotelRoomService;

    @ApiOperation(value = "根据targetId查询酒店房型图片(type=1)", httpMethod = "GET",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "根据酒店房型ID查询酒店房型图片" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>100301 : 获取酒店房型图片失败 </p>" +
            "<p>100302 : 酒店房型id不能为空</p>")
    @RequestMapping(value = "/getimg/{targetId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Dto<Object> getImgByTargetId(@ApiParam(required = true, name = "targetId", value = "酒店房型ID") @PathVariable String targetId) {
        Dto<Object> dto = new Dto<Object>();
        logger.debug("getImgBytargetId targetId : " + targetId);
        if (null != targetId && !"".equals(targetId)) {
            List<ItripImageVO> itripImageVOList = null;
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("type", "1");
            param.put("targetId", targetId);
            try {
                itripImageVOList = itripImageService.getItripImageListByMap(param);
                dto = DtoUtil.returnSuccess("获取酒店图片房型成功", itripImageVOList);
            } catch (Exception e) {
                e.printStackTrace();
                dto = DtoUtil.returnFail("获取酒店房型图片失败", "100301");
            }

        } else {
            dto = DtoUtil.returnFail("酒店房型id不能为空", "100302");
        }
        return dto;
    }

    @ApiOperation(value = "根据酒店id查询酒店房间列表", httpMethod = "POST",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "根据酒店id查询酒店房间列表" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>100303 : 酒店id不能为空</p>" +
            "<p>100304 : 系统异常</p>")
    @RequestMapping(value = "/queryhotelroombyhotel/{hotelId}", method = RequestMethod.GET, produces = "application/json")
    public Dto<List<ItripHotelRoomVO>> queryHotelRoomByHotel(@ApiParam(required = true, name = "hotelId", value = "酒店房型ID") @PathVariable String hotelId) {
        Dto<List<ItripHotelRoomVO>> dto = new Dto<List<ItripHotelRoomVO>>();
        try{
            Map<String,Object> param=new HashMap<String,Object>();
            param.put("hotelId",hotelId);
            List<ItripHotelRoomVO> temp=itripHotelRoomService.getItripHotelRoomListByMap(param);
            dto.setData(temp);
        }catch (Exception e){
            dto = DtoUtil.returnFail("获取酒店房型图片失败", "100301");
        }finally {
            return  dto;
        }
    }
}

