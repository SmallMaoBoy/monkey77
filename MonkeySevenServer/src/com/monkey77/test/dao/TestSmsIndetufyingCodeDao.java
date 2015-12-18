package com.monkey77.test.dao;

import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.monkey77.dao.ITSmsIdentifyingCodeDao;
import com.monkey77.entities.TSmsIdentifyingCode;

public class TestSmsIndetufyingCodeDao {
	
	ITSmsIdentifyingCodeDao smsIdentifyingCodeDao;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		smsIdentifyingCodeDao=(ITSmsIdentifyingCodeDao) ac.getBean("SmsIdentifyingCodeDao");
	}
	
	@Test
	public void testSaveIndentifyingCode(){
		TSmsIdentifyingCode identifyingCode=new TSmsIdentifyingCode();
		identifyingCode.setCreateTime(new Timestamp(System.currentTimeMillis()));
		identifyingCode.setIdentifyingCode("1235665");
		identifyingCode.setMobile("112");
		smsIdentifyingCodeDao.saveOrUpdateIdentifyingCode(identifyingCode);
	}
	
	@Test
	public void testgetIndentifyingCode(){
		System.out.println(smsIdentifyingCodeDao.getIdentifyCode("110"));
	}
}
