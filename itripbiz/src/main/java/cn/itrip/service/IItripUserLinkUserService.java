package cn.itrip.service;
import cn.itrip.beans.pojo.ItripUserLinkUser;
import java.util.List;
import java.util.Map;
import cn.itrip.beans.pojo.ItripUserLinkUserExample;
import cn.itrip.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface IItripUserLinkUserService {

    public int saveOrUpdateItripUserLinkUser(ItripUserLinkUser obj)throws Exception;

    public ItripUserLinkUser queryItripUserLinkUserById(Long id)throws Exception;

    public int removeItripUserLinkUserByIds(String ids)throws Exception;

    public List<ItripUserLinkUser> queryItripUserLinkUserList(ItripUserLinkUserExample example)throws Exception;

    public Page<ItripUserLinkUser> queryItripUserLinkUserPage(Map params)throws Exception;
}
