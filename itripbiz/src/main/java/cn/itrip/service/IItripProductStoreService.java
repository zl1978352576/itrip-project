package cn.itrip.service;
import cn.itrip.beans.pojo.ItripProductStore;
import java.util.List;
import java.util.Map;
import cn.itrip.beans.pojo.ItripProductStoreExample;
import cn.itrip.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface IItripProductStoreService {

    public int saveOrUpdateItripProductStore(ItripProductStore obj)throws Exception;

    public ItripProductStore queryItripProductStoreById(Long id)throws Exception;

    public int removeItripProductStoreByIds(String ids)throws Exception;

    public List<ItripProductStore> queryItripProductStoreList(ItripProductStoreExample example)throws Exception;

    public Page<ItripProductStore> queryItripProductStorePage(Map params)throws Exception;
}
