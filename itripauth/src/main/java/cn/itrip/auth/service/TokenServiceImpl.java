package cn.itrip.auth.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itrip.auth.util.MD5;
import cn.itrip.auth.util.UserAgentUtil;
import cn.itrip.beans.pojo.ItripUser;
import cn.itrip.common.RedisAPI;

import com.alibaba.fastjson.JSON;

import cz.mallat.uasparser.UserAgentInfo;

@Service("tokenService")
public class TokenServiceImpl implements TokenService {

	@Resource
	private RedisAPI redisAPI;
	private int expire=30*60;//30min
	
	public int getExpire() {
		return expire;
	}

	public void setExpire(int expire) {
		this.expire = expire;
	}

	/**
	 * PC：PC-USERCODE-USERID-CREATIONDATE-RONDEM[6位]
	 * Android：ANDROID-USERCODE-USERID-CREATIONDATE-RONDEM[6位]
	 */
	@Override
	public String generateToken(String agent,ItripUser user) {
		// TODO Auto-generated method stub
		try {
			UserAgentInfo userAgentInfo = UserAgentUtil.uasParser.parse(agent);
			StringBuilder sb=new StringBuilder();		
			if(userAgentInfo.getDeviceType().equals(UserAgentInfo.UNKNOWN))
			{
				if(UserAgentUtil.CheckAgent(agent)){
					sb.append("MOBILE-");
				}else{
					sb.append("PC-");
				}
			}else if(userAgentInfo.getDeviceType().equals("Personal computer")){
					sb.append("PC-");				
			}else
				sb.append("MOBILE-");
			sb.append(user.getUserCode()+"-");
			sb.append(user.getId()+"-");
			sb.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+"-");
			sb.append(MD5.getMd5(agent,6));//识别客户端的简化实现——6位MD5码
			 
			return sb.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void save(String token, ItripUser user) {
		if(token.startsWith("PC-"))
			redisAPI.set("token:"+token, expire, JSON.toJSONString(user));
		else
			redisAPI.set("token:"+token, JSON.toJSONString(user));//手机认证信息永不失效
	}

	@Override
	public ItripUser load(String token) {
		// TODO Auto-generated method stub		
		return JSON.parseObject(redisAPI.get(token), ItripUser.class);
	}

	@Override
	public void delete(String token) {
		// TODO Auto-generated method stub
		if(redisAPI.exist(token))
			redisAPI.delete(token);
	}

}
