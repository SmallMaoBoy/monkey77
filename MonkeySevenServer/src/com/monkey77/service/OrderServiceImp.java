/**
 * @date:创建时间：2016-1-10下午2:45:49
 * @author:mao
 * 
 */
package com.monkey77.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.monkey77.dao.ITCartDao;
import com.monkey77.dao.ITOrderDao;
import com.monkey77.dao.ITUserDao;
import com.monkey77.entities.TOrder;
import com.monkey77.entities.TShop;
import com.monkey77.entities.TUser;
import com.monkey77.jsonobj.StatusCode;
import com.monkey77.utils.OrderUtil;

/**
 * @author mao
 * @time 创建时间 2016-1-10下午2:45:49
 * 
 */
public class OrderServiceImp implements IOrderService{

	private ITUserDao userDao;
	private ITOrderDao orderDao;
	private ITCartDao cartDao;
	private IDaySaleService daySaleService;
	
	public IDaySaleService getDaySaleService() {
		return daySaleService;
	}


	public void setDaySaleService(IDaySaleService daySaleService) {
		this.daySaleService = daySaleService;
	}


	public ITUserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(ITUserDao userDao) {
		this.userDao = userDao;
	}


	public ITOrderDao getOrderDao() {
		return orderDao;
	}


	public void setOrderDao(ITOrderDao orderDao) {
		this.orderDao = orderDao;
	}


	public ITCartDao getCartDao() {
		return cartDao;
	}


	public void setCartDao(ITCartDao cartDao) {
		this.cartDao = cartDao;
	}


	/**
	 * @author mao
	 * @date 创建时间：2016-1-10下午2:46:11
	 * @see com.monkey77.service.IOrderService#createOrder(int)
	 */
	@Override
	public String createOrder(int userId) {
		// TODO Auto-generated method stub
		String orderNo=OrderUtil.getOrderNo();
		TOrder o=new TOrder();
		o.setOrderNo(orderNo);
		o.setStatus("待完善");
		o.setGeneratedTime(new Timestamp(System.currentTimeMillis()));
		o.getTUsers().add(new TUser(userId));
		o.setTOrderDetails(cartDao.getOrderDetil(userId));
		orderDao.createOrder(o);
		return orderNo;
	}


	/**
	 * statusCode:
	 * 0:成功提交订单
	 * 1:错误订单状态
	 * @author mao
	 * @date 创建时间：2016-1-10下午5:45:14
	 * @see com.monkey77.service.IOrderService#submissionOrder(int, java.lang.String, int, java.lang.String)
	 */
	@Override
	public Map<String,Object> submissionOrder(int shopId, String remark, String payway,
			String orderNo) {
		// TODO Auto-generated method stub
		StatusCode code=new StatusCode();
		TOrder order=orderDao.getOrderByOrderNo(orderNo);
		if(order.getStatus().equals("待完善")){
			order.setTShop(new TShop(shopId));
			order.setPayWay(payway);
			order.setRemarks(remark);
			if(payway.equals("在线支付")){
				order.setStatus("待购买");
			}else{
				order.setStatus("待付款");
				//更新日销量表
				daySaleService.addDaySale(order.getId());
			}
			order.setSubmissionTime(new Timestamp(System.currentTimeMillis()));
			orderDao.updateOrder(order);
			code.setStatusCode(0);
		}else{
			code.setStatusCode(1);
		}
		 Map<String,Object> map=new HashMap<String,Object>();
		 map.put("statusCode", code.getStatusCode());
		return map;
	}



}
