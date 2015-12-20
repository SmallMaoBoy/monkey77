/**
 * @date:创建时间：2015-12-20上午9:02:42
 * @author:mao
 * 
 */
package com.monkey77.action;

import java.util.HashMap;
import java.util.Map;

import com.monkey77.service.IUserService;
import com.monkey77.service.UserServiceImp;
import com.opensymphony.xwork2.Action;

/**
 * @author mao
 * @time 创建时间 2015-12-20上午9:02:42
 * 
 */
public class LoginAction {
	private IUserService userService;
	private String password;
	private String mobile;
	private String identifyingCode;
	private Map<String, String> map;
	
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public Map<String, String> getMap() {
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
		map = new HashMap<String, String>();
		map.put("statusCode",userService.loginByPassword(mobile, password));
		return Action.SUCCESS;
	}
}
