package com.monkey77.test.Service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.monkey77.service.GoodServiceImp;
import com.monkey77.service.IGoodService;
import com.monkey77.service.IUserService;
import com.monkey77.service.UserServiceImp;

public class TestGoodService {

	private IGoodService goodService;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		goodService=(GoodServiceImp)ac.getBean("GoodService");
	}
	
	@Test
	public void testGetDafalutGoods(){
		System.out.println(goodService.getDefalutList(1,2));
	}
}
