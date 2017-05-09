package cn.itrip.controller;

import cn.itrip.beans.dtos.Dto;
import cn.itrip.beans.pojo.ItripAreaDic;
import cn.itrip.beans.pojo.ItripComment;
import cn.itrip.beans.pojo.ItripImage;
import cn.itrip.common.Page;
import cn.itrip.common.PropertiesUtils;
import cn.itrip.service.itripAreaDic.ItripAreaDicService;
import cn.itrip.service.itripComment.ItripCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zezhong.shang on 17-4-25.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ItripAreaDicService itripAreaDicService;

    private ItripCommentService itripCommentService;

    @RequestMapping("/example")
    public void testExample() throws Exception {
        ItripAreaDic itripAreaDic =new ItripAreaDic();
        itripAreaDic.setName("北京市");
        itripAreaDic.setParent(new Long(1));
        itripAreaDic.setIsActivated(1);
        itripAreaDic.setIsHot(1);
        int flag=itripAreaDicService.itriptxAddItripAreaDic(itripAreaDic);
        System.out.println(flag);
    }

    @RequestMapping("/select")
    public void testSelect() throws Exception {
        Map<String,Object> param=new HashMap<String,Object>();
        param.put("id", "1");
        List<ItripAreaDic> itripAreaDics=itripAreaDicService.getItripAreaDicListByMap(param);
        for (ItripAreaDic itripAreaDic:itripAreaDics){
            System.out.println(itripAreaDic.getName());
        }
    }

    @RequestMapping("/page")
    @ResponseBody
    public Dto<Page<ItripAreaDic>> page() throws Exception {
        Dto<Page<ItripAreaDic>> dto=new Dto<>();
        dto.setMsg("测试分页");
        dto.setSuccess("true");
        dto.setErrorCode("0");
        Map<String,Object> param=new HashMap<String,Object>();
        Page<ItripAreaDic> itripAreaDicPage=itripAreaDicService.queryItripAreaDicPageByMap(param, 2, 5);
        dto.setData(itripAreaDicPage);
        return  dto;
    }

    @RequestMapping("/add")
    public Dto<Page<ItripAreaDic>> add() throws Exception {
        ItripComment comment = new ItripComment();
        List<ItripImage> imageList = new ArrayList<ItripImage>();
        ItripImage image = new ItripImage();
        Date d = new Date();
        String date = "2016-01-01";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            d = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        image.setType("0");
        image.setImgUrl("C:\\workspace");
        image.setCreationDate(d);
        comment.setHotelId(1L);
        comment.setProductId(1L);
        comment.setProductType(1);
        comment.setUserId(1L);
        comment.setIsHavingImg(1);
        comment.setPositionScore(3);
        comment.setFacilitiesScore(3);
        comment.setServiceScore(4);
        comment.setHygieneScore(3);
        comment.setTripMode("1");
        comment.setIsOk(1);
        comment.setCreationDate(new Date());
        comment.setCreatedBy(1l);
        comment.setModifyDate(new Date());
        comment.setModifiedBy(1l);
        comment.setContent("1231231");
        try {
            Boolean flag = itripCommentService.itriptxAddItripComment(comment, imageList);
            System.out.println("添加点评的数量为：" + flag);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return  null;
        }
    }

    public static void main(String[] args) {
        String name= PropertiesUtils.get("validateNull.properties","api/hotel/queryHotCity");
        System.out.println("name = [" + name + "]");
    }

}

