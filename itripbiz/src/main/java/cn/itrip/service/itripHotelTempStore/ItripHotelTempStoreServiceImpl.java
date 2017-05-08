package cn.itrip.service.itripHotelTempStore;
import cn.itrip.dao.itripHotelTempStore.ItripHotelTempStoreMapper;
import cn.itrip.beans.pojo.ItripHotelTempStore;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ItripHotelTempStoreServiceImpl implements ItripHotelTempStoreService {

    @Resource
    private ItripHotelTempStoreMapper itripHotelTempStoreMapper;

    public ItripHotelTempStore getItripHotelTempStoreById(Long id)throws Exception{
        return itripHotelTempStoreMapper.getItripHotelTempStoreById(id);
    }

    public List<ItripHotelTempStore>	getItripHotelTempStoreListByMap(Map<String,Object> param)throws Exception{
        return itripHotelTempStoreMapper.getItripHotelTempStoreListByMap(param);
    }

    public Integer getItripHotelTempStoreCountByMap(Map<String,Object> param)throws Exception{
        return itripHotelTempStoreMapper.getItripHotelTempStoreCountByMap(param);
    }

    public Integer insertItripHotelTempStore(ItripHotelTempStore itripHotelTempStore)throws Exception{
            itripHotelTempStore.setCreationDate(new Date());
            return itripHotelTempStoreMapper.updateItripHotelTempStore(itripHotelTempStore);
    }

    public Integer updateItripHotelTempStore(ItripHotelTempStore itripHotelTempStore)throws Exception{
        itripHotelTempStore.setModifyDate(new Date());
        return itripHotelTempStoreMapper.updateItripHotelTempStore(itripHotelTempStore);
    }

    public Integer deleteItripHotelTempStoreById(Long id)throws Exception{
        return itripHotelTempStoreMapper.deleteItripHotelTempStoreById(id);
    }

}
