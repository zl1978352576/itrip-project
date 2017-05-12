package cn.itrip.auth.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import springfox.documentation.annotations.ApiIgnore;
import cn.itrip.auth.service.MailService;
import cn.itrip.auth.service.UserService;
import cn.itrip.auth.util.MD5;
import cn.itrip.beans.dtos.Dto;
import cn.itrip.beans.pojo.ItripUser;
import cn.itrip.common.DtoUtil;
import cn.itrip.common.ErrorCode;

@Controller
@RequestMapping(value = "/api")
public class UserController {
	@Resource
	private UserService userService;
	
	@ApiIgnore
	@RequestMapping("/register")
	public String showRegisterForm() {
		return "register";
	}

	@ApiOperation(value="用户注册",notes="使用邮箱注册  示例:{\"userCode\":\"test@bdqn.cn\",\"userPassword\":\"111111\"}")
	@ApiImplicitParam(name="user",value="用户实体",required=true,dataType="ItripUser")
	@RequestMapping(value="/doregister",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody
	Dto doRegister(@RequestBody ItripUser user) {		
		try {
			if (null == userService.findByUsername(user.getUserCode())) {
				user.setUserPassword(MD5.getMd5(user.getUserPassword(), 32));
				user.setUserName("");
				userService.itriptxCreateUser(user);				
				return DtoUtil.returnSuccess();							
			}else
			{
				return DtoUtil.returnFail("用户已存在，注册失败", ErrorCode.AUTH_USER_ALREADY_EXISTS);				
			}
		} catch (Exception e) {
			e.printStackTrace();		
			return DtoUtil.returnFail(e.getMessage(), ErrorCode.AUTH_UNKNOWN);
		}
		
	}
	@ApiOperation(value="用户名验证",notes="验证是否已存在该用户名")	
	@RequestMapping(value="/ckusr",method=RequestMethod.GET)
	public @ResponseBody
	Dto checkUser(
			@ApiParam(name="name",value="被检查的用户名",defaultValue="test@bdqn.cn")
			@RequestParam String name) {		
		try {
			if (null == userService.findByUsername(name))
			{			
				return DtoUtil.returnSuccess("用户名可用");
			}
			else
			{
				return DtoUtil.returnSuccess("用户名不可用");
			}
		} catch (Exception e) {
			e.printStackTrace();			
			return DtoUtil.returnFail(e.getMessage(), ErrorCode.AUTH_UNKNOWN);
		}		
	}
	
	@ApiOperation(value="注册用户激活",notes="邮箱激活")	
	@RequestMapping(value="/activate",method=RequestMethod.PUT)
	public @ResponseBody Dto activate(
			@ApiParam(name="user",value="注册邮箱地址",defaultValue="test@bdqn.cn")
			@RequestParam String user,
			@ApiParam(name="code",value="激活码",defaultValue="018f9a8b2381839ee6f40ab2207c0cfe")
			@RequestParam String code){			
		try {
			if(userService.activate(user, code))
			{	
				return DtoUtil.returnSuccess("激活成功");
			}else{
				return DtoUtil.returnSuccess("激活失败");	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
			return DtoUtil.returnFail("激活失败", ErrorCode.AUTH_ACTIVATE_FAILED);
		}		
	} 
}
