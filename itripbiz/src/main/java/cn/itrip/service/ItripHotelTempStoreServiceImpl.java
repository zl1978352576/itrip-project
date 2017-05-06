package cn.itrip.service;
import cn.itrip.dao.ItripHotelTempStoreMapper;
import cn.itrip.beans.pojo.ItripHotelTempStore;
import cn.itrip.beans.pojo.ItripHotelTempStoreExample;
import cn.itrip.service.common.SelectService;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ItripHotelTempStoreServiceImpl implements IItripHotelTempStoreService {

    @Autowired
    private ItripHotelTempStoreMapper itripHotelTempStoreMapper;

    @Autowired
    private SelectService<ItripHotelTempStore> selectService;

    public int saveOrUpdateItripHotelTempStore(ItripHotelTempStore itripHotelTempStore) throws Exception{
        int flag=0;
        if(EmptyUtils.isNotEmpty(itripHotelTempStore.getId())){
            itripHotelTempStore.setModifyDate(new Date());
            flag=itripHotelTempStoreMapper.updateByPrimaryKeySelective(itripHotelTempStore);
        }else{
            itripHotelTempStore.setCreationDate(new Date());
            flag=itripHotelTempStoreMapper.insert(itripHotelTempStore);
        }
        return flag;
    }

    public ItripHotelTempStore queryItripHotelTempStoreById(Long id) throws Exception{
        return itripHotelTempStoreMapper.selectByPrimaryKey(id);
    }

    public int removeItripHotelTempStoreByIds(String ids)throws Exception{
        ItripHotelTempStoreExample itripHotelTempStoreExample=new ItripHotelTempStoreExample();
        List<Long> idsList=new ArrayList<Long>();
        String idsArray[]=ids.split(",");
        for(int i=0;i<idsArray.length;i++){
            idsList.add(Long.parseLong(idsArray[i]));
        }
        itripHotelTempStoreExample.createCriteria().andIdIn(idsList);
        int flag=itripHotelTempStoreMapper.deleteByExample(itripHotelTempStoreExample);
        return flag;
    }

    public List<ItripHotelTempStore> queryItripHotelTempStoreList(ItripHotelTempStoreExample example)throws Exception{
        return itripHotelTempStoreMapper.selectByExample(example);
    }

    public Page<ItripHotelTempStore> queryItripHotelTempStorePage(Map params)throws Exception{
        int page = 0;
        if (EmptyUtils.isNotEmpty(params.get("page"))) {
            page = Integer.parseInt(params.get("page").toString());
        }
        params.put("page", page);
        String countSqlId = "ItripHotelTempStore.getItripHotelTempStoreCount";
        String listSqlId = "ItripHotelTempStore.getItripHotelTempStorePage";
        Page<ItripHotelTempStore> result = selectService.getPage(countSqlId, listSqlId, params);
        return result;
    }
}
