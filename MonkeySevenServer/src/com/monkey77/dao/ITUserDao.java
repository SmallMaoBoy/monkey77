package com.monkey77.dao;

import java.util.List;

import com.monkey77.entities.TUser;

public interface ITUserDao {
	
	//保存用户
	public void saveUser(TUser user);
	
	//根据id获取用户
	public TUser getUserById(int id);
	
	//判断是否该手机号码已注册
	public boolean isRegistered(String number);
	
	//根据手机号码获取密码
	public String getPasswordByMobile(String mobile);
	
	//根据手机号码返回用户
	public TUser getUserByMobile(String mobile);
	//获取用户信息列表
	public List<TUser> getUserList(int indexPage,int num);
	public int count();
	
	//更新用户图片
	public void updateUserPicUrl(int userId,String picUrl);
	
	public void updateUser(TUser user);
}
