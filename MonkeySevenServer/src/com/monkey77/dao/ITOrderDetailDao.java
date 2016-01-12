/**
 * @date:创建时间：2016-1-11上午12:04:53
 * @author:mao
 * 
 */
package com.monkey77.dao;

import java.util.List;

import com.monkey77.entities.TOrderDetail;
import com.monkey77.jsonobj.Good;
import com.monkey77.jsonobj.JsonCart;

/**
 * @author mao
 * @time 创建时间 2016-1-11上午12:04:53
 * 
 */
public interface ITOrderDetailDao {

	//获取订单详情
	public List<TOrderDetail> getOrderDetail(int orderId);
	
	//获取订单详情
	public List<Good> getGoodsByOrderId(int orderId);
	
}
