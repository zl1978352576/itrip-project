package cn.itrip.service;
import cn.itrip.beans.pojo.ItripHotel;
import cn.itrip.common.Page;

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
    public Page<ItripHotel> searchItripHotel(Map<String,Object> params,Integer pageNo,Integer pageSize);

}
