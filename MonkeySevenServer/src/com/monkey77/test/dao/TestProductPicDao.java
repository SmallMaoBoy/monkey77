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
import com.monkey77.dao.ITProductPicDao;

/**
 * @author mao
 * @time 创建时间 2015-12-25下午3:59:08
 * 
 */
public class TestProductPicDao {

	private ITProductPicDao productPicDao;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		productPicDao=(ITProductPicDao)ac.getBean("ProductPicDao");
		//System.out.println("userdao is initing...");
	}
	
	@Test
	public void testGetListByGoodId(){
		System.out.println(productPicDao.getProductPicByGoodId(1));
	}
}
