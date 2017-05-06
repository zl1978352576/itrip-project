package cn.itrip.service.client;
import cn.itrip.common.Page;
import cn.itrip.beans.pojo.ItripAreaDic;
import cn.itrip.beans.pojo.ItripHotel;
import cn.itrip.beans.pojo.ItripHotelRoom;
import cn.itrip.beans.pojo.ItripLabelDic;

import java.util.List;
import java.util.Map;

/**
 * Created by zezhong.shang on 17-4-25.
 */
public interface IClientHotelService {
    /***
     * 查询热门城市
     * @param type 0:国内 1:国际
     * @return
     */
    public List<ItripAreaDic> queryHotCity(Integer type) throws Exception;
    /***
     * 根据城市查询热门酒店
     * cityId:城市id
     * count:热门城市数目
     */
    public List<ItripHotel> queryHotItripHotel(Long cityId, Integer count)throws Exception;
    /***
     * 根据酒店ID 查询酒店特色
     * @param hotelId
     * @return
     */
    public List<ItripLabelDic> queryItripHotelKeywordById(Long hotelId) throws Exception;
    /***
     * 根据酒店id查询酒店详情
     * @param hotelId
     * @return
     * @throws Exception
     */
    public ItripHotel queryItripHotelById(Long hotelId) throws Exception;
    /***
     * 根据
     * @param params
     * @return
     * @throws Exception
     */
    public List<ItripHotelRoom> queryItripHotelRoom(Map params)throws Exception;
    /***
     * @param param
     * String destination 目的地
     * Date chickInDate 入住时间
     * Date chickOutDate 退房时间
     * Integer level 酒店级别
     * keywords 关键词
     * type 酒店类型(国际酒店、国内酒店)
     * @return
     */
    public Page<ItripHotel> searchHotel(Map<String, Object> param);

}
