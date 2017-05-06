package cn.itrip.service.hotel;

import java.util.List;
import cn.itrip.beans.pojo.Hotel;

public interface TestService {

	/**
	 * 根据条件获取酒店列表
	 * @param hotel
	 * @return
	 * @throws Exception
	 */
	public List<Hotel> getHotelList(Hotel hotel)throws Exception;
}