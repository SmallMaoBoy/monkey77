/**
 * @date:创建时间：2016-3-23下午1:57:19
 * @author:mao
 * 
 */
package com.monkey77.jsonobj;

import java.util.List;

/**
 * @author mao
 * @time 创建时间 2016-3-23下午1:57:19
 * 
 */
public class CartInfo {
	private List<JsonCart> cart;

	public List<JsonCart> getCart() {
		return cart;
	}

	public void setCart(List<JsonCart> cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "CartInfo [cart=" + cart + "]";
	}
}
