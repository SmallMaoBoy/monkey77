/**
 * @date:创建时间：2015-12-26下午11:35:22
 * @author:mao
 * 
 */
package com.monkey77.service;

import java.util.HashMap;
import java.util.Map;

import com.monkey77.dao.ITAdminDao;
import com.monkey77.entities.TAdmin;
import com.monkey77.utils.MD5;

/**
 * @author mao
 * @time 创建时间 2015-12-26下午11:35:22
 * 
 */
public class AdminServiceImp implements IAdminService {

	/**
	 * @author mao
	 * @date 创建时间：2015-12-26下午11:35:22
	 * @see com.monkey77.service.IAdminService#checkRootLogin()
	 */
	private ITAdminDao adminDao;
	
	
	
	public ITAdminDao getAdminDao() {
		return adminDao;
	}



	public void setAdminDao(ITAdminDao adminDao) {
		this.adminDao = adminDao;
	}





}
