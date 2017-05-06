package cn.itrip.service;
import cn.itrip.beans.pojo.ItripHotelOrder;
import java.util.List;
import java.util.Map;
import cn.itrip.beans.pojo.ItripHotelOrderExample;
import cn.itrip.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface IItripHotelOrderService {

    public int saveOrUpdateItripHotelOrder(ItripHotelOrder obj)throws Exception;

    public ItripHotelOrder queryItripHotelOrderById(Long id)throws Exception;

    public int removeItripHotelOrderByIds(String ids)throws Exception;

    public List<ItripHotelOrder> queryItripHotelOrderList(ItripHotelOrderExample example)throws Exception;

    public Page<ItripHotelOrder> queryItripHotelOrderPage(Map params)throws Exception;
}
