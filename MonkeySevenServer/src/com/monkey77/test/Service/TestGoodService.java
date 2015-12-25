package com.monkey77.test.Service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.monkey77.service.GoodServiceImp;
import com.monkey77.service.IGoodService;
import com.monkey77.service.IUserService;
import com.monkey77.service.UserServiceImp;

public class TestGoodService {

	private IGoodService goodService;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		goodService=(GoodServiceImp)ac.getBean("GoodService");
	}
	
	@Test
	public void testGetDafalutGoods(){
		System.out.println(goodService.getDefalutList(1,2));
	}
	/**
	 * * 0代表按照销量从大到小获取商品
	 * 1代表按照销量从小到大获取商品
	 * 2代表按照价格从大到小获取商品
	 * 3代表按照价格从小到大获取商品
	 * @author mao
	 * @time 创建时间：2015-12-24下午9:29:41
	 * @return 
	 *
	 */
	@Test
	public void testGetSortListGoods(){
		System.out.println(goodService.getSortList(1, 3, "苹果"));
	}
	
	@Test
	public void testGetKeyWordsListGoods(){
		System.out.println(goodService.getKeyWordsList(1, 3, "苹果"));
	}
}
