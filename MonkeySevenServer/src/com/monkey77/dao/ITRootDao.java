/**
 * @date:创建时间：2015-12-27下午12:53:29
 * @author:mao
 * 
 */
package com.monkey77.dao;

import com.monkey77.entities.TRoot;

/**
 * @author mao
 * @time 创建时间 2015-12-27下午12:53:29
 * 
 */
public interface ITRootDao {

	//根据账号获取超级管理员的密码
	public String getPasswordByAccount(String account);
	
	//创建新的管理员账号
	public void createNewRoot(TRoot root);
}
