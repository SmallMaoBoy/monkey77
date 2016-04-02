/**
 * @date:创建时间：2016-1-3下午11:02:21
 * @author:mao
 * 
 */
package com.monkey77.service;

import java.util.Map;
import java.util.Set;

import com.monkey77.entities.TOrderDetail;

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
	
	//根据手机号码获取购物车信息
	public Map<String,Object> getCartByMobile(String mobile);
	
	//将购物车中的信息组装到订单详情中，并更新商品表
	public Set<TOrderDetail> getOrderDetailFromCart(int userId);
	
	
	public Map<String,Object> updateCartByMobile(String mobile,String cartData);
}
