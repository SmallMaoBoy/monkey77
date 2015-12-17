package com.monkey77.test.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.monkey77.dao.ITUserDao;
import com.monkey77.dao.TUserDaoImp;
import com.monkey77.entities.TUser;

public class TestUserDao {
	private ITUserDao userDao;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		userDao=(TUserDaoImp)ac.getBean("UserDao");
		//System.out.println("userdao is initing...");
	}
	
	@Test
	public void testSaveUser(){
		TUser user=new TUser();
		user.setMobile("136");
		user.setPassword("123456");
		user.setSex((short)1);
		userDao.saveUser(user);
	}
	
	@Test
	public void testGetUserById(){
		System.out.print(userDao.getUserById(1));
	}
	
	@Test
	public void testIsRegistered(){
		System.out.print(userDao.isRegistered("13631315179"));
	}
	
}
