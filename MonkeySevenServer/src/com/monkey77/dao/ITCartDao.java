/**
 * @date:创建时间：2016-1-2下午2:56:42
 * @author:mao
 * 
 */
package com.monkey77.dao;

import java.util.List;
import java.util.Set;

import com.monkey77.entities.TCart;
import com.monkey77.entities.TOrderDetail;
import com.monkey77.jsonobj.JsonCart;

/**
 * @author mao
 * @time 创建时间 2016-1-2下午2:56:42
 * 
 */
public interface ITCartDao {

	//创建Cart对象
	public void  createCart(TCart cart);
	
	//获取id用户的购物车
	public List<JsonCart> getCartByUserId(int id);
	
	//获取手机用户的购物车
	public List<JsonCart> getCartByMobile(String mobile);
	
	//添加物品
	public void insertCart(int userId,int goodId,int num);
	
	//删除物品
	public void delCart(int userId,int goodId,int num);
	
	//清空用户购物车
	public void clearCart(int userId);
	
	//添加物品并返回结果
	public List<JsonCart> insertCartWithResult(int userId,int goodId,int num);
		
	//删除物品并返回结果
	public List<JsonCart> delCartWithResult(int userId,int goodId,int num);
	
	//删除某一项物品
	public List<JsonCart> delCartWithResult(int userId,int goodId);
	
	//将购物车商品复制到订单中
	public Set<TOrderDetail> getOrderDetil(int userId);
}
