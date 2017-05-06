package cn.itrip.service;
import cn.itrip.dao.ItripHotelExtendPropertyMapper;
import cn.itrip.beans.pojo.ItripHotelExtendProperty;
import cn.itrip.beans.pojo.ItripHotelExtendPropertyExample;
import cn.itrip.service.common.SelectService;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ItripHotelExtendPropertyServiceImpl implements IItripHotelExtendPropertyService {

    @Autowired
    private ItripHotelExtendPropertyMapper itripHotelExtendPropertyMapper;

    @Autowired
    private SelectService<ItripHotelExtendProperty> selectService;

    public int saveOrUpdateItripHotelExtendProperty(ItripHotelExtendProperty itripHotelExtendProperty) throws Exception{
        int flag=0;
        if(EmptyUtils.isNotEmpty(itripHotelExtendProperty.getId())){
            flag=itripHotelExtendPropertyMapper.updateByPrimaryKeySelective(itripHotelExtendProperty);
        }else{
            flag=itripHotelExtendPropertyMapper.insert(itripHotelExtendProperty);
        }
        return flag;
    }

    public ItripHotelExtendProperty queryItripHotelExtendPropertyById(Long id) throws Exception{
        return itripHotelExtendPropertyMapper.selectByPrimaryKey(id);
    }

    public int removeItripHotelExtendPropertyByIds(String ids)throws Exception{
        ItripHotelExtendPropertyExample itripHotelExtendPropertyExample=new ItripHotelExtendPropertyExample();
        List<Long> idsList=new ArrayList<Long>();
        String idsArray[]=ids.split(",");
        for(int i=0;i<idsArray.length;i++){
            idsList.add(Long.parseLong(idsArray[i]));
        }
        itripHotelExtendPropertyExample.createCriteria().andIdIn(idsList);
        int flag=itripHotelExtendPropertyMapper.deleteByExample(itripHotelExtendPropertyExample);
        return flag;
    }

    public List<ItripHotelExtendProperty> queryItripHotelExtendPropertyList(ItripHotelExtendPropertyExample example)throws Exception{
        return itripHotelExtendPropertyMapper.selectByExample(example);
    }

    public Page<ItripHotelExtendProperty> queryItripHotelExtendPropertyPage(Map params)throws Exception{
        int page = 0;
        if (EmptyUtils.isNotEmpty(params.get("page"))) {
            page = Integer.parseInt(params.get("page").toString());
        }
        params.put("page", page);
        String countSqlId = "ItripHotelExtendProperty.getItripHotelExtendPropertyCount";
        String listSqlId = "ItripHotelExtendProperty.getItripHotelExtendPropertyPage";
        Page<ItripHotelExtendProperty> result = selectService.getPage(countSqlId, listSqlId, params);
        return result;
    }
}
