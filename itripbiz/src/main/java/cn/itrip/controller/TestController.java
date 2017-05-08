package cn.itrip.controller;

import cn.itrip.beans.pojo.ItripAreaDic;
import cn.itrip.service.itripAreaDic.ItripAreaDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zezhong.shang on 17-4-25.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ItripAreaDicService iItripAreaDicService;

    @RequestMapping("/example")
    public void testExample() throws Exception {
        ItripAreaDic itripAreaDic = iItripAreaDicService.getItripAreaDicById(new Long(1));
        itripAreaDic.setName("北京市");
        itripAreaDic.setParent(new Long(1));
        int flag=iItripAreaDicService.itriptxDeleteItripAreaDicById(new Long(3653));
        System.out.println(flag);
    }

    @RequestMapping("/select")
    public void testSelect() throws Exception {
        Map<String,Object> param=new HashMap<String,Object>();
        param.put("id", "1");
        List<ItripAreaDic> itripAreaDics=iItripAreaDicService.getItripAreaDicListByMap(param);
        for (ItripAreaDic itripAreaDic:itripAreaDics){
            System.out.println(itripAreaDic.getName());
        }
    }





}

