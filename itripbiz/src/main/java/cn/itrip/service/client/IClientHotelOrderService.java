package cn.itrip.service.client;

import java.util.Map;

import cn.itrip.common.Page;
import cn.itrip.beans.pojo.ItripHotelOrder;
import cn.itrip.beans.vo.ITripHotelOrderVo;

public interface IClientHotelOrderService {

	/**
	 * 查询订单信息，行程/有效日期对应数据库表中的入住时间
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Page<ItripHotelOrder> searchITripHotelOrder(Map<String, Object> param) throws Exception; 
	
	/**
	 * 根据订单的id删除订单
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteITripHotelOrder(Integer id) throws Exception;
	
	/**
	 * 根据订单的id查询订单的详细信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ITripHotelOrderVo selectOrderDetailByPrimaryKey(Integer id) throws Exception;
	
	/**
	 * 继续提交订单，将未提交订单状态修改为已提交
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean commitOrder(Integer id) throws Exception;
	
	/**
	 * 添加或者修改订单信息
	 * @param itripHotelOrder
	 * @return
	 * @throws Exception
	 */
	public int saveOrUpdateItripHotelOrder(ItripHotelOrder itripHotelOrder) throws Exception;
}
