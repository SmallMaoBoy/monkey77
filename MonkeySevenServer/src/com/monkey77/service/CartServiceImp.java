/**
 * @date:创建时间：2016-1-3下午11:12:38
 * @author:mao
 * 
 */
package com.monkey77.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.monkey77.dao.ITCartDao;
import com.monkey77.jsonobj.JsonCart;

/**
 * @author mao
 * @time 创建时间 2016-1-3下午11:12:38
 * 
 */
public class CartServiceImp implements ICartService {
	
	private ITCartDao cartDao;

	
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
	 * @date 创建时间：2016-1-3下午11:12:38
	 * @see com.monkey77.service.ICartService#addCart(int, int, int)
	 */
	@Override
	public void addCart(int userId, int goodId, int num) {
		// TODO Auto-generated method stub
		cartDao.insertCart(userId, goodId, num);
	}

	/**
	 * @author mao
	 * @date 创建时间：2016-1-3下午11:12:38
	 * @see com.monkey77.service.ICartService#delCart(int, int, int)
	 */
	@Override
	public void delCart(int userId, int goodId, int num) {
		// TODO Auto-generated method stub
		cartDao.delCart(userId, goodId, num);
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

}
