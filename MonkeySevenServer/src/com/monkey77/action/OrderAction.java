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
	private String orderNo;
	private int shopId;
	private String remark;
	private String payway;
	private Map<String, Object> map;
	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPayway() {
		return payway;
	}

	public void setPayway(String payway) {
		this.payway = payway;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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
	
	public String getOrderInfo(){
		map=orderService.getOrderInfo(orderNo,userId);
		return Action.SUCCESS;
	}
	
	public String submissionOrder(){
		map=orderService.submissionOrder(userId,shopId, remark, payway, orderNo);
		return Action.SUCCESS;
	}
}
