package cn.itrip.controller;
import cn.itrip.service.IItripAreaDicService;
import cn.itrip.service.common.SelectService;
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
    public void testExample(){

    }

    @RequestMapping("/select")
    public void testSelect(){

    }
}

