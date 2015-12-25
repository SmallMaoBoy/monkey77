/**
 * @date:创建时间：2015-12-25上午11:24:28
 * @author:mao
 * 
 */
package com.monkey77.dao;

import java.util.List;

import com.monkey77.entities.TKeywords;

/**
 * @author mao
 * @time 创建时间 2015-12-25上午11:24:28
 * 
 */
public interface ITKeywordsDao {

	
	//更新KeyWords
	public void updateKeyWords(String keyWords);
	
	//获取搜索排前几的关键字
	public List<TKeywords> getKeyWordsList(int num);
}
