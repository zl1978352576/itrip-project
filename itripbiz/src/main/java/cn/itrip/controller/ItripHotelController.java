package cn.itrip.controller;

import cn.itrip.beans.dtos.Dto;
import cn.itrip.beans.pojo.ItripAreaDic;
import cn.itrip.common.DtoUtil;
import cn.itrip.service.itripAreaDic.ItripAreaDicService;
import org.springframework.stereotype.Controller;
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
    public Dto<ItripAreaDic> queryHotCity(Integer type){
        Map param=new HashMap();
        param.put("isHot",1);
        param.put("isChina",type);
        List<ItripAreaDic> itripAreaDics=null;
        try {
            itripAreaDics=itripAreaDicService.getItripAreaDicListByMap(param);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return  DtoUtil.returnSuccess("",itripAreaDics);
        }
    }
}
