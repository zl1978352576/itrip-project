package cn.itrip.service;
import cn.itrip.beans.pojo.ItripHotel;
import java.util.List;
import java.util.Map;
import cn.itrip.beans.pojo.ItripHotelExample;
import cn.itrip.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface IItripHotelService {

    public int saveOrUpdateItripHotel(ItripHotel obj)throws Exception;

    public ItripHotel queryItripHotelById(Long id)throws Exception;

    public int removeItripHotelByIds(String ids)throws Exception;

    public List<ItripHotel> queryItripHotelList(ItripHotelExample example)throws Exception;

    public Page<ItripHotel> queryItripHotelPage(Map params)throws Exception;
}
