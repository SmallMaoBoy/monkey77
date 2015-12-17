package com.monkey77.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.monkey77.service.IUserService;
import com.opensymphony.xwork2.Action;

public class RegisterAction {
	private IUserService userService;
	private Map<String, String> map;  
	
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
		map = new HashMap<String, String>();
		map.put("statusCode", userService.isExistMobile("136"));
		return Action.SUCCESS;
	}
}
