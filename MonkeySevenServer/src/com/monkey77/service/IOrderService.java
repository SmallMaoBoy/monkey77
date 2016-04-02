/**
 * @date:创建时间：2016-1-10下午2:43:42
 * @author:mao
 * 
 */
package com.monkey77.service;

import java.util.Map;

/**
 * @author mao
 * @time 创建时间 2016-1-10下午2:43:42
 * 
 */
public interface IOrderService {

	//创建订单
	public Map<String,Object> createOrder(int userId);
	
	//提交订单
	public Map<String,Object> submissionOrder(int userId,int shopId,String remark,String payway,String orderNo);

	//获取订单详情
	public Map<String,Object> getOrderInfo(String orderNo,int userId);
	
	public Map<String,Object> createOrderByMobile(String mobile);

	public Map<String,Object> submissionOrderByMobile(String mobile,int shopId,String remark,String payway,String orderNo);
	
	public Map<String,Object> getOrderListByUserId(int userId);
	
	public Map<String,Object> getOrderListByUserMobile(String mobile);
}
