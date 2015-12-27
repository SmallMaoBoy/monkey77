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

import com.monkey77.service.IRootService;

/**
 * @author mao
 * @time 创建时间 2015-12-27下午11:47:26
 * 
 */
public class TestRootService {

	private IRootService rootService;
	
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		rootService=(IRootService) ac.getBean("RootService");
	}
	
	@Test
	public void testCheckLogin(){
		System.out.println(rootService.checkRootLogin("111", "1234562"));
	}
	
	@Test
	public void testCreateRoot(){
		rootService.createNewRoot("121", "123456");
	}
}
