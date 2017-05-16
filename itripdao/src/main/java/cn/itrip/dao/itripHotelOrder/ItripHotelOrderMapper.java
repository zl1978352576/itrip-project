package cn.itrip.dao.itripHotelOrder;
import cn.itrip.beans.pojo.ItripHotelOrder;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ItripHotelOrderMapper {

	public ItripHotelOrder getItripHotelOrderById(@Param(value = "id") Long id)throws Exception;

	public List<ItripHotelOrder>	getItripHotelOrderListByMap(Map<String,Object> param)throws Exception;

	public Integer getItripHotelOrderCountByMap(Map<String,Object> param)throws Exception;

	public Integer insertItripHotelOrder(ItripHotelOrder itripHotelOrder)throws Exception;

	public Integer updateItripHotelOrder(ItripHotelOrder itripHotelOrder)throws Exception;

	public Integer deleteItripHotelOrderById(@Param(value = "id") Long id)throws Exception;

	public Integer updateHotelOrderStatus(Integer id) throws Exception;

	public int getRoomNumByRoomIdTypeAndDate(Integer roomId, String startDate, String endDate) throws Exception;

	public int updateRoomStore(ItripHotelOrder hotelOrder) throws Exception;

}
