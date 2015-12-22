package com.monkey77.dao;

import com.monkey77.entities.TSmsIdentifyingCode;


public interface ITSmsIdentifyingCodeDao {

	//保存验证码
	public void saveOrUpdateIdentifyingCode(TSmsIdentifyingCode indetifyingCode);
	
	//获取验证码
	
	public String getIdentifyCode(String mobile);
}
