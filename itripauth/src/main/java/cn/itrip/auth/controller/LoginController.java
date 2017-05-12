package cn.itrip.auth.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import springfox.documentation.annotations.ApiIgnore;
import cn.itrip.auth.exception.UserLoginFailedException;
import cn.itrip.auth.service.TokenService;
import cn.itrip.auth.service.UserService;
import cn.itrip.auth.util.MD5;
import cn.itrip.beans.dtos.Dto;
import cn.itrip.beans.pojo.ItripUser;
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
	@ApiImplicitParams({
        @ApiImplicitParam(name = "name", value = "用户名(ItripUser.userCode)", required = true, dataType = "String"),
        @ApiImplicitParam(name = "password", value = "密码(ItripUser.userPassword)", required = true, dataType = "String")
	})
	@RequestMapping(value="/dologin",method=RequestMethod.POST)
	public @ResponseBody Dto dologin(String name, String password,
			HttpServletRequest request) {
		Dto dto = new Dto();
		if (!EmptyUtils.isEmpty(name) && !EmptyUtils.isEmpty(password)) {
			ItripUser user = null;
			try {				
				user = userService.login(name.trim(), MD5.getMd5(password.trim(), 32));
			} catch (UserLoginFailedException e) {
				dto.setSuccess("true");
				dto.setErrorCode(ErrorCode.AUTH_AUTHENTICATION_FAILED);
				dto.setMsg(e.getMessage());
				return dto;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				dto.setSuccess("false");
				dto.setErrorCode(ErrorCode.AUTH_UNKNOWN);
				dto.setMsg("系统错误");
				return dto;
			}
			if (EmptyUtils.isNotEmpty(user)) {
				String token = tokenService.generateToken(
						request.getHeader("user-agent"), user);
				tokenService.save(token, user);
				dto.setSuccess("true");
				dto.setData(token);
			} else {
				dto.setSuccess("true");
				dto.setErrorCode(ErrorCode.AUTH_AUTHENTICATION_FAILED);
				dto.setMsg("用户名密码错误");
			}
		} else {
			dto.setSuccess("true");
			dto.setErrorCode(ErrorCode.AUTH_PARAMETER_ERROR);
			dto.setMsg("参数错误！检查提交的参数名称是否正确。");
		}
		return dto;
	}

}
