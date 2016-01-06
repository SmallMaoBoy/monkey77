/**
 * @date:创建时间：2015-12-27下午11:47:26
 * @author:mao
 * 
 */
package com.monkey77.test.Service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.monkey77.service.ICartService;
import com.monkey77.service.IContextService;
import com.monkey77.service.IRootService;

/**
 * @author mao
 * @time 创建时间 2015-12-27下午11:47:26
 * 
 */
public class TestCartService {

	private ICartService cartSevrvice;
	
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		cartSevrvice=(ICartService) ac.getBean("CartService");
	}
	
	@Test
	public void testGetMainInfo(){
		System.out.println(cartSevrvice.getCartByUserId(2));
	}
	
}
