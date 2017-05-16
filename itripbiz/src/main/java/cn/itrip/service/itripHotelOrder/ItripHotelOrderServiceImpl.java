package cn.itrip.service.itripHotelOrder;
import cn.itrip.beans.pojo.ItripHotelRoom;
import cn.itrip.beans.pojo.ItripHotelTempStore;
import cn.itrip.beans.pojo.ItripProductStore;
import cn.itrip.common.*;
import cn.itrip.dao.itripHotelOrder.ItripHotelOrderMapper;
import cn.itrip.beans.pojo.ItripHotelOrder;
import cn.itrip.dao.itripHotelTempStore.ItripHotelTempStoreMapper;
import cn.itrip.dao.itripProductStore.ItripProductStoreMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

import static java.math.BigDecimal.ROUND_DOWN;

@Service
public class ItripHotelOrderServiceImpl implements ItripHotelOrderService {

    @Resource
    private ItripHotelOrderMapper itripHotelOrderMapper;

    @Resource
    private ItripHotelTempStoreMapper itripHotelTempStoreMapper;

    @Resource
    private ItripProductStoreMapper itripProductStoreMapper;


    public ItripHotelOrder getItripHotelOrderById(Long id)throws Exception{
        return itripHotelOrderMapper.getItripHotelOrderById(id);
    }

    public List<ItripHotelOrder> getItripHotelOrderListByMap(Map<String,Object> param)throws Exception{
        return itripHotelOrderMapper.getItripHotelOrderListByMap(param);
    }

    public Integer getItripHotelOrderCountByMap(Map<String,Object> param)throws Exception{
        return itripHotelOrderMapper.getItripHotelOrderCountByMap(param);
    }

    public Integer itriptxAddItripHotelOrder(ItripHotelOrder itripHotelOrder, ItripHotelRoom itripHotelRoom)throws Exception{
            if(this.updateRoomStore(itripHotelOrder, itripHotelRoom) == 0){
                throw new Exception();
            }
            itripHotelOrder.setCreationDate(new Date());
            return itripHotelOrderMapper.insertItripHotelOrder(itripHotelOrder);
    }

    public Integer itriptxModifyItripHotelOrder(ItripHotelOrder itripHotelOrder)throws Exception{
        itripHotelOrder.setModifyDate(new Date());
        return itripHotelOrderMapper.updateItripHotelOrder(itripHotelOrder);
    }

    public Integer itriptxDeleteItripHotelOrderById(Long id)throws Exception{
        return itripHotelOrderMapper.deleteItripHotelOrderById(id);
    }

    public Page<ItripHotelOrder> queryItripHotelOrderPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception{
        Integer total = itripHotelOrderMapper.getItripHotelOrderCountByMap(param);
        pageNo = EmptyUtils.isEmpty(pageNo) ? Constants.DEFAULT_PAGE_NO : pageNo;
        pageSize = EmptyUtils.isEmpty(pageSize) ? Constants.DEFAULT_PAGE_SIZE : pageSize;
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<ItripHotelOrder> itripHotelOrderList = itripHotelOrderMapper.getItripHotelOrderListByMap(param);
        page.setRows(itripHotelOrderList);
        return page;
    }

    public boolean updateHotelOrderStatus(Integer id) throws Exception {
        return itripHotelOrderMapper.updateHotelOrderStatus(id) > 0 ? true : false;
    }

    public int getRoomNumByRoomIdTypeAndDate(Integer roomId, String startDate, String endDate) throws Exception {
        return itripHotelOrderMapper.getRoomNumByRoomIdTypeAndDate(roomId, startDate, endDate);
    }

    public BigDecimal getOrderPayAmount(int days, BigDecimal roomPrice) throws Exception{
        BigDecimal payAmount = null;
        payAmount = BigDecimalUtil.OperationASMD(days, roomPrice,
                BigDecimalUtil.BigDecimalOprations.multiply,
                2, ROUND_DOWN);
        return payAmount;
    }

    public int updateRoomStore(ItripHotelOrder hotelOrder, ItripHotelRoom itripHotelRoom) throws Exception{
        int result = 0;
        //获取预定日期，并按天拆分
        List<Date> dates = DateUtil.getBetweenDates(hotelOrder.getCheckInDate(), hotelOrder.getCheckOutDate());
        //计算订单的金额
        BigDecimal payAmount = getOrderPayAmount(dates.size(), itripHotelRoom.getRoomPrice());
        hotelOrder.setPayAmount(payAmount);
        ItripHotelTempStore tempStore = new ItripHotelTempStore();
        //score用来存临时库存表的库存数量，此数量通过计算得到
        int score = 0;
        //遍历日期，每个日期都对应一条库存记录
        Long hotelId = hotelOrder.getHotelId();
        Long roomId = hotelOrder.getRoomId();
        Integer count = hotelOrder.getCount();
        List<ItripHotelTempStore> tempStoreList = null;
        for(int i=0; i<dates.size(); i++){
            tempStore.setHotelId(hotelId.intValue());
            tempStore.setRoomId(roomId);
            tempStore.setRecordDate(dates.get(i));
            //根据日期和roomId去临时库存表判断有没有对应的记录，如果有则更新此记录的库存数量，
            //否则根据日期和roomId去库存表查询对应的记录，并以此记录计算库存余量，此时临时库存表需新增记录
            Map<String, Object> tempStoreMap = new HashMap<String, Object>();
            tempStoreMap.put("roomId", roomId);
            tempStoreMap.put("recordDate", dates.get(i));
            try {
                tempStoreList = itripHotelTempStoreMapper.getItripHotelTempStoreListByMap(tempStoreMap);
                //临时库存表中有记录
                if(null != tempStoreList && 1 == tempStoreList.size()){
                    tempStore = tempStoreList.get(0);
                    //设置临时库存数量为当前量减去订单消耗量
                    tempStore.setStore(tempStore.getStore() - count);
                    result = itripHotelTempStoreMapper.updateItripHotelTempStore(tempStore);
                }
                //临时库存表中没有记录
                else if(null == tempStoreList){
                    //根据roomId去库存表中查询库存量
                    Map<String, Object> productStoreMap = new HashMap<String, Object>();
                    productStoreMap.put("productType", 1);
                    productStoreMap.put("productId", roomId);
                    List<ItripProductStore> productStoreList = null;
                    productStoreList = itripProductStoreMapper.getItripProductStoreListByMap(productStoreMap);
                    if(null != productStoreList && 1 == productStoreList.size()){
                        score = productStoreList.get(0).getStore() - count;
                        tempStore.setStore(tempStore.getStore() - count);
                        result = itripHotelTempStoreMapper.insertItripHotelTempStore(tempStore);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }


}
