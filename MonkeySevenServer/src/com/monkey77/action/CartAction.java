/**
 * @date:创建时间：2016-1-3下午11:25:43
 * @author:mao
 * 
 */
package com.monkey77.action;

import java.util.Map;

import com.monkey77.service.ICartService;
import com.opensymphony.xwork2.Action;

/**
 * @author mao
 * @time 创建时间 2016-1-3下午11:25:43
 * 
 */
public class CartAction {

	private int num;
	private int userId;
	private int goodId;
	private Map<String,Object> map;
	private ICartService cartService;
	
	
	public ICartService getCartService() {
		return cartService;
	}
	public void setCartService(ICartService cartService) {
		this.cartService = cartService;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getGoodId() {
		return goodId;
	}
	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}
	
	public String getCartInfo(){
		map=cartService.getCartByUserId(userId);
		return Action.SUCCESS;
	}
	
	public String addCart(){
		cartService.addCart(userId, goodId, num);
		return Action.SUCCESS;
	}
	
	public String delCart(){
		cartService.delCart(userId, goodId, num);
		return Action.SUCCESS;
	}
	
	public String clearCart(){
		cartService.clearCart(userId);
		return Action.SUCCESS;
	}
}