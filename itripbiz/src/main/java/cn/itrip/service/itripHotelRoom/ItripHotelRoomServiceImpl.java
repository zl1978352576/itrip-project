package cn.itrip.service.itripHotelRoom;
import cn.itrip.dao.itripHotelRoom.ItripHotelRoomMapper;
import cn.itrip.beans.pojo.ItripHotelRoom;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ItripHotelRoomServiceImpl implements ItripHotelRoomService {

    @Resource
    private ItripHotelRoomMapper itripHotelRoomMapper;

    public ItripHotelRoom getItripHotelRoomById(Long id)throws Exception{
        return itripHotelRoomMapper.getItripHotelRoomById(id);
    }

    public List<ItripHotelRoom>	getItripHotelRoomListByMap(Map<String,Object> param)throws Exception{
        return itripHotelRoomMapper.getItripHotelRoomListByMap(param);
    }

    public Integer getItripHotelRoomCountByMap(Map<String,Object> param)throws Exception{
        return itripHotelRoomMapper.getItripHotelRoomCountByMap(param);
    }

    public Integer insertItripHotelRoom(ItripHotelRoom itripHotelRoom)throws Exception{
            itripHotelRoom.setCreationDate(new Date());
            return itripHotelRoomMapper.updateItripHotelRoom(itripHotelRoom);
    }

    public Integer updateItripHotelRoom(ItripHotelRoom itripHotelRoom)throws Exception{
        itripHotelRoom.setModifyDate(new Date());
        return itripHotelRoomMapper.updateItripHotelRoom(itripHotelRoom);
    }

    public Integer deleteItripHotelRoomById(Long id)throws Exception{
        return itripHotelRoomMapper.deleteItripHotelRoomById(id);
    }

}
