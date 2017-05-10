package cn.itrip.service;
import cn.itrip.beans.pojo.ItripHotel;
import cn.itrip.common.Page;
import cn.itrip.dao.BaseQuery;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * Created by zezhong.shang on 17-5-7.
 */
@Service
public class SearchHotelServiceImpl implements SearchHotelService {

    @Override
    public Page<ItripHotel> searchItripHotel(Map<String, Object> params, Integer pageNo, Integer pageSize) {
        BaseQuery<ItripHotel> itripAreaDicBaseQuery = new BaseQuery<ItripHotel>();
        Page<ItripHotel> itripHotelPage = itripAreaDicBaseQuery.queryPage(params, pageNo, pageSize, ItripHotel.class);
        return itripHotelPage;
    }
}
