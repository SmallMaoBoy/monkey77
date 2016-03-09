/**
 * @date:创建时间：2016-1-10下午2:45:49
 * @author:mao
 * 
 */
package com.monkey77.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.monkey77.dao.ITCartDao;
import com.monkey77.dao.ITOrderDao;
import com.monkey77.dao.ITOrderDetailDao;
import com.monkey77.dao.ITShopDao;
import com.monkey77.dao.ITUserDao;
import com.monkey77.entities.TOrder;
import com.monkey77.entities.TOrderDetail;
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
	private ITShopDao shopDao;
	private ITOrderDetailDao orderDetailDao;
	private ICartService cartService;
	
	
	public ICartService getCartService() {
		return cartService;
	}


	public void setCartService(ICartService cartService) {
		this.cartService = cartService;
	}


	public ITOrderDetailDao getOrderDetailDao() {
		return orderDetailDao;
	}


	public void setOrderDetailDao(ITOrderDetailDao orderDetailDao) {
		this.orderDetailDao = orderDetailDao;
	}


	public ITShopDao getShopDao() {
		return shopDao;
	}


	public void setShopDao(ITShopDao shopDao) {
		this.shopDao = shopDao;
	}


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


	/**创建订单
	 * @author mao
	 * @date 创建时间：2016-1-10下午2:46:11
	 * @see com.monkey77.service.IOrderService#createOrder(int)
	 */
	@Override
	public Map<String,Object> createOrder(int userId) {
		// TODO Auto-generated method stub
		String orderNo=OrderUtil.getOrderNo();
		TOrder o=new TOrder();
		o.setOrderNo(orderNo);
		o.setStatus("待完善");
		o.setGeneratedTime(new Timestamp(System.currentTimeMillis()));
		o.getTUsers().add(new TUser(userId));
		Set<TOrderDetail> orderDetail=cartService.getOrderDetailFromCart(userId);
		o.setTOrderDetails(orderDetail);
		Float price=0f;
		for(TOrderDetail t:orderDetail){
			price+=t.getGoodPrice();
		}
		o.setTotalPrice(price);
		orderDao.createOrder(o);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("orderNo",orderNo);
		return map;
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
	public Map<String,Object> submissionOrder(int userId,int shopId, String remark, String payway,
			String orderNo) {
		// TODO Auto-generated method stub
		StatusCode code=new StatusCode();
		TOrder order=orderDao.getOrderByOrderNo(orderNo);
		order.setTShop(new TShop(shopId));
		order.setPayWay(payway);
		order.setRemarks(remark);
		if(order.getStatus().equals("待完善")){
			if(payway.equals("线下支付")){
				order.setStatus("待购买");
				//更新日销量表
				daySaleService.addDaySale(order.getId());
				//清除购物车信息
				cartDao.clearCart(userId);
				//更新商品标，修改商品数量
			}else{
				order.setStatus("待付款");
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


	/**
	 * @author mao
	 * @date 创建时间：2016-1-12下午4:29:21
	 * @see com.monkey77.service.IOrderService#getOrderInfo(java.lang.String)
	 */
	@Override
	public Map<String, Object> getOrderInfo(String orderNo,int userId) {
		// TODO Auto-generated method stub
		TOrder order=orderDao.getOrderByOrderNo(orderNo);
		Map<String,Object> map=new HashMap<String,Object>();
		if(order.getStatus().equals("待完善")){
			map.put("shops", shopDao.getShopList());
			map.put("carts", cartDao.getCartByUserId(userId));
		}
		return map;
	}

}
