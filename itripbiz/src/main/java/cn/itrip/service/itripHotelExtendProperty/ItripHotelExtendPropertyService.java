package cn.itrip.service.itripHotelExtendProperty;
import cn.itrip.beans.pojo.ItripHotelExtendProperty;
import java.util.List;
import java.util.Map;
import java.util.List;
import java.util.Map;
import cn.itrip.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface ItripHotelExtendPropertyService {

    public ItripHotelExtendProperty getItripHotelExtendPropertyById(Long id)throws Exception;

    public List<ItripHotelExtendProperty>	getItripHotelExtendPropertyListByMap(Map<String,Object> param)throws Exception;

    public Integer getItripHotelExtendPropertyCountByMap(Map<String,Object> param)throws Exception;

    public Integer insertItripHotelExtendProperty(ItripHotelExtendProperty itripHotelExtendProperty)throws Exception;

    public Integer updateItripHotelExtendProperty(ItripHotelExtendProperty itripHotelExtendProperty)throws Exception;

    public Integer deleteItripHotelExtendPropertyById(Long id)throws Exception;

}
