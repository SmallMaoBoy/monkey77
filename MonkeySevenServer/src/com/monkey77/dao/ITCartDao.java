/**
 * @date:创建时间：2016-1-2下午2:56:42
 * @author:mao
 * 
 */
package com.monkey77.dao;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.view.tiles.TilesJstlView;

import com.monkey77.entities.TCart;
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
	
	//添加物品
	public void insertCart(int userId,int goodId,int num);
	
	//删除物品
	public void delCart(int userId,int goodId,int num);
	
	//清空用户购物车
	public void clearCart(int userId);
	
	//添加物品
	public List<JsonCart> insertCartWithResult(int userId,int goodId,int num);
		
		//删除物品
	public List<JsonCart> delCartWithResult(int userId,int goodId,int num);
}
