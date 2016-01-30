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
import com.monkey77.service.IOrderService;
import com.monkey77.service.IRootService;

/**
 * @author mao
 * @time 创建时间 2015-12-27下午11:47:26
 * 
 */
public class TestOrderService {

	private IOrderService orderService;
	
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		orderService=(IOrderService) ac.getBean("OrderService");
	}
	
	@Test
	public void testCreateOrder(){
		orderService.createOrder(2);
	}
	
	@Test
	public void testSubmissionOrder(){
		System.out.println(orderService.submissionOrder(1,1, "加饭", "在线支付", "MK201601110146050001"));
	}
}
