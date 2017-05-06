package cn.itrip.service;
import cn.itrip.dao.ItripProductStoreMapper;
import cn.itrip.beans.pojo.ItripProductStore;
import cn.itrip.beans.pojo.ItripProductStoreExample;
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
public class ItripProductStoreServiceImpl implements IItripProductStoreService {

    @Autowired
    private ItripProductStoreMapper itripProductStoreMapper;

    @Autowired
    private SelectService<ItripProductStore> selectService;

    public int saveOrUpdateItripProductStore(ItripProductStore itripProductStore) throws Exception{
        int flag=0;
        if(EmptyUtils.isNotEmpty(itripProductStore.getId())){
            itripProductStore.setModifyDate(new Date());
            flag=itripProductStoreMapper.updateByPrimaryKeySelective(itripProductStore);
        }else{
            itripProductStore.setCreationDate(new Date());
            flag=itripProductStoreMapper.insert(itripProductStore);
        }
        return flag;
    }

    public ItripProductStore queryItripProductStoreById(Long id) throws Exception{
        return itripProductStoreMapper.selectByPrimaryKey(id);
    }

    public int removeItripProductStoreByIds(String ids)throws Exception{
        ItripProductStoreExample itripProductStoreExample=new ItripProductStoreExample();
        List<Long> idsList=new ArrayList<Long>();
        String idsArray[]=ids.split(",");
        for(int i=0;i<idsArray.length;i++){
            idsList.add(Long.parseLong(idsArray[i]));
        }
        itripProductStoreExample.createCriteria().andIdIn(idsList);
        int flag=itripProductStoreMapper.deleteByExample(itripProductStoreExample);
        return flag;
    }

    public List<ItripProductStore> queryItripProductStoreList(ItripProductStoreExample example)throws Exception{
        return itripProductStoreMapper.selectByExample(example);
    }

    public Page<ItripProductStore> queryItripProductStorePage(Map params)throws Exception{
        int page = 0;
        if (EmptyUtils.isNotEmpty(params.get("page"))) {
            page = Integer.parseInt(params.get("page").toString());
        }
        params.put("page", page);
        String countSqlId = "ItripProductStore.getItripProductStoreCount";
        String listSqlId = "ItripProductStore.getItripProductStorePage";
        Page<ItripProductStore> result = selectService.getPage(countSqlId, listSqlId, params);
        return result;
    }
}
