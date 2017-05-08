package cn.itrip.service.itripProductStore;
import cn.itrip.beans.pojo.ItripProductStore;
import java.util.List;
import java.util.Map;
import java.util.List;
import java.util.Map;
import cn.itrip.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface ItripProductStoreService {

    public ItripProductStore getItripProductStoreById(Long id)throws Exception;

    public List<ItripProductStore>	getItripProductStoreListByMap(Map<String,Object> param)throws Exception;

    public Integer getItripProductStoreCountByMap(Map<String,Object> param)throws Exception;

    public Integer insertItripProductStore(ItripProductStore itripProductStore)throws Exception;

    public Integer updateItripProductStore(ItripProductStore itripProductStore)throws Exception;

    public Integer deleteItripProductStoreById(Long id)throws Exception;

}
