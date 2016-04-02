/**
 * @date:创建时间：2016-1-3下午11:25:43
 * @author:mao
 * 
 */
package com.monkey77.action;

import java.util.List;
import java.util.Map;

import com.monkey77.jsonobj.JsonCart;
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
	private String mobile;
	private String cartData;
	private Map<String,Object> map;
	private ICartService cartService;
	private List<JsonCart> cart;
	
	
	public List<JsonCart> getCart() {
		return cart;
	}
	public void setCart(List<JsonCart> cart) {
		this.cart = cart;
	}
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
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
	
	public String getCartData() {
		return cartData;
	}
	public void setCartData(String cartData) {
		this.cartData = cartData;
	}
	public String getCartInfo(){
		map=cartService.getCartByUserId(userId);
		return Action.SUCCESS;
	}
	

	public String addOldCart(){
		map=cartService.addOldCart(userId, goodId, num);
		return Action.SUCCESS;
	}
	
	

	public String getCartInfoByMobile(){
		map=cartService.getCartByMobile(mobile);
		System.out.println(map);
		return Action.SUCCESS;
	}
	
	public String addNewCart(){
		cartService.addNewCart(userId, goodId, num);
		return Action.SUCCESS;
	}
	
	public String delCart(){
		map=cartService.delCart(userId, goodId, num);
		return Action.SUCCESS;
	}
	
	public String clearCart(){
		cartService.clearCart(userId);
		return Action.SUCCESS;
	}
	
	public String updateCart(){
		System.out.println(mobile);
		System.out.println(cartData);
		System.out.println(cart);
		cartService.updateCartByMobile(mobile, cartData);
		System.out.println(map);
		return Action.SUCCESS;
	}
}
