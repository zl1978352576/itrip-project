package cn.itrip.service.client;

import java.util.List;

import cn.itrip.beans.pojo.ItripUserLinkUser;

/**
 * Created by hai.dong on 17-4-26.
 */
public interface IClientUserLinkUserService {
	
	/**
	 * 添加常用联系人
	 * @param userLinkUser
	 * @return
	 * @throws Exception
	 */
	public int addUserLinkUser(ItripUserLinkUser userLinkUser) throws Exception;
	
	/**
	 * 删除常用联系人
	 * @param userLinkUser
	 * @return
	 * @throws Exception
	 */
	public int delUserLinkUser(Long userLinkUser)  throws Exception;
	
	/**
	 * 根据和当前登录人相关的常用联系人
	 * @param userId
	 * @return
	 * @throws Exception
	 */
    public List<ItripUserLinkUser> queryItripUserLinkUserListByUserId(Long userId)throws Exception;

}
