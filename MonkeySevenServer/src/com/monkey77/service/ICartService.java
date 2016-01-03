/**
 * @date:创建时间：2016-1-3下午11:02:21
 * @author:mao
 * 
 */
package com.monkey77.service;

import java.util.Map;

/**
 * @author mao
 * @time 创建时间 2016-1-3下午11:02:21
 * 
 */
public interface ICartService {

	//根据用户Id获取购物车信息
	public Map<String,Object> getCartByUserId(int userId);
	
	//增加商品
	public void addCart(int userId,int goodId,int num);
	
	//减少商品
	public void delCart(int userId,int goodId,int num);
	
	//清空购物车
	public void clearCart(int userId);
}
