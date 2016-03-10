package com.monkey77.test.dao;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.monkey77.dao.ITDaySaleDao;
import com.monkey77.dao.ITMessageDao;
import com.monkey77.entities.TDaySale;
import com.monkey77.entities.TGood;
import com.monkey77.entities.TMessage;
import com.monkey77.entities.TUser;

public class TestMessageDao {
	private ITMessageDao messageDao;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		messageDao=(ITMessageDao)ac.getBean("MessageDao");
		//System.out.println("userdao is initing...");
	}
	
	@Test
	public void testCreateMessage(){
		TMessage m=new TMessage();
		m.setContact("1110");
		m.setContent("hao");
		m.setCreateTime(new Timestamp(System.currentTimeMillis()));
		TUser user=new TUser();
		user.setId(1);
		m.setTUser(user);
		messageDao.createNewMessage(m);
	}
	
	@Test
	public void testGetMessage(){
		System.out.println(messageDao.getMessage(0, 5));
	}
	
	@Test
	public void testGetCount(){
		System.out.println(messageDao.getMessageCount());
	}
}
