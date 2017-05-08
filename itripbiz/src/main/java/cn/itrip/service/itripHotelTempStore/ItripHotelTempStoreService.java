package cn.itrip.service.itripHotelTempStore;
import cn.itrip.beans.pojo.ItripHotelTempStore;
import java.util.List;
import java.util.Map;
import java.util.List;
import java.util.Map;
import cn.itrip.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface ItripHotelTempStoreService {

    public ItripHotelTempStore getItripHotelTempStoreById(Long id)throws Exception;

    public List<ItripHotelTempStore>	getItripHotelTempStoreListByMap(Map<String,Object> param)throws Exception;

    public Integer getItripHotelTempStoreCountByMap(Map<String,Object> param)throws Exception;

    public Integer insertItripHotelTempStore(ItripHotelTempStore itripHotelTempStore)throws Exception;

    public Integer updateItripHotelTempStore(ItripHotelTempStore itripHotelTempStore)throws Exception;

    public Integer deleteItripHotelTempStoreById(Long id)throws Exception;

}
