package cn.itrip.controller;
import cn.itrip.beans.dtos.Dto;
import cn.itrip.beans.pojo.ItripAreaDic;
import cn.itrip.beans.pojo.ItripLabelDic;
import cn.itrip.common.DtoUtil;
import cn.itrip.service.itripAreaDic.ItripAreaDicService;
import cn.itrip.service.itripLabelDic.ItripLabelDicService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 酒店信息Controller
 *
 * 包括API接口：
 * 1、根据酒店id查询酒店拓展属性
 * 2、根据酒店id查询酒店介绍，酒店政策，酒店设施
 * 3、根据酒店id查询酒店特色属性列表
 * 4、根据type 和target id 查询酒店图片
 * 5、查询热门城市
 * 6、查询热门商圈列表（搜索-酒店列表）
 * 7、查询数据字典特色父级节点列表（搜索-酒店列表）
 *
 * 注：错误码（100201 ——100300）
 *
 * Created by hanlu on 2017/5/9.
 */

@Controller
//@Api(value = "API", basePath = "/http://api.itrap.com/api")
@RequestMapping(value = "/api/hotel")
public class HotelController {

    private Logger logger = Logger.getLogger(HotelController.class);

    @Resource
    private ItripAreaDicService itripAreaDicService;

    @Resource
    private ItripLabelDicService itripLabelDicService;

    /****
     * 查询热门城市的接口
     *
     * @param type
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/queryhotcity", produces = "application/json", method = RequestMethod.POST)
    @ResponseBody
    public Dto<ItripAreaDic> queryHotCity(Integer type) throws Exception {
        Map param = new HashMap();
        param.put("isHot", 1);
        param.put("isChina", type);
        List<ItripAreaDic> itripAreaDics = itripAreaDicService.getItripAreaDicListByMap(param);
        return DtoUtil.returnDataSuccess(itripAreaDics);
    }

    /***
     * 查询商圈的接口
     *
     * @param cityId 根据城市查询商圈
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/querytradearea", produces = "application/json", method = RequestMethod.POST)
    @ResponseBody
    public Dto<ItripAreaDic> queryTradeArea(Long cityId) throws Exception {
        Map param = new HashMap();
        param.put("isTradingArea", 1);
        param.put("parent", cityId);
        List<ItripAreaDic> itripAreaDics = itripAreaDicService.getItripAreaDicListByMap(param);
        return DtoUtil.returnDataSuccess(itripAreaDics);
    }
    /***
     * 查询酒店特色列表
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/queryhotelfeature", produces = "application/json", method = RequestMethod.POST)
    @ResponseBody
    public Dto<ItripLabelDic> queryHotelFeature()throws Exception {
        Map param = new HashMap();
        param.put("parentId", 16);
        List<ItripLabelDic> itripLabelDics = itripLabelDicService.getItripLabelDicListByMap(param);
        return DtoUtil.returnDataSuccess(itripLabelDics);
    }

}
