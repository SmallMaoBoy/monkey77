/**
 * @date:创建时间：2015-12-25下午3:59:08
 * @author:mao
 * 
 */
package com.monkey77.test.dao;

import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.monkey77.dao.ITCategoryDao;

/**
 * @author mao
 * @time 创建时间 2015-12-25下午3:59:08
 * 
 */
public class TestCategoryDao {

	private ITCategoryDao categoryDao;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		categoryDao=(ITCategoryDao)ac.getBean("CategoryDao");
		//System.out.println("userdao is initing...");
	}
	
	@Test
	public void testGetCategoryList(){
		System.out.println(categoryDao.getCategoryList());
	}
	
	@Test
	public void testGetCategoryByGoodId(){
		System.out.println(categoryDao.getCategoryByGoodId(1));
	}
}
