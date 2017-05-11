package cn.itrip.auth.service;

import cn.itrip.beans.pojo.ItripUser;

public interface TokenService {

	/**
	 * 生成token
	 * @param userAgentInfo
	 * @param user
	 * @return
	 */
	public String generateToken(String agent,ItripUser user);
	/**
	 * 保存用户信息至redis
	 * @param tokenID
	 * @param user
	 */
	public void save(String token,ItripUser user);
	/**
	 * 从redis获取用户信息
	 * @param tokenID
	 * @return
	 */
	public ItripUser load(String token);
	/**
	 * 删除token
	 * @param tokenID
	 */
	public void delete(String token);
	
}
