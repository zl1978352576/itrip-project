package cn.itrip.service.itripUser;
import cn.itrip.beans.pojo.ItripUser;
import java.util.List;
import java.util.Map;
import java.util.List;
import java.util.Map;
import cn.itrip.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface ItripUserService {

    public ItripUser getItripUserById(Long id)throws Exception;

    public List<ItripUser>	getItripUserListByMap(Map<String,Object> param)throws Exception;

    public Integer getItripUserCountByMap(Map<String,Object> param)throws Exception;

    public Integer insertItripUser(ItripUser itripUser)throws Exception;

    public Integer updateItripUser(ItripUser itripUser)throws Exception;

    public Integer deleteItripUserById(Long id)throws Exception;

}
