package com.monkey77.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.monkey77.service.IUserService;
import com.opensymphony.xwork2.Action;

public class RegisterAction {
	private IUserService userService;
	private Map<String, String> map;
	private String mobile;
	private String password;
	private String identifyingCode;
	
	public String getIdentifyingCode() {
		return identifyingCode;
	}
	public void setIdentifyingCode(String identifyingCode) {
		this.identifyingCode = identifyingCode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	/**
	 * 判断手机是否被注册
	 * 
	 */
	public String isExistMobile() {
		map = new HashMap<String, String>();
		map.put("statusCode", userService.isExistMobile(mobile));
		return Action.SUCCESS;
	}
	
	/**
	 * 发送验证码
	 * @return
	 * @throws Exception
	 */
	public String sendIndentifyingCode() throws Exception{
		userService.sendIdentifyingCode(mobile);
		return Action.SUCCESS;
	}
	
	/**
	 * 
	 * @author mao
	 * @time 创建时间：2015-12-19下午9:57:10
	 *
	 */
	public String register(){
		return null;
	}
	
}
