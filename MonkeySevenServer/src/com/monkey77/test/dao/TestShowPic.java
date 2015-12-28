/**
 * @date:创建时间：2015-12-28下午3:22:59
 * @author:mao
 * 
 */
package com.monkey77.test.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.monkey77.dao.ITShowPicDao;
import com.monkey77.entities.TShowPic;

/**
 * @author mao
 * @time 创建时间 2015-12-28下午3:22:59
 * 
 */
public class TestShowPic {
	
	private ITShowPicDao showPicDao;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		showPicDao=(ITShowPicDao)ac.getBean("ShowPicDao");
		//System.out.println("userdao is initing...");
	}
	
	@Test
	public void testCreateShowPIc(){
		TShowPic pic=new TShowPic();
		pic.setDescription("nothing...");
		pic.setPicUrl("/imgs/1446692884_pic.jpg");
		pic.setType((short) 1);
		showPicDao.createNewPic(pic);
	}
	
	@Test
	public void getList(){
		System.out.println(showPicDao.getAllTShowPicList());
	}
}
