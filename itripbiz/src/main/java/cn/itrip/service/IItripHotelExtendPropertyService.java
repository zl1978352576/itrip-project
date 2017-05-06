package cn.itrip.service;
import cn.itrip.beans.pojo.ItripHotelExtendProperty;
import java.util.List;
import java.util.Map;
import cn.itrip.beans.pojo.ItripHotelExtendPropertyExample;
import cn.itrip.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface IItripHotelExtendPropertyService {

    public int saveOrUpdateItripHotelExtendProperty(ItripHotelExtendProperty obj)throws Exception;

    public ItripHotelExtendProperty queryItripHotelExtendPropertyById(Long id)throws Exception;

    public int removeItripHotelExtendPropertyByIds(String ids)throws Exception;

    public List<ItripHotelExtendProperty> queryItripHotelExtendPropertyList(ItripHotelExtendPropertyExample example)throws Exception;

    public Page<ItripHotelExtendProperty> queryItripHotelExtendPropertyPage(Map params)throws Exception;
}
