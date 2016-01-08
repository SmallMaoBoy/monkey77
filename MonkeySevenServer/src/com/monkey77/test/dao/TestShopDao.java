package com.monkey77.test.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.monkey77.dao.ITCartDao;
import com.monkey77.dao.ITGoodDao;
import com.monkey77.dao.ITShopDao;
import com.monkey77.dao.TUserDaoImp;
import com.monkey77.entities.TCart;
import com.monkey77.entities.TShop;

public class TestShopDao {
	private ITShopDao shopDao;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		shopDao=(ITShopDao)ac.getBean("ShopDao");
		//System.out.println("userdao is initing...");
	}
	
	@Test
	public void testSaveShop(){
		TShop t=new TShop("北京旗舰店", "天安门正佳广场5层-888层", 112.2568f, 254.514f);
		shopDao.createShop(t);
	}
	
}
