package cn.itrip.service;
import cn.itrip.dao.ItripHotelTradingAreaMapper;
import cn.itrip.beans.pojo.ItripHotelTradingArea;
import cn.itrip.beans.pojo.ItripHotelTradingAreaExample;
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
public class ItripHotelTradingAreaServiceImpl implements IItripHotelTradingAreaService {

    @Autowired
    private ItripHotelTradingAreaMapper itripHotelTradingAreaMapper;

    @Autowired
    private SelectService<ItripHotelTradingArea> selectService;

    public int saveOrUpdateItripHotelTradingArea(ItripHotelTradingArea itripHotelTradingArea) throws Exception{
        int flag=0;
        if(EmptyUtils.isNotEmpty(itripHotelTradingArea.getId())){
            itripHotelTradingArea.setModifyDate(new Date());
            flag=itripHotelTradingAreaMapper.updateByPrimaryKeySelective(itripHotelTradingArea);
        }else{
            itripHotelTradingArea.setCreationDate(new Date());
            flag=itripHotelTradingAreaMapper.insert(itripHotelTradingArea);
        }
        return flag;
    }

    public ItripHotelTradingArea queryItripHotelTradingAreaById(Long id) throws Exception{
        return itripHotelTradingAreaMapper.selectByPrimaryKey(id);
    }

    public int removeItripHotelTradingAreaByIds(String ids)throws Exception{
        ItripHotelTradingAreaExample itripHotelTradingAreaExample=new ItripHotelTradingAreaExample();
        List<Long> idsList=new ArrayList<Long>();
        String idsArray[]=ids.split(",");
        for(int i=0;i<idsArray.length;i++){
            idsList.add(Long.parseLong(idsArray[i]));
        }
        itripHotelTradingAreaExample.createCriteria().andIdIn(idsList);
        int flag=itripHotelTradingAreaMapper.deleteByExample(itripHotelTradingAreaExample);
        return flag;
    }

    public List<ItripHotelTradingArea> queryItripHotelTradingAreaList(ItripHotelTradingAreaExample example)throws Exception{
        return itripHotelTradingAreaMapper.selectByExample(example);
    }

    public Page<ItripHotelTradingArea> queryItripHotelTradingAreaPage(Map params)throws Exception{
        int page = 0;
        if (EmptyUtils.isNotEmpty(params.get("page"))) {
            page = Integer.parseInt(params.get("page").toString());
        }
        params.put("page", page);
        String countSqlId = "ItripHotelTradingArea.getItripHotelTradingAreaCount";
        String listSqlId = "ItripHotelTradingArea.getItripHotelTradingAreaPage";
        Page<ItripHotelTradingArea> result = selectService.getPage(countSqlId, listSqlId, params);
        return result;
    }
}
