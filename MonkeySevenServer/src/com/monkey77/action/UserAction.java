package com.monkey77.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.monkey77.service.IUserService;
import com.opensymphony.xwork2.Action;

public class UserAction {
	private int userId;
	int indexPage;
	private String mobile;
	private String mail;
	private String name;
	private String password;
	private int sex;
	private String birstr;
	private Map<String, Object> map;
	private IUserService userService;
	private String newPassword;
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public int getIndexPage() {
		return indexPage;
	}

	public void setIndexPage(int indexPage) {
		this.indexPage = indexPage;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getBirstr() {
		return birstr;
	}

	public void setBirstr(String birstr) {
		this.birstr = birstr;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public String getUserList() {
		map = userService.getUserList(indexPage);
		return Action.SUCCESS;
	}

	public String getUserInfo() {
		map = userService.getUserInfo(userId);
		return Action.SUCCESS;
	}
	
	public String checkPassword(){
		map=userService.checkPasswordByUserId(userId, password);
		return Action.SUCCESS;
	}

	
	public String updatePasswordByUserId(){
		map=userService.updatePasswordByUserId(userId, password, newPassword);
		return Action.SUCCESS;
	}
	public String updateUserInfo() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");                
		Date date=null;
		try {
			date = sdf.parse(birstr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map = userService.updateUserInfo(userId, mobile, mail, date, sex, name);
		return Action.SUCCESS;
	}
}
