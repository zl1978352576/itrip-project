package cn.itrip.service.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.itrip.beans.pojo.ItripUserLinkUser;
import cn.itrip.beans.pojo.ItripUserLinkUserExample;
import cn.itrip.service.IItripUserLinkUserService;

public class ClientUserLinkUserServiceImpl implements
		IClientUserLinkUserService {
	
	@Autowired
	private IItripUserLinkUserService userLinkUserService;

	@Override
	public List<ItripUserLinkUser> queryItripUserLinkUserListByUserId(Long userId) throws Exception {
		ItripUserLinkUserExample example = new ItripUserLinkUserExample();
		example.createCriteria().andUserIdEqualTo(Integer.parseInt(userId.toString()));
		return userLinkUserService.queryItripUserLinkUserList(example);
	}

	@Override
	public int addUserLinkUser(ItripUserLinkUser userLinkUser) throws Exception{
		return userLinkUserService.saveOrUpdateItripUserLinkUser(userLinkUser);
	}

	@Override
	public int delUserLinkUser(Long userLinkUser) throws Exception{
		return userLinkUserService.removeItripUserLinkUserByIds(userLinkUser.toString());
	}

}
