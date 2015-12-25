package com.monkey77.dao;

import com.monkey77.entities.TAdmin;

public interface ITAdminDao {
	
	//保存管理员
	public void saveAdmin(TAdmin admin);
	
	//获取密码
	public String getPasswordByAccount(String account);
	
	//判断该用户是否存在
	public boolean isRegistered(String account);
}
