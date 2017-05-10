package cn.itrip.controller;

import cn.itrip.beans.dtos.Dto;
import cn.itrip.beans.dtos.InputDto;
import cn.itrip.beans.pojo.ItripComment;
import cn.itrip.beans.pojo.ItripImage;
import cn.itrip.beans.pojo.ItripUser;
import cn.itrip.beans.vo.comment.ItripAddCommentVO;
import cn.itrip.common.ValidationToken;
import cn.itrip.service.itripComment.ItripCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
import cn.itrip.common.SystemConfig;

/**
 * 评论Controller
 *
 * 包括API接口：
 * 1、根据type 和target id 查询评论照片
 * 2、据酒店id查询酒店平均分
 * 3、根据酒店id查询评论数量
 * 4、根据评论类型查询评论 分页
 * 5、上传评论图片
 * 6、删除评论图片
 * 7、新增评论信息
 *
 * Created by hanlu on 2017/5/9.
 */
@Controller
//@Api(value = "API", basePath = "/http://api.itrap.com/api")
@RequestMapping(value="/api/comment")
public class SystemCommentController {
	private Logger logger = Logger.getLogger(SystemCommentController.class);
	@Resource
	private SystemConfig systemConfig;

	@Resource
	private ItripCommentService itripCommentService;

	@Resource
	private ValidationToken validationToken;


	@ApiOperation(value = "新增评论接口", httpMethod = "POST",
			protocols = "HTTP",produces = "application/json",
			response = Dto.class,notes = "新增评论信息"+
			"<p style=‘color:red’>注意：若有评论图片，需要传图片路径</p>"+
			"<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
			"<p>错误码：</p>"+
			"<p>100040 : 新增评论失败 </p>"+
			"<p>100041 : 不能提交空，请填写评论信息</p>"+
			"<p>100042 : token失效，请重登录 </p>")
	@RequestMapping(value = "/addcomment",method=RequestMethod.POST,produces = "application/json")
	@ResponseBody
	public Dto<Object> addComment(@RequestBody ItripAddCommentVO itripAddCommentVO, HttpServletRequest request){
		//ItripComment
		Dto<Object> dto = new Dto<Object>();
		String tokenString  = request.getHeader("token");
		logger.debug("token name is from header : " + tokenString);
		ItripUser currentUser = validationToken.getCurrentUser(tokenString);
		if(null != currentUser && null != itripAddCommentVO){
			List<ItripImage> itripImages = null;
			ItripComment itripComment = new ItripComment();
			itripComment.setContent(itripAddCommentVO.getContent());
			itripComment.setCreatedBy(currentUser.getId());
			itripComment.setCreationDate(new Date(System.currentTimeMillis()));
			itripComment.setUserId(currentUser.getId());
			itripComment.setHotelId(itripAddCommentVO.getHotelId());
			itripComment.setIsHavingImg(itripAddCommentVO.getIsHavingImg());
			itripComment.setPositionScore(itripAddCommentVO.getPositionScore());
			itripComment.setFacilitiesScore(itripAddCommentVO.getFacilitiesScore());
			itripComment.setHygieneScore(itripAddCommentVO.getHygieneScore());
			itripComment.setOrderId(itripAddCommentVO.getOrderId());
			itripComment.setServiceScore(itripAddCommentVO.getServiceScore());
			itripComment.setProductId(itripAddCommentVO.getProductId());
			itripComment.setProductType(itripAddCommentVO.getProductType());
			try {
				if(itripAddCommentVO.getIsHavingImg() == 1 ){
					itripImages = new ArrayList<ItripImage>();
					//loop input imgs array
					int i = 1;
					for (ItripImage itripImage : itripAddCommentVO.getItripImages()) {
						itripImage.setPosition(i);
						itripImage.setCreatedBy(currentUser.getId());
						itripImage.setCreationDate(itripComment.getCreationDate());
						itripImage.setType("2");
						itripImages.add(itripImage);
						i++;
					}
				}
				itripCommentService.itriptxAddItripComment(itripComment,(null == itripImages?new ArrayList<ItripImage>():itripImages));
			} catch (Exception e) {
				e.printStackTrace();
				dto.setSuccess("false");
				dto.setErrorCode("100040");
				dto.setMsg("新增评论失败");
			}
			dto.setSuccess("true");
			dto.setMsg("新增评论成功");
		}else if(null != currentUser && null == itripAddCommentVO){
			dto.setSuccess("false");
			dto.setErrorCode("100041");
			dto.setMsg("不能提交空，请填写评论信息");
		}else{
			dto.setSuccess("false");
			dto.setErrorCode("100042");
			dto.setMsg("token失效，请重登录");
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
				ItripUser itripUser = validationToken.getCurrentUser(tokenString);
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
					response = Dto.class, notes = "删除传递图片名称"
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



