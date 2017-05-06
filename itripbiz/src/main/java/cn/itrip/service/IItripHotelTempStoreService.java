package cn.itrip.service;
import cn.itrip.beans.pojo.ItripHotelTempStore;
import java.util.List;
import java.util.Map;
import cn.itrip.beans.pojo.ItripHotelTempStoreExample;
import cn.itrip.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface IItripHotelTempStoreService {

    public int saveOrUpdateItripHotelTempStore(ItripHotelTempStore obj)throws Exception;

    public ItripHotelTempStore queryItripHotelTempStoreById(Long id)throws Exception;

    public int removeItripHotelTempStoreByIds(String ids)throws Exception;

    public List<ItripHotelTempStore> queryItripHotelTempStoreList(ItripHotelTempStoreExample example)throws Exception;

    public Page<ItripHotelTempStore> queryItripHotelTempStorePage(Map params)throws Exception;
}
