package cn.itrip.dao.itripHotelKeyword;
import cn.itrip.beans.pojo.ItripHotelKeyword;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface ItripHotelKeywordMapper {

	public ItripHotelKeyword getItripHotelKeywordById(@Param(value = "id") Long id)throws Exception;

	public List<ItripHotelKeyword>	getItripHotelKeywordListByMap(Map<String,Object> param)throws Exception;

	public Integer getItripHotelKeywordCountByMap(Map<String,Object> param)throws Exception;

	public Integer insertItripHotelKeyword(ItripHotelKeyword itripHotelKeyword)throws Exception;

	public Integer updateItripHotelKeyword(ItripHotelKeyword itripHotelKeyword)throws Exception;

	public Integer deleteItripHotelKeywordById(@Param(value = "id") Long id)throws Exception;

}
