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
import com.monkey77.dao.ITOrderDetailDao;

/**
 * @author mao
 * @time 创建时间 2015-12-26下午11:20:46
 * 
 */
public class TestOrderDetailDao {

	private ITOrderDetailDao orderDetatilDao;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		orderDetatilDao=(ITOrderDetailDao) ac.getBean("OrderDetailDao");
	}
	
	@Test
	public void testGetOrderDetail(){
		System.out.println(orderDetatilDao.getOrderDetail(10).get(0).getTGood().getName());
	}
	
	@Test
	public void testGetGoods(){
		System.out.println(orderDetatilDao.getGoodsByOrderId(10));
	}
	
}
