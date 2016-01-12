/**
 * @date:创建时间：2016-1-12下午1:45:29
 * @author:mao
 * 
 */
package com.monkey77.action;

import java.util.Map;

import com.monkey77.service.IOrderService;
import com.opensymphony.xwork2.Action;

/**
 * @author mao
 * @time 创建时间 2016-1-12下午1:45:29
 * 
 */
public class OrderAction {
	private IOrderService orderService;
	private int userId;
	private Map<String, Object> map;
	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public IOrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}
	
	
	public String createOrder(){
		map=orderService.createOrder(userId);
		return Action.SUCCESS;
	}
}
