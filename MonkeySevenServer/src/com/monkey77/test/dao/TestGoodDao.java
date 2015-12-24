package com.monkey77.test.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.monkey77.dao.ITGoodDao;
import com.monkey77.dao.TGoodDaoImp;
import com.monkey77.entities.TCategory;
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
		good.setPrice((float) 100);
		good.setSaleVolume(101);
		good.setSpecification("1个");
		good.setTitle("巨水润、巨遮瑕苹果");
		good.setStorage("冷藏");
		good.setStatus("热销");
		goodDao.saveGood(good);
	}
	
	@Test
	public void testGetGoodsBySaleVolumeAsc(){
		System.out.println(goodDao.getGoodsBySaleVolumeAsc(0,4));
	}
	
	@Test
	public void testGetGoodsByPriceAsc(){
		System.out.println(goodDao.getGoodsByPriceAsc(0, 5));
	}
	
	@Test
	public void testGetGoodCount(){
		System.out.println(goodDao.getTotalCount());
	}
	
	@Test
	public void testGetGoodsByPriceWithSortDesc(){
		System.out.println(goodDao.getGoodsByPriceWithSortDesc(0, 5, "苹果"));
	}
	
	@Test
	public void testGetCountWithSort(){
		System.out.println(goodDao.getCountWithSort("苹果"));
	}
	
	@Test
	public void testGetCountWithKeyWords(){
		System.out.println(goodDao.getCountWithKeyWords("草莓"));
	}
	
}
