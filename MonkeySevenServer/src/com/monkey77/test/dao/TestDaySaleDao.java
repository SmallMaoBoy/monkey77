package com.monkey77.test.dao;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.monkey77.dao.ITDaySaleDao;
import com.monkey77.entities.TDaySale;
import com.monkey77.entities.TGood;

public class TestDaySaleDao {
	private ITDaySaleDao daySaleDao;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		daySaleDao=(ITDaySaleDao)ac.getBean("DaySaleDao");
		//System.out.println("userdao is initing...");
	}
	
	@Test
	public void testSaveDaySale(){
		TDaySale t=new TDaySale();
		t.setNum(2);
		t.setSaleDate(new Date());
		t.setTGood(new TGood(4));
		daySaleDao.createDaySale(t);
	}
	
	@Test
	public void testGetDaySale(){
		Calendar c = Calendar.getInstance();
		// 从一个 Calendar 对象中获取 Date 对象
		c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.SECOND,0);
        c.set(Calendar.MINUTE,0);
		Date d = c.getTime();
		
		System.out.println(d);
		System.out.println(daySaleDao.getDaySale(d).get(0).getTGood().getId());
	}
	
}
