package cn.itrip.service;
import cn.itrip.beans.pojo.ItripHotelTradingArea;
import java.util.List;
import java.util.Map;
import cn.itrip.beans.pojo.ItripHotelTradingAreaExample;
import cn.itrip.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface IItripHotelTradingAreaService {

    public int saveOrUpdateItripHotelTradingArea(ItripHotelTradingArea obj)throws Exception;

    public ItripHotelTradingArea queryItripHotelTradingAreaById(Long id)throws Exception;

    public int removeItripHotelTradingAreaByIds(String ids)throws Exception;

    public List<ItripHotelTradingArea> queryItripHotelTradingAreaList(ItripHotelTradingAreaExample example)throws Exception;

    public Page<ItripHotelTradingArea> queryItripHotelTradingAreaPage(Map params)throws Exception;
}
