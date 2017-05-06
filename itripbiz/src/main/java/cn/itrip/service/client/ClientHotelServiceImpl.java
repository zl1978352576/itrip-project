package cn.itrip.service.client;

import cn.itrip.beans.pojo.*;
import cn.itrip.common.Constants;
import cn.itrip.common.Page;
import cn.itrip.service.IItripAreaDicService;
import cn.itrip.service.IItripHotelKeywordService;
import cn.itrip.service.IItripHotelService;
import cn.itrip.service.IItripLabelDicService;
import cn.itrip.service.common.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by zezhong.shang on 17-4-26.
 */
@Service
public class ClientHotelServiceImpl implements IClientHotelService{

    @Autowired
    private IItripAreaDicService itripAreaDicService;

    @Autowired
    private SelectService<ItripHotel> itripHotelSelectService;

    @Autowired
    private IItripHotelKeywordService itripHotelKeywordService;

    @Autowired
    private IItripLabelDicService itripLabelDicService;

    @Autowired
    private IItripHotelService itripHotelService;

    @Override
    public List<ItripAreaDic> queryHotCity(Integer type) throws Exception {
        ItripAreaDicExample example=new ItripAreaDicExample();
        example.createCriteria().andIsHotEqualTo(Constants.Area_HOT_STATUS.IS_HOT);
        return itripAreaDicService.queryItripAreaDicList(example);
    }

    @Override
    public List<ItripHotel> queryHotItripHotel(Long cityId, Integer count)throws Exception {
        Page<ItripHotel> itripHotelPage=null;
        Map<String,Object> param=new HashMap<String,Object>();
        param.put("page",1);
        param.put("rows",count);
        itripHotelPage=itripHotelSelectService.getPage("ItripHotel.getItripHotelCount","ItripHotel.getItripHotelPage",param);
        return itripHotelPage.getRows();
    }
    /***
     * 根据酒店ID 查询酒店特色
     * @param hotelId
     * @return
     */
    @Override
    public List<ItripLabelDic> queryItripHotelKeywordById(Long hotelId) throws Exception {
        ItripHotelKeywordExample example=new ItripHotelKeywordExample();
        example.createCriteria().andHotelIdEqualTo(hotelId);
        List<ItripHotelKeyword> itripHotelKeywordList=itripHotelKeywordService.queryItripHotelKeywordList(example);
        List<Long> ids=new ArrayList<Long>();
        for (ItripHotelKeyword itripHotelKeyword:itripHotelKeywordList){
            ids.add(itripHotelKeyword.getKeywordId());
        }
        ItripLabelDicExample itripLabelDicExample=new ItripLabelDicExample();
        itripLabelDicExample.createCriteria().andIdIn(ids);
        List<ItripLabelDic> itripLabelDicList=itripLabelDicService.queryItripLabelDicList(itripLabelDicExample);
        return itripLabelDicList;
    }
    /***
     * 根据酒店id查询酒店详情
     * @param hotelId
     * @return
     * @throws Exception
     */
    @Override
    public ItripHotel queryItripHotelById(Long hotelId) throws Exception {
        ItripHotelExample example=new ItripHotelExample();
        example.createCriteria().andIdEqualTo(hotelId);
        ItripHotel hotel=itripHotelService.queryItripHotelById(hotelId);
        return  hotel;
    }

    @Override
    public List<ItripHotelRoom> queryItripHotelRoom(Map params) throws Exception {
        return null;
    }


    @Override
    public Page<ItripHotel> searchHotel(Map<String, Object> param) {
        Page<ItripHotel> hotelPage=itripHotelSelectService.getPage("ItripHotel.getItripHotelCount", "ItripHotel.getItripHotelPage", param);
        return hotelPage;
    }
}
