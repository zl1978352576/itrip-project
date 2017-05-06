package cn.itrip.service;
import cn.itrip.beans.pojo.ItripOrderLinkUser;
import java.util.List;
import java.util.Map;
import cn.itrip.beans.pojo.ItripOrderLinkUserExample;
import cn.itrip.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface IItripOrderLinkUserService {

    public int saveOrUpdateItripOrderLinkUser(ItripOrderLinkUser obj)throws Exception;

    public ItripOrderLinkUser queryItripOrderLinkUserById(Long id)throws Exception;

    public int removeItripOrderLinkUserByIds(String ids)throws Exception;

    public List<ItripOrderLinkUser> queryItripOrderLinkUserList(ItripOrderLinkUserExample example)throws Exception;

    public Page<ItripOrderLinkUser> queryItripOrderLinkUserPage(Map params)throws Exception;
}
