package cn.itrip.controller;

import javax.annotation.Resource;

import cn.itrip.beans.dtos.Dto;
import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import cn.itrip.beans.pojo.Hotel;
import cn.itrip.service.hotel.TestService;
import java.util.List;

@Controller
@Api(value = "API", basePath = "/http://api.itrap.com/api")
@RequestMapping(value="/api")
public class IndexController {
	
	private Logger logger = Logger.getLogger(IndexController.class);
	@Resource
	private TestService hotelService;
	
	/**
	 * 根据用户名获取用户对象
	 * @param name
	 * @return
	 */
	@ApiOperation(value = "query api basic information",httpMethod = "GET",produces = "application/json")
	@RequestMapping(value="/name/{name}", method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public Hotel getUserByName(@ApiParam(required = true, name = "name", value = "用户名") @PathVariable String name) throws Exception{
		Hotel hotel = new Hotel();
		hotel.setHotelName(name);
		return hotel;
	}

	
	@RequestMapping(value="/list.json",method=RequestMethod.POST,produces = "application/json")
	@ResponseBody
	@ApiOperation(value = "这是一个测试Swagger的一个接口", httpMethod = "POST",
			protocols = "HTTP",produces = "application/json",
			response = Hotel.class, notes = "这是一个测试Swagger的一个接口的notes")
	public Object getHotelList(
			@ApiParam(required = true, name = "hotel", value = "hotel")
			@RequestBody Hotel hotel){
		//hotel.setCityName("beijing");
		//String jsonString = JSONArray.toJSONString(hotel);
		String jsonString = null;
		logger.debug("++++++++++++" + hotel.getHotelName() + hotel.getCityId());

		Dto<List<Hotel>> dto = new Dto<List<Hotel>>();
		List<Hotel> hotelList = null;
		try {
			hotelList = hotelService.getHotelList(hotel);
			dto.setSuccess("true");
			dto.setErrorCode("0");
			dto.setMsg(null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			dto.setSuccess("false");
			dto.setErrorCode("100002");
			dto.setMsg("异常错误信息描述");
		}
		dto.setData(hotelList);
		jsonString = JSONArray.toJSONString(dto);
		logger.debug(jsonString);
		return jsonString;
	}
}
