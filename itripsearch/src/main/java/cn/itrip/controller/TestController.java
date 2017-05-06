package cn.itrip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zezhong.shang on 17-5-5.
 */
@Controller
@RequestMapping("/api/test")
public class TestController {

    @RequestMapping("/index")
    public String testIndex(){
        return "index";
    }
}
