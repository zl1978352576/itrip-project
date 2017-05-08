package cn.itrip.service.itripHotelTradingArea;
import cn.itrip.dao.itripHotelTradingArea.ItripHotelTradingAreaMapper;
import cn.itrip.beans.pojo.ItripHotelTradingArea;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ItripHotelTradingAreaServiceImpl implements ItripHotelTradingAreaService {

    @Resource
    private ItripHotelTradingAreaMapper itripHotelTradingAreaMapper;

    public ItripHotelTradingArea getItripHotelTradingAreaById(Long id)throws Exception{
        return itripHotelTradingAreaMapper.getItripHotelTradingAreaById(id);
    }

    public List<ItripHotelTradingArea>	getItripHotelTradingAreaListByMap(Map<String,Object> param)throws Exception{
        return itripHotelTradingAreaMapper.getItripHotelTradingAreaListByMap(param);
    }

    public Integer getItripHotelTradingAreaCountByMap(Map<String,Object> param)throws Exception{
        return itripHotelTradingAreaMapper.getItripHotelTradingAreaCountByMap(param);
    }

    public Integer itriptxAddItripHotelTradingArea(ItripHotelTradingArea itripHotelTradingArea)throws Exception{
            itripHotelTradingArea.setCreationDate(new Date());
            return itripHotelTradingAreaMapper.insertItripHotelTradingArea(itripHotelTradingArea);
    }

    public Integer itriptxModifyItripHotelTradingArea(ItripHotelTradingArea itripHotelTradingArea)throws Exception{
        itripHotelTradingArea.setModifyDate(new Date());
        return itripHotelTradingAreaMapper.updateItripHotelTradingArea(itripHotelTradingArea);
    }

    public Integer itriptxDeleteItripHotelTradingAreaById(Long id)throws Exception{
        return itripHotelTradingAreaMapper.deleteItripHotelTradingAreaById(id);
    }

}
