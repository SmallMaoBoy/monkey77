/**
 * @date:创建时间：2015-12-20上午9:02:42
 * @author:mao
 * 
 */
package com.monkey77.action;

import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.monkey77.service.IUserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author mao
 * @time 创建时间 2015-12-20上午9:02:42
 * 
 */
public class LoginAction extends ActionSupport{
	private IUserService userService;
	private String password;
	private String mobile;
	private String identifyingCode;
	private Map<String, Object> map;
	
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public Map<String, Object> getMap() {
		return map;
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
	public String getIdentifyingCode() {
		return identifyingCode;
	}
	public void setIdentifyingCode(String identifyingCode) {
		this.identifyingCode = identifyingCode;
	}
	/**
	 ** 返回Json数据{statusCode:?}
	 * 0：账号密码一致
	 * 1：该帐号不存在
	 * 2：密码错误
	 * @author mao
	 * @time 创建时间：2015-12-20上午9:31:50
	 * @return 
	 *
	 */
	public String loginByPassword(){
		map=userService.loginByPassword(mobile, password);
		return SUCCESS;
	}
	
	public String loginByPasswordWithCookie(){
		String sessionid=ServletActionContext.getRequest().getSession().getId();
		map=userService.loginByPasswordWithCookie(mobile, password, ServletActionContext.getResponse(),sessionid);
		return SUCCESS;
	}
}
