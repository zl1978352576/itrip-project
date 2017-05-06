package cn.itrip.service.hotel;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.itrip.dao.hotel.TestMapper;
import cn.itrip.beans.pojo.Hotel;

@Service
public class TestServiceImpl implements TestService {
	
	@Resource
	private TestMapper hotelMapper;
	
	@Override
	public List<Hotel> getHotelList(Hotel hotel)
			throws Exception {
		// TODO Auto-generated method stub
		return hotelMapper.getHotelList(hotel.getHotelName(), hotel.getCityId());
	}

}
