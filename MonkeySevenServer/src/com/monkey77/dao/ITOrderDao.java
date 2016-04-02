/**
 * @date:创建时间：2016-1-9下午2:29:52
 * @author:mao
 * 
 */
package com.monkey77.dao;

import java.util.List;

import com.monkey77.entities.TOrder;

/**
 * @author mao
 * @time 创建时间 2016-1-9下午2:29:52
 * 
 */
public interface ITOrderDao {

	//创建订单
	public void createOrder(TOrder t);
	
	//根据id获取订单
	public TOrder getOrderById(int id);
	
	//根据订单号获取订单
	public TOrder getOrderByOrderNo(String orderNo);
	
	//更新订单
	public void updateOrder(TOrder t);
	
	//获取订单列表
	public List<TOrder> getOrderListByUserId(int userId);
}
