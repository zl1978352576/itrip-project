package cn.itrip.controller;

import cn.itrip.beans.dtos.Dto;
import cn.itrip.beans.dtos.InputDto;
import cn.itrip.beans.pojo.ItripComment;
import cn.itrip.service.client.IClientCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import cn.itrip.common.RedisAPI;
import cn.itrip.common.SystemConfig;
import cn.itrip.beans.pojo.ItripUser;

import com.alibaba.fastjson.JSONObject;

@Controller
@Api(value = "API", basePath = "/http://api.itrap.com/api")
@RequestMapping(value="/api")
public class SystemCommentController {
	private Logger logger = Logger.getLogger(SystemCommentController.class);
	@Resource
	SystemConfig systemConfig;
	@Resource
	RedisAPI redisAPI;
	@Resource
	private IClientCommentService iClientCommentService;


	@ApiOperation(value = "这是一个测试Swagger的一个接口", httpMethod = "POST",
			protocols = "HTTP",produces = "application/json",
			response = ItripComment.class, notes = "添加评论")
	@RequestMapping(value = "/addComment",method=RequestMethod.POST,produces = "application/json")
	@ResponseBody
	public Dto<Object> addComment(@RequestBody ItripComment itripComment){
		//ItripComment
		Dto<Object> dto = new Dto<Object>();
		if(null != itripComment){
			dto.setSuccess("true");
			try {
				iClientCommentService.addItripComment(itripComment);
			} catch (Exception e) {
				dto.setSuccess("false");
			}
		}else{
			dto.setSuccess("false");
		}

		return dto;
	}

	@RequestMapping("/upload")
	@ResponseBody
	@ApiOperation(value = "图片上传接口", httpMethod = "POST",
					protocols = "HTTP",produces = "multipart/form-data",
					response = Dto.class, notes = "上传评论图片，最多支持4张图片同时上传，格式为：jpg、jpeg、png，大小不超过5M"+
					"<p style=‘color:red’>注意：input file 中的name不可重复 e:g : file1 、 file2 、 fileN</p>"+
					"<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" + 
					"<p>错误码：</p>"+
					"<p>100020 : 文件上传失败 </p>"+
					"<p>100021 : 上传的文件数不正确，必须是大于1小于等于4 </p>" +
					"<p>100022 : 请求的内容不是上传文件的类型 </p>" +
					"<p>100023 : 文件大小超限 </p>"
				)
    public Dto<Object> uploadPic(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException {  
		Dto<Object> dto = new Dto<Object>();
		List<String> dataList = new ArrayList<String>();
		//创建一个通用的多部分解析器  
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
        //判断 request 是否有文件上传,即多部分请求  
        if(multipartResolver.isMultipart(request)){  
            //转换成多部分request    
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
            int fileCount = 0;
            try{
	            	fileCount = multiRequest.getFileMap().size();
	           }catch (Exception e) {
				// TODO: handle exception
	        	   fileCount = 0;
	        	   dto.setSuccess("false");
	               dto.setErrorCode("100023");//文件大小超限
	               dto.setMsg("文件大小超限");
	               return dto; 
	           }
            logger.debug("user upload files count: " + fileCount);
            
            if(fileCount > 0 && fileCount <= 4 ){
            	String tokenString  = multiRequest.getHeader("token");
                logger.debug("token name is from header : " + tokenString);
                //根据token从redis中获取用户信息
                /*
                 test token:
                 key : token:1qaz2wsx
                 value : {"id":"100078","userCode":"myusercode","userPassword":"78ujsdlkfjoiiewe98r3ejrf","userType":"1","flatID":"10008989"}
                
                */
                ItripUser itripUser = null;
                try{
                String userInfoJson = redisAPI.get(tokenString);
                itripUser = JSONObject.parseObject(userInfoJson,ItripUser.class);
                }catch(Exception e){
                	itripUser = null;
                	logger.error("get userinfo from redis but is error : " + e.getMessage());
                }
                if(null != itripUser){
                	logger.debug("user not null and id is : " + itripUser.getId());
                	//取得request中的所有文件名  
                    Iterator<String> iter = multiRequest.getFileNames();
                    while(iter.hasNext()){
                    	try{
                    		//取得上传文件  
                            MultipartFile file = multiRequest.getFile(iter.next());  
                            if(file != null){  
                                //取得当前上传文件的文件名称  
                                String myFileName = file.getOriginalFilename();  
                                //如果名称不为“”,说明该文件存在，否则说明该文件不存在  
                                if(myFileName.trim() !="" 
                                		&& 
                                		(
                                			myFileName.toLowerCase().contains(".jpg")
                                			|| myFileName.toLowerCase().contains(".jpeg")
                                			|| myFileName.toLowerCase().contains(".png")
                                		) ){  
                                    //重命名上传后的文件名  
                                	//命名规则：用户id+当前时间+随机数
                                	String suffixString = myFileName.substring(file.getOriginalFilename().indexOf("."));
                                    String fileName = itripUser.getId()+ "-" + System.currentTimeMillis() + "-" + ((int)(Math.random()*10000000)) + suffixString;  
                                    //定义上传路径  
                                    String path = systemConfig.getFileUploadPathString() + File.separator +fileName;  
                                    logger.debug("uploadFile path : " + path);
                                    File localFile = new File(path); 
                                    file.transferTo(localFile);  
                                    dataList.add(systemConfig.getVisitImgUrlString()+fileName);
                                }
                            }
                    	}catch (Exception e) {
    						continue;
    					}
                    } 
                    dto.setSuccess("true");
                    dto.setMsg("文件上传成功");
                    dto.setData(dataList);
                }else{
                	dto.setSuccess("false");
                	dto.setErrorCode("100020");//文件上传失败
                	dto.setMsg("文件上传失败");
                }
            }else{
            	dto.setSuccess("false");
            	dto.setErrorCode("100021");//上传的文件数不正确，必须是大于1小于等于4
            	dto.setMsg("上传的文件数不正确，必须是大于1小于等于4");
            }        
        }else{
        	dto.setSuccess("false");
        	dto.setErrorCode("100022");//请求的内容不是上传文件的类型
        	dto.setMsg("请求的内容不是上传文件的类型");
        }  
        return dto;  
    } 
	
	
	@RequestMapping(value = "/delpic",produces="application/json",method = RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value = "图片删除接口", httpMethod = "DELETE",
					protocols = "HTTP",produces = "application/json",
					response = Dto.class, notes = ""
				)
	/*public Dto<Object> delPic(
    		@ApiParam(required = true, name = "imgName", value = "imgName") 
    		@RequestBody String imgName) throws IllegalStateException, IOException {  */
	public Dto<Object> delPic(
    		@RequestBody InputDto inputDto) throws IllegalStateException, IOException {
		Dto<Object> dto = new Dto<Object>();
		//获取物理路径
		String path = systemConfig.getFileUploadPathString() + File.separator + inputDto.getParamString();
		logger.debug("delete file path : " + path);
		File file = new File(path);
		if(file.exists()){
			file.delete();
			dto.setSuccess("true");
			dto.setMsg("删除成功");
			dto.setErrorCode("0");
		}else{
			dto.setSuccess("false");
			dto.setMsg("文件不存在，删除失败");
			dto.setErrorCode("100030");
		}
		return dto;
	}
	
}



