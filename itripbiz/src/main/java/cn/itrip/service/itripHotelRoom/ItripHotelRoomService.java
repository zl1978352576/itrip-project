package cn.itrip.service.itripHotelRoom;
import cn.itrip.beans.pojo.ItripHotelRoom;
import java.util.List;
import java.util.Map;
import java.util.List;
import java.util.Map;
import cn.itrip.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface ItripHotelRoomService {

    public ItripHotelRoom getItripHotelRoomById(Long id)throws Exception;

    public List<ItripHotelRoom>	getItripHotelRoomListByMap(Map<String,Object> param)throws Exception;

    public Integer getItripHotelRoomCountByMap(Map<String,Object> param)throws Exception;

    public Integer insertItripHotelRoom(ItripHotelRoom itripHotelRoom)throws Exception;

    public Integer updateItripHotelRoom(ItripHotelRoom itripHotelRoom)throws Exception;

    public Integer deleteItripHotelRoomById(Long id)throws Exception;

}
