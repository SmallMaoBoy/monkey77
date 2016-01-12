/**
 * @date:创建时间：2016-1-10下午11:44:34
 * @author:mao
 * 
 */
package com.monkey77.dao;

import java.util.Date;
import java.util.List;

import com.monkey77.entities.TDaySale;

/**
 * @author mao
 * @time 创建时间 2016-1-10下午11:44:34
 * 
 */
public interface ITDaySaleDao {

	//创建日销售记录
	public void createDaySale(TDaySale daySale);
	
	//获取指定日期的销售记录
	public List<TDaySale> getDaySale(Date date);
	
	//创建或更新日销售记录
	public void createOrUpdate(TDaySale daySale);

}
