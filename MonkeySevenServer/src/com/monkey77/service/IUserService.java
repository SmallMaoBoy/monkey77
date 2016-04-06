package com.monkey77.service;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

public interface IUserService {

	//判断手机号码是否存在
	public String isExistMobile(String mobile);
	
	//根据手机号码发送验证码
	public void sendIdentifyingCode(String mobile) throws Exception;
	
	//注册新用户
	public String register(String mobile,String identifyingCode,String password);
	
	//根据密码登录
	public Map<String, Object> loginByPassword(String mobile,String password);
	
	//根据密码登录,同时保存cookie
	public Map<String, Object> loginByPasswordWithCookie(String mobile,String password,HttpServletResponse

 response,String sessionid);
	//获取用户信息
	public Map<String, Object> getUserList(int indexPage);
	
	//更新用户的头像
	public void updateUserPicUrl(int userId,String picUrl);
	
	//获取用户信息
	public Map<String, Object> getUserInfo(int userId);
	
	//更新用户信息
	public Map<String, Object> updateUserInfo(int userId,String mobile,String mail,Date date,int sex,String name);
	
	//判断密码是否正确
	public Map<String, Object> checkPasswordByUserId(int userId,String password);
	
	//更改用户密码
	public Map<String, Object> updatePasswordByUserId(int userId,String password,String newPassword);
}
