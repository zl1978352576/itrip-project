package cn.itrip.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 用户信息Controller
 *
 * 包括API接口：
 * 1、根据UserId查询常用联系人接口
 * 2、指定用户下添加联系人
 * 3、修改指定用户下的联系人信息
 * 4、删除指定用户下的联系人信息
 *
 * Created by hanlu on 2017/5/9.
 */

@Controller
//@Api(value = "API", basePath = "/http://api.itrap.com/api")
@RequestMapping(value="/api/userinfo")
public class UserInfoController {
    private Logger logger = Logger.getLogger(UserInfoController.class);
}
