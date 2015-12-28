/**
 * @date:创建时间：2015-12-28下午4:46:43
 * @author:mao
 * 
 */
package com.monkey77.service;

import java.util.Map;

/**
 * @author mao
 * @time 创建时间 2015-12-28下午4:46:43
 * 
 */
public interface ISMSService {

	//查看当前用户的基本信息
	public Map<String,Object> getAccountInfo();
}
