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

import com.monkey77.service.IContextService;
import com.monkey77.service.IRootService;
import com.monkey77.service.ISMSService;

/**
 * @author mao
 * @time 创建时间 2015-12-27下午11:47:26
 * 
 */
public class TestSMSService {

	private ISMSService service;
	
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		service=(ISMSService) ac.getBean("SMSService");
	}
	
	@Test
	public void testGetAccountInfo(){
		System.out.println(service.getAccountInfo());
	}
	
}
