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
}
