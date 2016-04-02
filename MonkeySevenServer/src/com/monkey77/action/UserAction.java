package com.monkey77.action;

import java.util.Map;


import com.monkey77.service.IUserService;
import com.opensymphony.xwork2.Action;

public class UserAction {
       int indexPage ;
       private Map<String, Object> map;
       private IUserService userService;
	public int getIndexPage() {
		return indexPage;
	}
	public void setIndexPage(int indexPage) {
		this.indexPage = indexPage;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public String getUserList(){
		map=userService.getUserList(indexPage);
		return Action.SUCCESS;
	}
}
