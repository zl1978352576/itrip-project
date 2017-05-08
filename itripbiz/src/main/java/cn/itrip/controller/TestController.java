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
        ItripAreaDic itripAreaDic =new ItripAreaDic();
        itripAreaDic.setName("北京市");
        itripAreaDic.setParent(new Long(1));
        itripAreaDic.setIsActivated(1);
        itripAreaDic.setIsHot(1);
        int flag=iItripAreaDicService.itriptxAddItripAreaDic(itripAreaDic);
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

