package com.monkey77.test.Service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.monkey77.service.IUserService;
import com.monkey77.service.UserServiceImp;

public class TestUserService {

	private IUserService userService;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		userService=(UserServiceImp)ac.getBean("UserService");
	}
	
	@Test
	public void testIsExistMobile(){
		System.out.println(userService.isExistMobile("136"));
	}
	
	@Test
	public void testSendSMS(){
		try {
			userService.sendIdentifyingCode("13631315179");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 返回Json数据{statusCode:?}
	 * 0:成功注册
	 * 1：该号码已被注册
	 * 2：该号码没有发送验证码
	 * 3：验证码出错
	 * @author mao
	 * @date 创建时间：2015-12-19下午10:05:39
	 * @see com.monkey77.service.IUserService#register(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Test
	public void testResiter(){
		System.out.println(userService.register("13631315179", "8108", "123456"));
	}
	
	/**
	 * * 返回状态码
	 * 0：账号密码一致
	 * 1：该帐号不存在
	 * 2：密码错误
	 * @author mao
	 * @date 创建时间：2015-12-20上午9:08:17
	 * @see com.monkey77.service.IUserService#loginByPassword(java.lang.String, java.lang.String)
	 */
	@Test
	public void testLoginByPassword(){
		System.out.println(userService.loginByPassword("1363", "1234567"));
	}
}
