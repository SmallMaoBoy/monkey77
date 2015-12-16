package com.monkey77.dao;

import com.monkey77.entities.TUser;

public interface ITUserDao {
	
	//保存用户
	public void saveUser(TUser user);
	
	//根据id获取用户
	public TUser getUserById(int id);
	
	//判断是否该手机号码已注册
	public boolean isRegistered(String number);
}
