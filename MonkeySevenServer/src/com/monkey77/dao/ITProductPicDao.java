/**
 * @date:创建时间：2016-1-1下午4:45:22
 * @author:mao
 * 
 */
package com.monkey77.dao;

import java.util.List;

import com.monkey77.entities.TProductPic;

/**
 * @author mao
 * @time 创建时间 2016-1-1下午4:45:22
 * 
 */
public interface ITProductPicDao {

	//根据商品id获取商品图片
	public List<TProductPic> getProductPicByGoodId(int id);
	
	//更新图片商品关系
	public void saveOrUpdatePic(TProductPic productPic);
}
