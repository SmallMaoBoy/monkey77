/**
 * @date:创建时间：2016-1-9下午2:33:40
 * @author:mao
 * 
 */
package com.monkey77.test.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.monkey77.dao.ITCartDao;
import com.monkey77.dao.ITGoodDao;
import com.monkey77.dao.ITOrderDao;
import com.monkey77.dao.ITUserDao;
import com.monkey77.dao.TUserDaoImp;
import com.monkey77.entities.TCart;
import com.monkey77.entities.TOrder;
import com.monkey77.utils.OrderUtil;

/**
 * @author mao
 * @time 创建时间 2016-1-9下午2:33:40
 * 
 */
public class TestOrderDao {
	private ITOrderDao orderDao;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		orderDao=(ITOrderDao)ac.getBean("OrderDao");
		//System.out.println("userdao is initing...");
	}
	
	@Test
	public void testSaveOrder(){
		TOrder o=new TOrder();
		o.setOrderNo(OrderUtil.getOrderNo());
		o.setPayWay("货到付款");
		o.setStatus("待完善");
		o.setTotalPrice(21f);
		orderDao.createOrder(o);
	}
	
	@Test
	public void getOrder(){
		System.out.println(orderDao.getOrderById(3).getId());
		System.out.println(orderDao.getOrderByOrderNo("MK201601101613390001").getId());
	}
	
	@Test
	public void testGetOrderListByUserId(){
		System.out.println(orderDao.getOrderListByUserId(4));
	}
}
