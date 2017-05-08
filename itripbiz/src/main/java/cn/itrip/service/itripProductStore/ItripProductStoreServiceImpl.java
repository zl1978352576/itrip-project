package cn.itrip.service.itripProductStore;
import cn.itrip.dao.itripProductStore.ItripProductStoreMapper;
import cn.itrip.beans.pojo.ItripProductStore;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ItripProductStoreServiceImpl implements ItripProductStoreService {

    @Resource
    private ItripProductStoreMapper itripProductStoreMapper;

    public ItripProductStore getItripProductStoreById(Long id)throws Exception{
        return itripProductStoreMapper.getItripProductStoreById(id);
    }

    public List<ItripProductStore>	getItripProductStoreListByMap(Map<String,Object> param)throws Exception{
        return itripProductStoreMapper.getItripProductStoreListByMap(param);
    }

    public Integer getItripProductStoreCountByMap(Map<String,Object> param)throws Exception{
        return itripProductStoreMapper.getItripProductStoreCountByMap(param);
    }

    public Integer itriptxAddItripProductStore(ItripProductStore itripProductStore)throws Exception{
            itripProductStore.setCreationDate(new Date());
            return itripProductStoreMapper.insertItripProductStore(itripProductStore);
    }

    public Integer itriptxModifyItripProductStore(ItripProductStore itripProductStore)throws Exception{
        itripProductStore.setModifyDate(new Date());
        return itripProductStoreMapper.updateItripProductStore(itripProductStore);
    }

    public Integer itriptxDeleteItripProductStoreById(Long id)throws Exception{
        return itripProductStoreMapper.deleteItripProductStoreById(id);
    }

}
