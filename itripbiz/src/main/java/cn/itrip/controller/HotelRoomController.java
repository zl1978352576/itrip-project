package cn.itrip.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 酒店房间Controller
 *
 * 包括API接口：
 * 1、根据入住时间，退房时间 等条件查询酒店房间列表
 * 2、根据type 和target id 查询酒店房间图片
 * 3、查询床型的接口
 *
 *
 * 注：错误码（100301 ——100400）
 *
 * Created by hanlu on 2017/5/9.
 */

@Controller
//@Api(value = "API", basePath = "/http://api.itrap.com/api")
@RequestMapping(value="/api/hotel")
public class HotelRoomController {
    private Logger logger = Logger.getLogger(HotelRoomController.class);
}
