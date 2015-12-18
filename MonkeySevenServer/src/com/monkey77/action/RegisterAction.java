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

	public String isExistMobile() throws IOException{
		System.out.println(mobile);
		map = new HashMap<String, String>();
		map.put("statusCode", userService.isExistMobile(mobile));
		return Action.SUCCESS;
	}
	
	public String sendIndentifyingCode() throws Exception{
		userService.sendIdentifyingCode(mobile);
		return Action.SUCCESS;
	}
	
}
