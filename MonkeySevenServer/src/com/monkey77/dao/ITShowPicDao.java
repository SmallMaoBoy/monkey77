/**
 * @date:创建时间：2015-12-28下午3:14:32
 * @author:mao
 * 
 */
package com.monkey77.dao;

import java.util.List;

import com.monkey77.entities.TShowPic;

/**
 * @author mao
 * @time 创建时间 2015-12-28下午3:14:32
 * 
 */
public interface ITShowPicDao {

	//创建新的展示图片
	public void createNewPic(TShowPic showPic);
	
	//获取展示图片
	public List<TShowPic> getAllTShowPicList();
}
