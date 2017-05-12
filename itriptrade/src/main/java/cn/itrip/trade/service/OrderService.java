package cn.itrip.trade.service;

import cn.itrip.beans.pojo.ItripHotelOrder;

public interface OrderService {

	/**
	 * 加载酒店订单
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	public ItripHotelOrder loadItripHotelOrder(long id) throws Exception;
	/**
	 * 支付成功
	 * @param id
	 * @throws Exception 
	 */
	public void paySuccess(long id,int payType) throws Exception;
	/**
	 * 支付失败
	 * @param id
	 * @throws Exception 
	 */
	public void payFailed(long id,int payType) throws Exception;
}
