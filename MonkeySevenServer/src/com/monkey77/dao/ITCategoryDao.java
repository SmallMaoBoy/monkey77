/**
 * @date:创建时间：2015-12-25上午10:39:11
 * @author:mao
 * 
 */
package com.monkey77.dao;

import java.util.List;

import com.monkey77.entities.TCategory;

/**
 * @author mao
 * @time 创建时间 2015-12-25上午10:39:11
 * 
 */
public interface ITCategoryDao {

	//根据名字获取商品种类
	public TCategory getCategoryByName(String name);
	
	//获取商品种类列表
	public List<TCategory> getCategoryList();
	
	//根据商品id获取商品种类
	public TCategory getCategoryByGoodId(int id);
	
}
