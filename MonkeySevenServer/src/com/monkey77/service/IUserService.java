package com.monkey77.service;

public interface IUserService {

	//判断手机号码是否存在
	public String isExistMobile(String mobile);
	
	//根据手机号码发送验证码
	public void sendIndentifyingCode(String mobile);
}
