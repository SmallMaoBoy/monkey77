/**
 * @date:创建时间：2015-12-23上午11:17:58
 * @author:mao
 * 
 */
package com.monkey77.dao;

import java.util.List;

import com.monkey77.entities.TGood;

/**
 * @author mao
 * @time 创建时间 2015-12-23上午11:17:58
 * 
 */
public interface ITGoodDao {
	
	//保存商品
	public void saveGood(TGood good);
	
	//按照销量获取商品列表
	public List<TGood> getGoodsBySaleVolume();
	
	//获取总共商品数量
	public int getTotalCount();

}
