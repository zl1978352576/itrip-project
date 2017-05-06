package cn.itrip.service;
import cn.itrip.dao.ItripHotelRoomMapper;
import cn.itrip.beans.pojo.ItripHotelRoom;
import cn.itrip.beans.pojo.ItripHotelRoomExample;
import cn.itrip.service.common.SelectService;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ItripHotelRoomServiceImpl implements IItripHotelRoomService {

    @Autowired
    private ItripHotelRoomMapper itripHotelRoomMapper;

    @Autowired
    private SelectService<ItripHotelRoom> selectService;

    public int saveOrUpdateItripHotelRoom(ItripHotelRoom itripHotelRoom) throws Exception{
        int flag=0;
        if(EmptyUtils.isNotEmpty(itripHotelRoom.getId())){
            itripHotelRoom.setModifyDate(new Date());
            flag=itripHotelRoomMapper.updateByPrimaryKeySelective(itripHotelRoom);
        }else{
            itripHotelRoom.setCreationDate(new Date());
            flag=itripHotelRoomMapper.insert(itripHotelRoom);
        }
        return flag;
    }

    public ItripHotelRoom queryItripHotelRoomById(Long id) throws Exception{
        return itripHotelRoomMapper.selectByPrimaryKey(id);
    }

    public int removeItripHotelRoomByIds(String ids)throws Exception{
        ItripHotelRoomExample itripHotelRoomExample=new ItripHotelRoomExample();
        List<Long> idsList=new ArrayList<Long>();
        String idsArray[]=ids.split(",");
        for(int i=0;i<idsArray.length;i++){
            idsList.add(Long.parseLong(idsArray[i]));
        }
        itripHotelRoomExample.createCriteria().andIdIn(idsList);
        int flag=itripHotelRoomMapper.deleteByExample(itripHotelRoomExample);
        return flag;
    }

    public List<ItripHotelRoom> queryItripHotelRoomList(ItripHotelRoomExample example)throws Exception{
        return itripHotelRoomMapper.selectByExample(example);
    }

    public Page<ItripHotelRoom> queryItripHotelRoomPage(Map params)throws Exception{
        int page = 0;
        if (EmptyUtils.isNotEmpty(params.get("page"))) {
            page = Integer.parseInt(params.get("page").toString());
        }
        params.put("page", page);
        String countSqlId = "ItripHotelRoom.getItripHotelRoomCount";
        String listSqlId = "ItripHotelRoom.getItripHotelRoomPage";
        Page<ItripHotelRoom> result = selectService.getPage(countSqlId, listSqlId, params);
        return result;
    }
}
