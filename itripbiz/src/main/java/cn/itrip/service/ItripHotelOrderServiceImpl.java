package cn.itrip.service;
import cn.itrip.dao.ItripHotelOrderMapper;
import cn.itrip.beans.pojo.ItripHotelOrder;
import cn.itrip.beans.pojo.ItripHotelOrderExample;
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
public class ItripHotelOrderServiceImpl implements IItripHotelOrderService {

    @Autowired
    private ItripHotelOrderMapper itripHotelOrderMapper;

    @Autowired
    private SelectService<ItripHotelOrder> selectService;

    public int saveOrUpdateItripHotelOrder(ItripHotelOrder itripHotelOrder) throws Exception{
        int flag=0;
        if(EmptyUtils.isNotEmpty(itripHotelOrder.getId())){
            itripHotelOrder.setModifyDate(new Date());
            flag=itripHotelOrderMapper.updateByPrimaryKeySelective(itripHotelOrder);
        }else{
            itripHotelOrder.setCreationDate(new Date());
            flag=itripHotelOrderMapper.insert(itripHotelOrder);
        }
        return flag;
    }

    public ItripHotelOrder queryItripHotelOrderById(Long id) throws Exception{
        return itripHotelOrderMapper.selectByPrimaryKey(id);
    }

    public int removeItripHotelOrderByIds(String ids)throws Exception{
        ItripHotelOrderExample itripHotelOrderExample=new ItripHotelOrderExample();
        List<Long> idsList=new ArrayList<Long>();
        String idsArray[]=ids.split(",");
        for(int i=0;i<idsArray.length;i++){
            idsList.add(Long.parseLong(idsArray[i]));
        }
        itripHotelOrderExample.createCriteria().andIdIn(idsList);
        int flag=itripHotelOrderMapper.deleteByExample(itripHotelOrderExample);
        return flag;
    }

    public List<ItripHotelOrder> queryItripHotelOrderList(ItripHotelOrderExample example)throws Exception{
        return itripHotelOrderMapper.selectByExample(example);
    }

    public Page<ItripHotelOrder> queryItripHotelOrderPage(Map params)throws Exception{
        int page = 0;
        if (EmptyUtils.isNotEmpty(params.get("page"))) {
            page = Integer.parseInt(params.get("page").toString());
        }
        params.put("page", page);
        String countSqlId = "ItripHotelOrder.getItripHotelOrderCount";
        String listSqlId = "ItripHotelOrder.getItripHotelOrderPage";
        Page<ItripHotelOrder> result = selectService.getPage(countSqlId, listSqlId, params);
        return result;
    }
}
