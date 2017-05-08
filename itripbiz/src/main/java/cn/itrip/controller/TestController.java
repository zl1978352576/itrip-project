package cn.itrip.controller;
import cn.itrip.service.IItripAreaDicService;
import cn.itrip.service.common.SelectService;
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
    private IItripAreaDicService iItripAreaDicService;

    @Autowired
    private SelectService<ItripAreaDic> selectService;

    @RequestMapping("/example")
    public void testExample(){
        ItripAreaDicExample itripAreaDicExample=new ItripAreaDicExample();
        List<ItripAreaDic> itripAreaDicList=null;
        try {
            itripAreaDicList= iItripAreaDicService.queryItripAreaDicList(itripAreaDicExample);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            for (ItripAreaDic dic:itripAreaDicList){
                System.out.println(dic.getName());
            }
        }
    }

    @RequestMapping("/select")
    public void testSelect(){
        Integer count=0;
        try {
            Map<String,Object> param=new HashMap<String,Object>();
            count = selectService.getCount("ItripAreaDic.getItripAreaDicCount",param);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println(count);
        }
    }
}

