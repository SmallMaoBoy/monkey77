/**
 * @date:创建时间：2016-1-8上午11:43:55
 * @author:mao
 * 
 */
package com.monkey77.dao;

import java.util.List;

import com.monkey77.entities.TShop;

/**
 * @author mao
 * @time 创建时间 2016-1-8上午11:43:55
 * 
 */
public interface ITShopDao {

	//创建商店
	public void createShop(TShop shop);
	
	//获取商店列表
	public List<TShop> getShopList(int indexPage,int num);
	
	//获取商店总数
	public int getShopCount();

	public Object getShopById(int id);
	public void deleteShopById(int id);
	
}
