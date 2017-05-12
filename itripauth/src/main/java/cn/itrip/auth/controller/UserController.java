package cn.itrip.auth.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import springfox.documentation.annotations.ApiIgnore;
import cn.itrip.auth.service.MailService;
import cn.itrip.auth.service.UserService;
import cn.itrip.auth.util.MD5;
import cn.itrip.beans.dtos.Dto;
import cn.itrip.beans.pojo.ItripUser;
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

	@ApiOperation(value="用户注册",notes="使用邮箱注册，参数示例:{\"属性名1\":\"属性值1\",\"属性名2\":\"属性值2\",……}")
	@ApiImplicitParam(name="user",value="用户实体",required=true,dataType="ItripUser")
	@RequestMapping(value="/doregister",method=RequestMethod.POST)
	public @ResponseBody
	Dto doRegister(ItripUser user) {
		Dto dto = new Dto();
		try {
			if (null == userService.findByUsername(user.getUserCode())) {
				user.setUserPassword(MD5.getMd5(user.getUserPassword(), 32));
				user.setUserName("");
				userService.itriptxCreateUser(user);				
				dto.setSuccess("true");								
			}else
			{
				dto.setSuccess("false");
				dto.setErrorCode(ErrorCode.AUTH_USER_ALREADY_EXISTS);
				dto.setMsg("用户已存在，注册失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			dto.setSuccess("false");
			dto.setErrorCode(ErrorCode.AUTH_UNKNOWN);
			dto.setMsg(e.getMessage());
		}
		return dto;
	}
	@ApiOperation(value="用户验证",notes="验证是否已存在该用户名")
	@ApiImplicitParam(name="name",value="用户注册名称",required=true,dataType="String")
	@RequestMapping(value="/ckusr",method=RequestMethod.GET)
	public @ResponseBody
	Dto checkUser(String name) {
		Dto dto = new Dto();
		try {
			if (null == userService.findByUsername(name))
			{
				dto.setSuccess("true");// 用户名可用
				dto.setMsg("用户名可用");
			}
			else
			{
				dto.setSuccess("true");
				dto.setMsg("用户名不可用");
			}
		} catch (Exception e) {
			e.printStackTrace();
			dto.setSuccess("false");
			dto.setErrorCode(ErrorCode.AUTH_UNKNOWN);
			dto.setMsg(e.getMessage());
		}
		return dto;
	}
	
	@ApiOperation(value="注册用户激活",notes="邮箱激活")
	@ApiImplicitParams({
		@ApiImplicitParam(name="user",value="用户注册名",required=true,dataType="String"),
		@ApiImplicitParam(name="code",value="激活码",required=true,dataType="String")
	})	
	@RequestMapping(value="/activate",method=RequestMethod.PUT)
	public @ResponseBody Dto activate(String user,String code){	
		Dto dto=new Dto();
		try {
			if(userService.activate(user, code))
			{
				dto.setSuccess("true");
				dto.setMsg("激活成功");				
			}else{
				dto.setSuccess("true");
				dto.setMsg("激活失败");	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			dto.setSuccess("false");
			dto.setErrorCode(ErrorCode.AUTH_ACTIVATE_FAILED);
			dto.setMsg("激活失败");
		}
		return dto;
	} 
}
