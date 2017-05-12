package cn.itrip.trade.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cn.itrip.beans.pojo.ItripHotelOrder;
import cn.itrip.dao.itripHotelOrder.ItripHotelOrderMapper;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	private Logger logger=Logger.getLogger(OrderServiceImpl.class);
	@Resource
	private ItripHotelOrderMapper itripHotelOrderMapper;
	
	@Override
	public ItripHotelOrder loadItripHotelOrder(long id) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("加载订单："+id);
		return itripHotelOrderMapper.getItripHotelOrderById(id);
	}

	/**
	 * 
	 * @param id
	 * @param payType 支付方式:1:支付宝 2:微信 3:到店付
	 * @throws Exception
	 */
	@Override
	public void paySuccess(long id,int payType) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("订单支付成功："+id);
		ItripHotelOrder itripHotelOrder=this.loadItripHotelOrder(id);
		itripHotelOrder.setOrderNo(2);//支付成功
		itripHotelOrder.setPayType(payType);
		itripHotelOrderMapper.updateItripHotelOrder(itripHotelOrder);
	}

	@Override
	public void payFailed(long id,int payType) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("订单支付失败："+id);
		ItripHotelOrder itripHotelOrder=this.loadItripHotelOrder(id);
		itripHotelOrder.setOrderNo(1);//支付状态：已取消
		itripHotelOrder.setPayType(payType);
		itripHotelOrderMapper.updateItripHotelOrder(itripHotelOrder);
	}

}
