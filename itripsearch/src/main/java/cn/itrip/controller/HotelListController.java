package cn.itrip.controller;

import cn.itrip.beans.dtos.Dto;
import cn.itrip.beans.vo.hotel.ItripHotelVO;
import cn.itrip.beans.vo.hotel.SearchHotelVO;
import cn.itrip.common.DtoUtil;
import cn.itrip.common.Page;
import cn.itrip.service.SearchHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zezhong.shang on 17-5-10.
 */
@Controller
//@Api(value = "API", basePath = "/http://api.itrap.com/api")
@RequestMapping(value = "/api/hotellist")
public class HotelListController {
    @Autowired
    private SearchHotelService searchHotelService;

    /***
     * 搜索酒店分页
     * @param vo
     * @param pageSize
     * @param pageNo
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/searchItripHotelPage")
    @ResponseBody
    public Dto<Page<ItripHotelVO>> searchItripHotelPage(SearchHotelVO vo,Integer pageSize,Integer pageNo)throws Exception{
        Map<String,Object> param=new HashMap<>();
        param.put("destination",vo.getDestination());
        param.put("hotelLevel",vo.getHotelLevel());
        param.put("keywords",vo.getKeywords());
        param.put("areaId",vo.getAreaId());
        param.put("minPrice",vo.getMinPrice());
        param.put("maxPrice",vo.getMaxPrice());
        param.put("feature", vo.getFeature());
        Page page=searchHotelService.searchItripHotelPage(param, pageNo, pageSize);
        return DtoUtil.returnDataSuccess(page);
    }

    @RequestMapping(value = "/searchItripHotelListByHotCity")
    @ResponseBody
    public Dto<Page<ItripHotelVO>> searchItripHotelListByHotCity(Integer cityId,Integer count)throws Exception{
        Map<String,Object> param=new HashMap<>();
        param.put("cityId",cityId);
        searchHotelService.searchItripHotelListByHotCity(cityId,count);
        return DtoUtil.returnSuccess();
    }

}
