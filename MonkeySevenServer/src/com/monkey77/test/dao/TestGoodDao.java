package com.monkey77.test.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.monkey77.dao.ITGoodDao;
import com.monkey77.dao.TGoodDaoImp;
import com.monkey77.entities.TGood;

public class TestGoodDao {
	private ITGoodDao goodDao;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		goodDao=(TGoodDaoImp)ac.getBean("GoodDao");
		//System.out.println("userdao is initing...");
	}
	
	@Test
	public void testSaveGood(){
		TGood good=new TGood();
		good.setName("苹果");
		good.setEdibleMethod("大火爆炒");
		good.setNumber((short) 1000);
		good.setOriginPlace("富士山");
		good.setPrice((float) 3.5);
		good.setSaleVolume(101);
		good.setSpecification("1个");
		good.setTitle("巨水润、巨遮瑕苹果");
		good.setStorage("冷藏");
		good.setStatus("热销");
		goodDao.saveGood(good);
	}
	
	@Test
	public void testGetGoodsBySaleVolume(){
		System.out.println(goodDao.getGoodsBySaleVolume());
	}
	
	@Test
	public void testGetGoodCount(){
		System.out.println(goodDao.getTotalCount());
	}
}
