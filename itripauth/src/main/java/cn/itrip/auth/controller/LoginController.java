package cn.itrip.auth.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import springfox.documentation.annotations.ApiIgnore;
import cn.itrip.auth.exception.UserLoginFailedException;
import cn.itrip.auth.service.TokenService;
import cn.itrip.auth.service.UserService;
import cn.itrip.auth.util.MD5;
import cn.itrip.beans.dtos.Dto;
import cn.itrip.beans.pojo.ItripUser;
import cn.itrip.common.DtoUtil;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.ErrorCode;

@Controller
@RequestMapping(value = "/api")
public class LoginController {

	@Resource
	private UserService userService;

	@Resource
	private TokenService tokenService;

	@ApiIgnore
	@RequestMapping("/login")
	public String showLoginForm() {
		return "login";
	}

	@ApiOperation(value = "用户登录",notes="根据用户名、密码进行统一认证")	
	@RequestMapping(value="/dologin",method=RequestMethod.POST)
	public @ResponseBody Dto dologin(
			@ApiParam(required = true, name = "name", value = "用户名",defaultValue="yao.liu2015@bdqn.cn")
			@RequestParam
			String name,
			@ApiParam(required = true, name = "password", value = "密码",defaultValue="111111")
			@RequestParam
			String password,
			HttpServletRequest request) {
		
		if (!EmptyUtils.isEmpty(name) && !EmptyUtils.isEmpty(password)) {
			ItripUser user = null;
			try {				
				user = userService.login(name.trim(), MD5.getMd5(password.trim(), 32));
			} catch (UserLoginFailedException e) {
				return DtoUtil.returnFail(e.getMessage(), ErrorCode.AUTH_AUTHENTICATION_FAILED);				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();				
				return DtoUtil.returnFail(e.getMessage(), ErrorCode.AUTH_UNKNOWN);
			}
			if (EmptyUtils.isNotEmpty(user)) {
				String token = tokenService.generateToken(
						request.getHeader("user-agent"), user);
				tokenService.save(token, user);
				return DtoUtil.returnDataSuccess(token);
			} else {
				return DtoUtil.returnFail("用户名密码错误", ErrorCode.AUTH_AUTHENTICATION_FAILED);				
			}
		} else {
			return DtoUtil.returnFail("参数错误！检查提交的参数名称是否正确。", ErrorCode.AUTH_PARAMETER_ERROR);			
		}		
	}

}
