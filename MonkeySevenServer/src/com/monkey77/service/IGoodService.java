/**
 * @date:创建时间：2015-12-23下午4:20:31
 * @author:mao
 * 
 */
package com.monkey77.service;

import java.util.Map;

/**
 * @author mao
 * @time 创建时间 2015-12-23下午4:20:31
 * 
 */
public interface IGoodService {
	
	//用户默认获得商品列表
	public Map<String,Object> getDefalutList(int page);
}
