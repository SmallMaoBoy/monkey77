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
import com.monkey77.service.IDaySaleService;
import com.monkey77.service.IRootService;

/**
 * @author mao
 * @time 创建时间 2015-12-27下午11:47:26
 * 
 */
public class TestDayServiceService {

	private IDaySaleService daySaleService;
	
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		daySaleService=(IDaySaleService) ac.getBean("DaySaleService");
	}
	
	@Test
	public void test(){
		daySaleService.addDaySale(12);
	}
	
	@Test
	public void getDaySale(){
		System.out.println(daySaleService.getDaySale());
	}
	
}
