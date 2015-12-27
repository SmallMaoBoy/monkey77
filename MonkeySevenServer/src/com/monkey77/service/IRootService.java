/**
 * @date:创建时间：2015-12-27上午12:59:10
 * @author:mao
 * 
 */
package com.monkey77.service;

import java.util.Map;

/**
 * @author mao
 * @time 创建时间 2015-12-27上午12:59:10
 * 
 */
public interface IRootService {

	//判断超级管理员密码
		public Map<String,Object> checkRootLogin(String account,String password);
		
		//创建新的管理员
		public void createNewRoot(String account,String password);
}
