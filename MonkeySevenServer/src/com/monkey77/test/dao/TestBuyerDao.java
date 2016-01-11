package com.monkey77.test.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.monkey77.dao.ITBuyerDao;
import com.monkey77.dao.ITCartDao;
import com.monkey77.dao.ITGoodDao;
import com.monkey77.dao.ITUserDao;
import com.monkey77.dao.TUserDaoImp;
import com.monkey77.entities.TCart;
import com.monkey77.entities.TUser;

public class TestBuyerDao {
	private ITBuyerDao buyerDao;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		buyerDao=(ITBuyerDao)ac.getBean("BuyerDao");
		
		//System.out.println("userdao is initing...");
	}
	
	@Test
	public void testgetBuyerList(){
		System.out.println(buyerDao.getBuyerList(0, 10));
	}
	@Test
	public void testGetBuyerCount(){
		System.out.println(buyerDao.getBuyerCount());
	}
	@Test
	public void testgetBusinessList(){
		System.out.println(buyerDao.getBusinessList(0, 10));
	}
    @Test
    public void testGetBusinessCount(){
		System.out.println(buyerDao.getBusinessCount());
	}
    
    
}
