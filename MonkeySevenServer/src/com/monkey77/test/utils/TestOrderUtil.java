/**
 * @date:创建时间：2016-1-9下午2:01:38
 * @author:mao
 * 
 */
package com.monkey77.test.utils;

import org.hibernate.criterion.Order;
import org.junit.Test;

import com.monkey77.utils.OrderUtil;

/**
 * @author mao
 * @time 创建时间 2016-1-9下午2:01:38
 * 
 */
public class TestOrderUtil {
	
	@Test
	public void test(){
		for(int i=0;i<20;i++){
			new MyThread().start();
		}
	}
	
	class MyThread extends Thread{
		/**
		 * @author mao
		 * @date 创建时间：2016-1-9下午2:04:54
		 * @see java.lang.Thread#run()
		 */
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			System.out.println(OrderUtil.getOrderNo()+"       name--->"+this.getName());
		}
	}
}
