package cn.itrip.controller;

import cn.itrip.beans.dtos.Dto;
import cn.itrip.beans.dtos.InputDto;
import cn.itrip.beans.dtos.ItripException;
import cn.itrip.beans.pojo.ItripAreaDic;
import cn.itrip.beans.pojo.ItripHotel;
import cn.itrip.common.DtoUtil;
import cn.itrip.service.itripAreaDic.ItripAreaDicService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zezhong.shang on 17-5-8.
 */
@Controller
@RequestMapping("/api/hotel")
public class ItripHotelController {

    @Resource
    private ItripAreaDicService itripAreaDicService;

    @RequestMapping("/queryHotCity")
    @ResponseBody
    public Dto<ItripAreaDic> queryHotCity(Integer type) throws Exception {
        Map param = new HashMap();
        param.put("isHot", 1);
        param.put("isChina", type);
        List<ItripAreaDic> itripAreaDics = itripAreaDicService.getItripAreaDicListByMap(param);
        Dto dto = DtoUtil.returnDataSuccess(itripAreaDics);
        return dto;
    }

    @RequestMapping("/queryHotelByCity")
    @ResponseBody
    public Dto<ItripHotel> queryHotelByCity() throws Exception {
        throw new ItripException("1001", "查询条件违法");
    }
}
