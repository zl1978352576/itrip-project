package cn.itrip.service;
import cn.itrip.beans.pojo.ItripUser;
import java.util.List;
import java.util.Map;
import cn.itrip.beans.pojo.ItripUserExample;
import cn.itrip.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface IItripUserService {

    public int saveOrUpdateItripUser(ItripUser obj)throws Exception;

    public ItripUser queryItripUserById(Long id)throws Exception;

    public int removeItripUserByIds(String ids)throws Exception;

    public List<ItripUser> queryItripUserList(ItripUserExample example)throws Exception;

    public Page<ItripUser> queryItripUserPage(Map params)throws Exception;
}
