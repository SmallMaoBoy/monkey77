/**
 * @date:创建时间：2016-1-11上午12:00:36
 * @author:mao
 * 
 */
package com.monkey77.service;

import java.util.Map;

/**
 * @author mao
 * @time 创建时间 2016-1-11上午12:00:36
 * 
 */
public interface IDaySaleService {

	//将订单中加入日销量表中
	public void addDaySale(int orderId);
	
	//获取日销售水果
	public Map<String,Object> getDaySale();
}
