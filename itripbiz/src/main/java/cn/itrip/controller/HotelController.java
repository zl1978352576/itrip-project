package cn.itrip.controller;
import cn.itrip.beans.dtos.Dto;
import cn.itrip.beans.pojo.ItripAreaDic;
import cn.itrip.beans.pojo.ItripLabelDic;
import cn.itrip.common.DtoUtil;
import cn.itrip.common.EmptyUtils;
import cn.itrip.service.itripAreaDic.ItripAreaDicService;
import cn.itrip.service.itripLabelDic.ItripLabelDicService;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.awt.EmbeddedFrame;

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
    @ApiOperation(value = "查询热门城市", httpMethod = "GET",
            protocols = "HTTP",produces = "application/json",
            response = Dto.class,notes = "查询国内、国外的热门城市(1:国内 2:国外)"+
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>"+
            "<p>10201 : hotelId不能为空 </p>"+
            "<p>10202 : 系统异常,获取失败</p>")
    @RequestMapping(value = "/queryhotcity/{type}/", produces = "application/json", method = RequestMethod.POST)
    @ResponseBody
    public Dto<ItripAreaDic> queryHotCity(@PathVariable Integer type) {
        List<ItripAreaDic> itripAreaDics = null;
        try {
            if(EmptyUtils.isNotEmpty(type)){
                Map param = new HashMap();
                param.put("isHot", 1);
                param.put("isChina", type);
                itripAreaDics = itripAreaDicService.getItripAreaDicListByMap(param);
            }else{
                DtoUtil.returnFail("type不能为空","10201");
            }
        } catch (Exception e) {
            DtoUtil.returnFail("系统异常","10202");
            e.printStackTrace();
        }
        return DtoUtil.returnDataSuccess(itripAreaDics);
    }

    /***
     * 查询商圈的接口
     *
     * @param cityId 根据城市查询商圈
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询商圈", httpMethod = "GET",
            protocols = "HTTP",produces = "application/json",
            response = Dto.class,notes = "根据城市查询商圈"+
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>"+
            "<p>10203 : cityId不能为空 </p>"+
            "<p>10204 : 系统异常,获取失败</p>")
    @RequestMapping(value = "/querytradearea/{cityId}", produces = "application/json", method = RequestMethod.POST)
    @ResponseBody
    public Dto<ItripAreaDic> queryTradeArea(@PathVariable Long cityId) {
        List<ItripAreaDic> itripAreaDics = null;
        try {
            if(EmptyUtils.isNotEmpty(cityId)){
                Map param = new HashMap();
                param.put("isTradingArea", 1);
                param.put("parent", cityId);
                itripAreaDics = itripAreaDicService.getItripAreaDicListByMap(param);
            }else{
                DtoUtil.returnFail("cityId不能为空","10203");
            }
        } catch (Exception e) {
            DtoUtil.returnFail("系统异常","10204");
            e.printStackTrace();
        }
        return DtoUtil.returnDataSuccess(itripAreaDics);
    }
    /***
     * 查询酒店特色列表
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询酒店特色列表", httpMethod = "GET",
            protocols = "HTTP",produces = "application/json",
            response = Dto.class,notes = "获取酒店特色(用于查询页列表)"+
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码: </p>"+
            "<p>10205: 系统异常,获取失败</p>")
    @RequestMapping(value = "/queryhotelfeature", produces = "application/json", method = RequestMethod.POST)
    @ResponseBody
    public Dto<ItripLabelDic> queryHotelFeature() {
        List<ItripLabelDic> itripLabelDics = null;
        try {
            Map param = new HashMap();
            param.put("parentId", 16);
            itripLabelDics = itripLabelDicService.getItripLabelDicListByMap(param);
        } catch (Exception e) {
            DtoUtil.returnFail("系统异常","10205");
            e.printStackTrace();
        }
        return DtoUtil.returnDataSuccess(itripLabelDics);
    }

}
