package com.monkey77.test.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.monkey77.dao.ITCategoryDao;
import com.monkey77.dao.ITGoodDao;
import com.monkey77.dao.TGoodDaoImp;
import com.monkey77.entities.TGood;

public class TestGoodDao {
	private ITGoodDao goodDao;
	private ITCategoryDao categoryDao;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		goodDao=(TGoodDaoImp)ac.getBean("GoodDao");
		categoryDao=(ITCategoryDao) ac.getBean("CategoryDao");
		//System.out.println("userdao is initing...");
	}
	
	@Test
	public void testSaveGood(){
		TGood good=new TGood();
		good.setName("樱桃");
		good.setEdibleMethod("低温烹饪");
		good.setNumber((short)55);
		good.setOriginPlace("中国");
		good.setPrice((float) 15);
		good.setTCategory(categoryDao.getCategoryByName("樱桃"));
		good.setSaleVolume(22);
		good.setSpecification("5斤");
		good.setTitle("好吃的樱桃桃");
		good.setStorage("避光存储");
		good.setStatus("热销");
		good.setPicUrl("imgs/thumb.jpg");
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
		System.out.println(goodDao.getCountWithKeyWords("旧"));
	}
	
	@Test
	public void testGetGoodByid(){
		System.out.println(goodDao.getGoodById(1));
	}
	
}
