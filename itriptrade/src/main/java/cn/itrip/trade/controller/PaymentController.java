package cn.itrip.trade.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradeWapPayRequest;

import cn.itrip.beans.pojo.ItripHotelOrder;
import cn.itrip.common.EmptyUtils;
import cn.itrip.trade.config.AlipayConfig;
import cn.itrip.trade.service.OrderService;

/**
 * 支付处理控制器
 *
 * @author hduser
 *
 */
@Controller
@RequestMapping("/payment")
public class PaymentController {

	@Resource
	private AlipayConfig alipayConfig;
	@Resource
	private OrderService orderService;

	/**
	 * 确认订单信息
	 *
	 * @param id
	 *            订单ID
	 * @return
	 */
	@RequestMapping(value = "/prepay/{id}", method = RequestMethod.GET)
	public String prePay(@PathVariable long id, ModelMap model) {
		try {
			ItripHotelOrder order = orderService.loadItripHotelOrder(id);

			if (!EmptyUtils.isEmpty(order)) {
				model.addAttribute("hotelName", order.getHotelName());
				model.addAttribute("roomId", order.getRoomId());
				model.addAttribute("count", order.getCount());
				model.addAttribute("payAmount", order.getPayAmount());
				return "pay";
			}
			return "error";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}

	}

	/**
	 * 向支付宝提交支付请求
	 *
	 * @param WIDout_trade_no
	 *            商户订单号，商户网站订单系统中唯一订单号，必填
	 * @param WIDsubject
	 *            订单名称，必填
	 * @param WIDtotal_amount
	 *            付款金额，必填
	 */
	@RequestMapping(value = "/pay", method = RequestMethod.POST)
	public void pay(String WIDout_trade_no, String WIDsubject,
					String WIDtotal_amount, HttpServletResponse response) {
		// 超时时间 可空
		String timeout_express = "2m";
		// 销售产品码 必填
		String product_code = "QUICK_WAP_PAY";
		/**********************/
		// SDK 公共请求类，包含公共请求参数，以及封装了签名与验签，开发者无需关注签名与验签
		// 调用RSA签名方式
		AlipayClient client = new DefaultAlipayClient(
				alipayConfig.getUrl(),
				alipayConfig.getAppID(),
				alipayConfig.getRsaPrivateKey(),
				alipayConfig.getFormat(),
				alipayConfig.getCharset(),
				alipayConfig.getAlipayPublicKey(),
				alipayConfig.getSignType());
		AlipayTradeWapPayRequest alipay_request = new AlipayTradeWapPayRequest();

		// 封装请求支付信息
		AlipayTradeWapPayModel model = new AlipayTradeWapPayModel();
		model.setOutTradeNo(WIDout_trade_no);
		model.setSubject(WIDsubject);
		model.setTotalAmount(WIDtotal_amount);
		model.setTimeoutExpress(timeout_express);
		model.setProductCode(product_code);
		alipay_request.setBizModel(model);
		// 设置异步通知地址
		alipay_request.setNotifyUrl(alipayConfig.getNotifyUrl());
		// 设置同步地址
		alipay_request.setReturnUrl(alipayConfig.getReturnUrl());
		// form表单生产
		String form = "";
		try {
			// 调用SDK生成表单
			form = client.pageExecute(alipay_request).getBody();
			System.out.println(form);
			response.setContentType("text/html;charset=" + alipayConfig.getCharset());
			response.getWriter().write(form);// 直接将完整的表单html输出到页面
			response.getWriter().flush();
			response.getWriter().close();
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
