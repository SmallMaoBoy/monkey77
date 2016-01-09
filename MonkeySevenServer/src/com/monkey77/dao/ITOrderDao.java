/**
 * @date:创建时间：2016-1-9下午2:29:52
 * @author:mao
 * 
 */
package com.monkey77.dao;

import com.monkey77.entities.TOrder;

/**
 * @author mao
 * @time 创建时间 2016-1-9下午2:29:52
 * 
 */
public interface ITOrderDao {

	//创建订单
	public void createOrder(TOrder t);
}
