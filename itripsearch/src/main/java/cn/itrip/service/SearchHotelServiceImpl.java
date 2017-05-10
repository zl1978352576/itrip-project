package cn.itrip.service;
import cn.itrip.beans.pojo.ItripHotel;
import cn.itrip.beans.vo.hotel.ItripHotelVO;
import cn.itrip.common.Page;
import cn.itrip.dao.BaseQuery;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zezhong.shang on 17-5-7.
 */
@Service
public class SearchHotelServiceImpl implements SearchHotelService {

    public static String URL="http://localhost:8080/solr/hotel/";

    @Override
    public Page<ItripHotelVO> searchItripHotelPage(Map<String, Object> params, Integer pageNo, Integer pageSize) throws Exception{
        BaseQuery<ItripHotelVO> itripAreaDicBaseQuery = new BaseQuery(URL);
        Page<ItripHotelVO> itripHotelPage = itripAreaDicBaseQuery.queryPage(params, pageNo, pageSize, ItripHotelVO.class);
        return itripHotelPage;
    }

    @Override
    public List<ItripHotelVO> searchItripHotelListByHotCity(Integer cityId,Integer count) throws Exception{
        BaseQuery<ItripHotelVO> itripAreaDicBaseQuery = new BaseQuery(URL);
        Map<String,Object> param=new HashMap();
        param.put("cityId",cityId);
        Page<ItripHotelVO> itripHotelPage = itripAreaDicBaseQuery.queryPage(param, 1, count, ItripHotelVO.class);
        return itripHotelPage.getRows();
    }

}
