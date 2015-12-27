/**
 * @date:创建时间：2015-12-27下午11:28:50
 * @author:mao
 * 
 */
package com.monkey77.test.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.monkey77.dao.ITRootDao;
import com.monkey77.entities.TRoot;
import com.monkey77.utils.MD5;

/**
 * @author mao
 * @time 创建时间 2015-12-27下午11:28:50
 * 
 */
public class TestRootDao {
	
	private ITRootDao rootDao;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		rootDao=(ITRootDao) ac.getBean("RootDao");
	}
	
	@Test
	public void testCreateNewRoot(){
		TRoot root=new TRoot();
		root.setAccount("111");
		root.setPassword(MD5.getMD5("123456"));
		rootDao.createNewRoot(root);
	}
	
	@Test
	public void testGetPasswordByAccount(){
		System.out.println(rootDao.getPasswordByAccount("111"));
	}
}
