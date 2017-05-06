package cn.itrip.dao.hotel;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import cn.itrip.beans.pojo.Hotel;

public interface TestMapper {
	
	/*
	 * 根据条件获取酒店列表
	 */
	public List<Hotel> getHotelList(@Param(value = "hotelName") String hotelName,
                                    @Param(value = "cityId") Integer cityId)throws Exception;

	
}
