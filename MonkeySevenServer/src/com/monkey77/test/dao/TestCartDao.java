package com.monkey77.test.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.monkey77.dao.ITCartDao;
import com.monkey77.dao.ITGoodDao;
import com.monkey77.dao.ITUserDao;
import com.monkey77.dao.TUserDaoImp;
import com.monkey77.entities.TCart;
import com.monkey77.entities.TUser;

public class TestCartDao {
	private ITUserDao userDao;
	private ITGoodDao goodDao;
	private ITCartDao cartDao;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		userDao=(TUserDaoImp)ac.getBean("UserDao");
		goodDao=(ITGoodDao)ac.getBean("GoodDao");
		cartDao=(ITCartDao)ac.getBean("CartDao");
		//System.out.println("userdao is initing...");
	}
	
	@Test
	public void testSaveUser(){
		TCart cart=new TCart();
		cart.setTGood(goodDao.getGoodById(2));
		cart.setTUser(userDao.getUserById(1));
		cart.setGoodNumber(50);
		cartDao.createCart(cart);
	}
	
	@Test
	public void testGetCartByUserId(){
		System.out.println(cartDao.getCartByUserId(2));
	}
	
	@Test
	public void testAddCart(){
		cartDao.insertCart(2,1, 100);
	}
	
	@Test
	public void testDelCart(){
		cartDao.delCart(1, 1, 50);
	}
	
	@Test
	public void testClearCart(){
		cartDao.clearCart(1);
	}
	
	
	@Test
	public void testAddCartResult(){
		System.out.println(cartDao.delCartWithResult(2, 1, 1));
	}
}
