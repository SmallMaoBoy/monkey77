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
	
	//增加旧商品数目商品
	public Map<String,Object> addOldCart(int userId,int goodId,int num);
	
	//增加新商品数目
	public void addNewCart(int userId,int goodId,int num);
	
	//减少商品
	public Map<String,Object> delCart(int userId,int goodId,int num);
	
	//清空购物车
	public void clearCart(int userId);
}
