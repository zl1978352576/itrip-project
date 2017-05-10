package cn.itrip.service;
import cn.itrip.beans.vo.hotel.ItripHotelVO;
import cn.itrip.common.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by zezhong.shang on 17-5-7.
 */
public interface SearchHotelService {
    /***
     * 搜索旅馆
     * @param params
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Page<ItripHotelVO> searchItripHotelPage(Map<String,Object> params,Integer pageNo,Integer pageSize)throws Exception;
    /***
     * 根据热门城市查询酒店
     * @param pageSize
     * @return
     */
    public List<ItripHotelVO> searchItripHotelListByHotCity(Integer cityId,Integer pageSize)throws Exception;

}
