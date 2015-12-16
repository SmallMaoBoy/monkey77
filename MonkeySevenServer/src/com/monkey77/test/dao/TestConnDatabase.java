package com.monkey77.test.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.monkey77.dao.ITAdminDao;
import com.monkey77.dao.TAdminDaoImp;
import com.monkey77.entities.TAdmin;

public class TestConnDatabase {
	
	@Test
	public void testConnDataBase(){
		TAdmin admin=new TAdmin();
		admin.setAccount("111");
		admin.setPassword("123456");
		admin.setRole((short)1);
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		ITAdminDao adminDao=(TAdminDaoImp)ac.getBean("ITAdminDao");
		adminDao.saveAdmin(admin);
	}
	
}
