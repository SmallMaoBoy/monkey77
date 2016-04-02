/**
 * @date:创建时间：2016-1-3下午11:12:38
 * @author:mao
 * 
 */
package com.monkey77.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.monkey77.dao.ITCartDao;
import com.monkey77.dao.ITGoodDao;
import com.monkey77.dao.ITUserDao;
import com.monkey77.entities.TOrderDetail;
import com.monkey77.jsonobj.CartInfo;
import com.monkey77.jsonobj.JsonCart;

/**
 * @author mao
 * @time 创建时间 2016-1-3下午11:12:38
 * 
 */
public class CartServiceImp implements ICartService {
	
	private ITCartDao cartDao;
	private ITGoodDao goodDao;
	private ITUserDao userDao;
	
	public ITUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(ITUserDao userDao) {
		this.userDao = userDao;
	}

	public ITGoodDao getGoodDao() {
		return goodDao;
	}

	public void setGoodDao(ITGoodDao goodDao) {
		this.goodDao = goodDao;
	}

	public ITCartDao getCartDao() {
		return cartDao;
	}

	public void setCartDao(ITCartDao cartDao) {
		this.cartDao = cartDao;
	}

	/**
	 * @author mao
	 * @date 创建时间：2016-1-3下午11:12:38
	 * @see com.monkey77.service.ICartService#getCartByUserId(int)
	 */
	@Override
	public Map<String, Object> getCartByUserId(int userId) {
		// TODO Auto-generated method stub
		Map<String, Object> result=new HashMap<String, Object>();
		List<JsonCart> c=cartDao.getCartByUserId(userId);
		result.put("cart", c);
		return result;
	}

	/**
	 * @author mao
	 * @return 
	 * @date 创建时间：2016-1-3下午11:12:38
	 * @see com.monkey77.service.ICartService#addCart(int, int, int)
	 */
	@Override
	public Map<String, Object> addOldCart(int userId, int goodId, int num) {
		// TODO Auto-generated method stub
		Map<String, Object> result=new HashMap<String, Object>();
		List<JsonCart> c=cartDao.insertCartWithResult(userId, goodId, num);
		result.put("cart", c);
		return result;
	}

	/**
	 * @author mao
	 * @return 
	 * @date 创建时间：2016-1-3下午11:12:38
	 * @see com.monkey77.service.ICartService#delCart(int, int, int)
	 */
	@Override
	public Map<String, Object> delCart(int userId, int goodId, int num) {
		// TODO Auto-generated method stub
		Map<String, Object> result=new HashMap<String, Object>();
		List<JsonCart> c=cartDao.delCartWithResult(userId, goodId, num);
		result.put("cart", c);
		return result;
	}

	/**
	 * @author mao
	 * @date 创建时间：2016-1-3下午11:12:38
	 * @see com.monkey77.service.ICartService#clearCart(int)
	 */
	@Override
	public void clearCart(int userId) {
		// TODO Auto-generated method stub
		cartDao.clearCart(userId);
	}

	/**
	 * @author mao
	 * @date 创建时间：2016-1-7下午2:07:17
	 * @see com.monkey77.service.ICartService#addNewCart(int, int, int)
	 */
	@Override
	public void addNewCart(int userId, int goodId, int num) {
		// TODO Auto-generated method stub
		cartDao.insertCart(userId, goodId, num);
	}

	/**
	 * @date 创建时间：2016-1-9下午3:38:18
	 * @see com.monkey77.service.ICartService#getCartByMobile(int)
	 */
	@Override
	public Map<String, Object> getCartByMobile(String mobile) {
		// TODO Auto-generated method stub
		Map<String, Object> result=new HashMap<String, Object>();
		List<JsonCart> c=cartDao.getCartByMobile(mobile);
		result.put("cart", c);
		return result;
	}

	/**
	 * @author mao
	 * @date 创建时间：2016-2-1下午2:44:07
	 * @see com.monkey77.service.ICartService#getOrderDetailFromCart(int)
	 */
	@Override
	public Set<TOrderDetail> getOrderDetailFromCart(int userId) {
		// TODO Auto-generated method stub
		Set<TOrderDetail> orderDetail=cartDao.getOrderDetil(userId);
		for(TOrderDetail t:orderDetail){
			goodDao.decreaseGoodNum(t.getTGood().getId(), t.getGoodNumber());
		}
		return orderDetail;
	}

	/**
	 * @author mao
	 * @date 创建时间：2016-3-23下午1:56:19
	 * @see com.monkey77.service.ICartService#updateCartByMobile(java.lang.String, java.lang.String)
	 */
	@Override
	public Map<String, Object> updateCartByMobile(String mobile, String cartData) {
		// TODO Auto-generated method stub
		Gson g=new Gson();
		CartInfo ci=g.fromJson(cartData, CartInfo.class);
		int userId=userDao.getUserByMobile(mobile).getId();
		cartDao.updateCartByMobile(ci.getCart(), userId);
		Map<String, Object> result=new HashMap<String, Object>();
		result.put("statusCode", 0);
		return result;
	}

}
