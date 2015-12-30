package com.monkey77.action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.monkey77.service.IRootService;
import com.opensymphony.xwork2.ActionSupport;

public class HoutaiLoginAction extends ActionSupport {
	private Map<String, Object> map;
	private String password;
	private String username;
	private IRootService RootService;
	
	
	public Map<String, Object> getMap() {
		return map;
	}


	public void setMap(Map<String, Object> map) {
		this.map = map;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public IRootService getRootService() {
		return RootService;
	}


	public void setRootService(IRootService rootService) {
		RootService = rootService;
	}


	public String execute(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		map=RootService.checkRootLogin(username, password,session);
		return SUCCESS;
	}
}
