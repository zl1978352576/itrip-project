package cn.itrip.service.itripHotelKeyword;
import cn.itrip.beans.pojo.ItripHotelKeyword;
import java.util.List;
import java.util.Map;
import java.util.List;
import java.util.Map;
import cn.itrip.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface ItripHotelKeywordService {

    public ItripHotelKeyword getItripHotelKeywordById(Long id)throws Exception;

    public List<ItripHotelKeyword>	getItripHotelKeywordListByMap(Map<String,Object> param)throws Exception;

    public Integer getItripHotelKeywordCountByMap(Map<String,Object> param)throws Exception;

    public Integer itriptxAddItripHotelKeyword(ItripHotelKeyword itripHotelKeyword)throws Exception;

    public Integer itriptxModifyItripHotelKeyword(ItripHotelKeyword itripHotelKeyword)throws Exception;

    public Integer itriptxDeleteItripHotelKeywordById(Long id)throws Exception;

}
