package com.monkey77.service;

import com.google.gson.JsonObject;
import com.monkey77.dao.ITUserDao;

public class UserServiceImp implements IUserService{

	private ITUserDao userDao;
	
	
	
	public ITUserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(ITUserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public String isExistMobile(String mobile) {
		// TODO Auto-generated method stub
		return userDao.isRegistered(mobile)==true?"0":"1";
	}

}
