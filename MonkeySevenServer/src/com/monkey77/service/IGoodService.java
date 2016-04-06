/**
 * @date:创建时间：2015-12-23下午4:20:31
 * @author:mao
 * 
 */
package com.monkey77.service;

import java.util.Map;

import com.monkey77.entities.TGood;

/**
 * @author mao
 * @time 创建时间 2015-12-23下午4:20:31
 * 
 */
public interface IGoodService {
	
	//用户默认获得商品列表
	public Map<String,Object> getDefalutList(int page,int orderType);
	
	//根据分类获取商品列表
	public Map<String,Object> getSortList(int page,int orderType,String sort);
	
	//根据关键字获取商品列表
	public Map<String,Object> getKeyWordsList(int page,int orderType,String keyWords);
	
	//根据商品id获取商品详情
	public Map<String,Object> getGoodDetailById(int id);
	
	//创建商品
	public int createGood(TGood good);
	
	//修改商品首页图片
	public void updateGoodPic(int goodId,String picUrl);
	
	//增加商品图片
	public void addGoodPic(int goodId,String picUrl,int type);
}
