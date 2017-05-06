package cn.itrip.service;
import cn.itrip.beans.pojo.ItripHotelRoom;
import java.util.List;
import java.util.Map;
import cn.itrip.beans.pojo.ItripHotelRoomExample;
import cn.itrip.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface IItripHotelRoomService {

    public int saveOrUpdateItripHotelRoom(ItripHotelRoom obj)throws Exception;

    public ItripHotelRoom queryItripHotelRoomById(Long id)throws Exception;

    public int removeItripHotelRoomByIds(String ids)throws Exception;

    public List<ItripHotelRoom> queryItripHotelRoomList(ItripHotelRoomExample example)throws Exception;

    public Page<ItripHotelRoom> queryItripHotelRoomPage(Map params)throws Exception;
}
