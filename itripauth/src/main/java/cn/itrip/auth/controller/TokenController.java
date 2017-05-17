package cn.itrip.auth.controller;

import java.util.Calendar;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itrip.auth.exception.TokenValidationFailedException;
import cn.itrip.auth.service.TokenService;
import cn.itrip.beans.dtos.Dto;
import cn.itrip.beans.vo.ItripTokenVO;
import cn.itrip.common.DtoUtil;
import cn.itrip.common.ErrorCode;

@Controller
@RequestMapping(value = "/api")
public class TokenController {

	@Resource
	private TokenService tokenService;
	/**
	 * 置换token
	 * 
	 * @return 新的token信息
	 */
	@ApiOperation(value = "客户端置换token", httpMethod = "POST", 
			protocols = "HTTP", produces = "application/json", 
			response = Dto.class, 
			notes = "提供客户端置换token操作，服务器需要获取客户端header中的token串")
	@ApiImplicitParam(paramType="header",required=true,name="token",value="用户认证凭据",defaultValue="PC-yao.liu2015@bdqn.cn-8-20170516141821-d4f514")
	@RequestMapping(value = "/retoken", method = RequestMethod.POST,produces= "application/json")
	public @ResponseBody Dto replace(HttpServletRequest request) {
		/*
		 * 请求格式 
		 * $.ajax({
				headers:{
				          Accept:"application/json;charset=utf-8",
				          Content-Type:"application/json;charset=utf-8",
				          token:"lkfajsdlkfjawoier29"// 从cookie中获取
				},
				type："post",
				.....
				})
		 * 
		 * */
		String agent=request.getHeader("user-agent");
		String token=request.getHeader("token");
		try {
			String newToken=tokenService.replaceToken(agent, token);
			//返回ItripTokenVO
			ItripTokenVO tokenVO=new ItripTokenVO(newToken,
					Calendar.getInstance().getTimeInMillis()+TokenService.SESSION_TIMEOUT*1000,//2h有效期
					Calendar.getInstance().getTimeInMillis());			
			return DtoUtil.returnDataSuccess(tokenVO);
		} catch (TokenValidationFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return DtoUtil.returnFail(e.getMessage(), ErrorCode.AUTH_REPLACEMENT_FAILED);
		}		
	}
}
