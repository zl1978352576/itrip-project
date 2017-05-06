package cn.itrip.service;
import cn.itrip.dao.ItripHotelMapper;
import cn.itrip.beans.pojo.ItripHotel;
import cn.itrip.beans.pojo.ItripHotelExample;
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
public class ItripHotelServiceImpl implements IItripHotelService {

    @Autowired
    private ItripHotelMapper itripHotelMapper;

    @Autowired
    private SelectService<ItripHotel> selectService;

    public int saveOrUpdateItripHotel(ItripHotel itripHotel) throws Exception{
        int flag=0;
        if(EmptyUtils.isNotEmpty(itripHotel.getId())){
            itripHotel.setModifyDate(new Date());
            flag=itripHotelMapper.updateByPrimaryKeySelective(itripHotel);
        }else{
            itripHotel.setCreationDate(new Date());
            flag=itripHotelMapper.insert(itripHotel);
        }
        return flag;
    }

    public ItripHotel queryItripHotelById(Long id) throws Exception{
        return itripHotelMapper.selectByPrimaryKey(id);
    }

    public int removeItripHotelByIds(String ids)throws Exception{
        ItripHotelExample itripHotelExample=new ItripHotelExample();
        List<Long> idsList=new ArrayList<Long>();
        String idsArray[]=ids.split(",");
        for(int i=0;i<idsArray.length;i++){
            idsList.add(Long.parseLong(idsArray[i]));
        }
        itripHotelExample.createCriteria().andIdIn(idsList);
        int flag=itripHotelMapper.deleteByExample(itripHotelExample);
        return flag;
    }

    public List<ItripHotel> queryItripHotelList(ItripHotelExample example)throws Exception{
        return itripHotelMapper.selectByExample(example);
    }

    public Page<ItripHotel> queryItripHotelPage(Map params)throws Exception{
        int page = 0;
        if (EmptyUtils.isNotEmpty(params.get("page"))) {
            page = Integer.parseInt(params.get("page").toString());
        }
        params.put("page", page);
        String countSqlId = "ItripHotel.getItripHotelCount";
        String listSqlId = "ItripHotel.getItripHotelPage";
        Page<ItripHotel> result = selectService.getPage(countSqlId, listSqlId, params);
        return result;
    }
}
