package cn.itrip.controller;

import cn.itrip.beans.dtos.Dto;
import cn.itrip.beans.pojo.ItripUser;
import cn.itrip.beans.pojo.ItripUserLinkUser;
import cn.itrip.beans.vo.userinfo.ItripAddUserLinkUserVO;
import cn.itrip.beans.vo.userinfo.ItripModifyUserLinkUserVO;
import cn.itrip.common.DtoUtil;
import cn.itrip.common.ValidationToken;
import cn.itrip.service.itripUserLinkUser.ItripUserLinkUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;


/**
 * 用户信息Controller
 *
 * 包括API接口：
 * 1、根据UserId查询常用联系人接口
 * 2、指定用户下添加联系人
 * 3、修改指定用户下的联系人信息
 * 4、删除指定用户下的联系人信息
 *
 * 注：错误码（100101 ——100200）
 *
 * Created by hanlu on 2017/5/9.
 */

@Controller
@Api(value = "API", basePath = "/http://api.itrap.com/api")
@RequestMapping(value="/api/userinfo")
public class UserInfoController {
    private Logger logger = Logger.getLogger(UserInfoController.class);
    @Resource
    private ItripUserLinkUserService itripUserLinkUserService;

    @Resource
    private ValidationToken validationToken;

    /**
     * 根据UserId,联系人姓名查询常用联系人-add by donghai
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询常用联系人接口", httpMethod = "POST",
            protocols = "HTTP",produces = "application/json",
            response = Dto.class,notes = "查询常用联系人信息(可根据联系人姓名进行模糊查询)"+
            "<p>若不根据联系人姓名进行查询，入参 {\"linkUserName\":\"\"}即可 | 若根据联系人姓名进行查询，须进行相应的入参，比如：{\"linkUserName\":\"张三\"}</p>" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>"+
            "<p>100401 : 获取常用联系人信息失败 </p>"+
            "<p>100402 : token失效，请重登录</p>")
    @RequestMapping(value = "/queryuserlinkuser",method= RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public Dto<ItripUserLinkUser> queryUserLinkUser(@RequestBody String linkUserName,HttpServletRequest request){
        logger.debug("linkUserName : " + linkUserName);
        String tokenString  = request.getHeader("token");
        logger.debug("token name is from header : " + tokenString);
        ItripUser currentUser = validationToken.getCurrentUser(tokenString);
        List<ItripUserLinkUser> userLinkUserList = new ArrayList<ItripUserLinkUser>();
        Dto dto = null;
        if(null != currentUser){
            Map param = new HashMap();
            param.put("userId", currentUser.getId());
            param.put("linkUserName", linkUserName);
            try {
                userLinkUserList = itripUserLinkUserService.getItripUserLinkUserListByMap(param);
                return DtoUtil.returnSuccess("获取常用联系人信息成功",userLinkUserList);
            } catch (Exception e) {
                e.printStackTrace();
                return DtoUtil.returnFail("获取常用联系人信息失败","10401");
            }
        }else{
            return DtoUtil.returnFail("token失效，请重新登录","10402");
        }
    }

    @ApiOperation(value = "新增常用联系人接口", httpMethod = "POST",
            protocols = "HTTP",produces = "application/json",
            response = Dto.class,notes = "新增常用联系人信息"+
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>"+
            "<p>100411 : 新增常用联系人失败 </p>"+
            "<p>100412 : 不能提交空，请填写常用联系人信息</p>"+
            "<p>100413 : token失效，请重登录 </p>")
    @RequestMapping(value="/adduserlinkuser",method=RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public Dto<Object> addUserLinkUser(@RequestBody ItripAddUserLinkUserVO itripAddUserLinkUserVO, HttpServletRequest request){
        String tokenString  = request.getHeader("token");
        logger.debug("token name is from header : " + tokenString);
        ItripUser currentUser = validationToken.getCurrentUser(tokenString);
        if(null != currentUser && null != itripAddUserLinkUserVO){
            ItripUserLinkUser itripUserLinkUser = new ItripUserLinkUser();
            itripUserLinkUser.setLinkUserName(itripAddUserLinkUserVO.getLinkUserName());
            itripUserLinkUser.setLinkIdCardType(itripAddUserLinkUserVO.getLinkIdCardType());
            itripUserLinkUser.setLinkIdCard(itripAddUserLinkUserVO.getLinkIdCard());
            itripUserLinkUser.setUserId(currentUser.getId());
            itripUserLinkUser.setLinkPhone(itripAddUserLinkUserVO.getLinkPhone());
            itripUserLinkUser.setCreatedBy(currentUser.getId());
            itripUserLinkUser.setCreationDate(new Date(System.currentTimeMillis()));
            try {
                itripUserLinkUserService.addItripUserLinkUser(itripUserLinkUser);
            } catch (Exception e) {
                e.printStackTrace();
                return DtoUtil.returnFail("新增常用联系人失败", "10411");
            }
            return DtoUtil.returnSuccess("新增常用联系人成功");
        }else if(null != currentUser && null == itripAddUserLinkUserVO){
            return DtoUtil.returnFail("不能提交空，请填写常用联系人信息","10412");
        }else{
            return DtoUtil.returnFail("token失效，请重新登录", "10413");
        }
    }

    @ApiOperation(value = "修改常用联系人接口", httpMethod = "POST",
            protocols = "HTTP",produces = "application/json",
            response = Dto.class,notes = "修改常用联系人信息"+
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>"+
            "<p>100421 : 修改常用联系人失败 </p>"+
            "<p>100422 : 不能提交空，请填写常用联系人信息</p>"+
            "<p>100423 : token失效，请重登录 </p>")
    @RequestMapping(value="/modifyuserlinkuser",method=RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public Dto<Object> updateUserLinkUser(@RequestBody ItripModifyUserLinkUserVO itripModifyUserLinkUserVO, HttpServletRequest request){
        String tokenString  = request.getHeader("token");
        logger.debug("token name is from header : " + tokenString);
        ItripUser currentUser = validationToken.getCurrentUser(tokenString);
        if(null != currentUser && null != itripModifyUserLinkUserVO){
            ItripUserLinkUser itripUserLinkUser = new ItripUserLinkUser();
            itripUserLinkUser.setId(itripModifyUserLinkUserVO.getId());
            itripUserLinkUser.setLinkUserName(itripModifyUserLinkUserVO.getLinkUserName());
            itripUserLinkUser.setLinkIdCardType(itripModifyUserLinkUserVO.getLinkIdCardType());
            itripUserLinkUser.setLinkIdCard(itripModifyUserLinkUserVO.getLinkIdCard());
            itripUserLinkUser.setUserId(currentUser.getId());
            itripUserLinkUser.setLinkPhone(itripModifyUserLinkUserVO.getLinkPhone());
            itripUserLinkUser.setModifiedBy(currentUser.getId());
            itripUserLinkUser.setModifyDate(new Date(System.currentTimeMillis()));
            try {
                itripUserLinkUserService.modifyItripUserLinkUser(itripUserLinkUser);
            } catch (Exception e) {
                e.printStackTrace();
                return DtoUtil.returnFail("修改常用联系人失败", "10421");
            }
            return DtoUtil.returnSuccess("修改常用联系人成功");
        }else if(null != currentUser && null == itripModifyUserLinkUserVO){
            return DtoUtil.returnFail("不能提交空，请填写常用联系人信息","10422");
        }else{
            return DtoUtil.returnFail("token失效，请重新登录", "10423");
        }
    }

    @ApiOperation(value = "删除常用联系人接口", httpMethod = "GET",
            protocols = "HTTP",produces = "application/json",
            response = Dto.class,notes = "删除常用联系人信息"+
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>"+
            "<p>100431 : 删除常用联系人失败 </p>"+
            "<p>100432 : 请选择要删除的常用联系人</p>"+
            "<p>100433 : token失效，请重登录 </p>")
    @RequestMapping(value="/deluserlinkuser",method=RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public Dto<Object> delUserLinkUser(Long id, HttpServletRequest request) {
        String tokenString  = request.getHeader("token");
        logger.debug("token name is from header : " + tokenString);
        ItripUser currentUser = validationToken.getCurrentUser(tokenString);
        if(null != currentUser && null != id){
            try {
                itripUserLinkUserService.deleteItripUserLinkUserById(id);
            } catch (Exception e) {
                e.printStackTrace();
                return DtoUtil.returnFail("删除常用联系人失败","10431");
            }
            return DtoUtil.returnSuccess("删除常用联系人成功");
        }else if(null != currentUser && null == id){
            return DtoUtil.returnFail("请选择要删除的常用联系人","10432");
        }else{
            return DtoUtil.returnFail("token失效，请重新登录","10433");
        }
    }

}
