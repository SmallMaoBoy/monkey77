/**
 * @date:创建时间：2015-12-25下午3:59:08
 * @author:mao
 * 
 */
package com.monkey77.test.dao;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.monkey77.dao.ITProductPicDao;
import com.monkey77.entities.TGood;
import com.monkey77.entities.TProductPic;

/**
 * @author mao
 * @time 创建时间 2015-12-25下午3:59:08
 * 
 */
public class TestProductPicDao {

	private ITProductPicDao productPicDao;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		productPicDao=(ITProductPicDao)ac.getBean("ProductPicDao");
		//System.out.println("userdao is initing...");
	}
	
	@Test
	public void testGetListByGoodId(){
		System.out.println(productPicDao.getProductPicByGoodId(1));
	}
	
	@Test
	public void updateGoodPic(){
		int[] goods={6,7,8,9,10,12};
		for(int i=0;i<goods.length;i++){
			String path="WebRoot/upload/good/"+goods[i];
			File file=new File(path);
			File[] list=file.listFiles();
			TGood g=new TGood(goods[i]);
			for(int j=0;j<4;j++){
				TProductPic t=new TProductPic(g, "upload/good/"+goods[i]+"/"+list[j].getName());
				t.setType((short) 0);
				productPicDao.saveOrUpdatePic(t);
			}
			for(int j=0;j<4;j++){
				TProductPic t=new TProductPic(g, "upload/good/"+goods[i]+"/"+list[j+4].getName());
				t.setType((short) 1);
				productPicDao.saveOrUpdatePic(t);
			}
		}
	}
}
