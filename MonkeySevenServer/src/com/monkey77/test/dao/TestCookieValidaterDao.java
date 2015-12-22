package com.monkey77.test.dao;

import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.monkey77.dao.ITCookieValidateDao;
import com.monkey77.dao.ITUserDao;
import com.monkey77.dao.TCookieValidateDaoImp;
import com.monkey77.dao.TUserDaoImp;
import com.monkey77.entities.TCookieValidate;
import com.monkey77.entities.TUser;

public class TestCookieValidaterDao {
	private ITCookieValidateDao cookieValidateDao;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		cookieValidateDao=(TCookieValidateDaoImp)ac.getBean("CookieValidateDao");
		//System.out.println("userdao is initing...");
	}
	
	@Test
	public void testSaveCookieValidate(){
		TCookieValidate cookieValidate=new TCookieValidate();
		Timestamp time=new Timestamp(System.currentTimeMillis());
		cookieValidate.setCreateTime(time);
		cookieValidate.setSessionId("saohfijaslkfnjkajfklasmflkjsalkfklas");
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		cookieValidate.setTUser(((TUserDaoImp)ac.getBean("UserDao")).getUserById(1));
		cookieValidateDao.saveCookieValidate(cookieValidate);
	}
	
	@Test
	public void testGetCookieValidate(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(cookieValidateDao.getCookieValidate(((TUserDaoImp)ac.getBean("UserDao")).getUserById(1)));
	}
	
}
