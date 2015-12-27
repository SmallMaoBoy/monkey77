/**
 * @date:创建时间：2015-12-26下午11:20:46
 * @author:mao
 * 
 */
package com.monkey77.test.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.monkey77.dao.ITAdminDao;

/**
 * @author mao
 * @time 创建时间 2015-12-26下午11:20:46
 * 
 */
public class TestAdminDao {

	private ITAdminDao adminDao;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		adminDao=(ITAdminDao) ac.getBean("AdminDao");
	}
	
	@Test
	public void testGetPasswordByAccount(){
		System.out.println(adminDao.getPasswordByAccount("1111"));
	}
	@Test
	public void testisRegistered(){
		System.out.println(adminDao.isRegistered("111"));
	}
}
