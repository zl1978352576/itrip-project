package cn.itrip.auth.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itrip.auth.service.MailService;
import cn.itrip.auth.service.UserService;
import cn.itrip.auth.util.MD5;
import cn.itrip.beans.dtos.Dto;
import cn.itrip.beans.pojo.ItripUser;
import cn.itrip.common.ErrorCode;

@Controller
public class UserController {
	@Resource
	private UserService userService;
	
	@RequestMapping("/register")
	public String showRegisterForm() {
		return "register";
	}

	@RequestMapping("/doregister")
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

	@RequestMapping("/ckusr")
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
	
	@RequestMapping("/activate")
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
