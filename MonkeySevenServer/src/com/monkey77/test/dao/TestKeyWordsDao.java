/**
 * @date:创建时间：2015-12-25上午11:43:21
 * @author:mao
 * 
 */
package com.monkey77.test.dao;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.monkey77.dao.ITKeywordsDao;

/**
 * @author mao
 * @time 创建时间 2015-12-25上午11:43:21
 * 
 */
public class TestKeyWordsDao {
	private ITKeywordsDao keywordsDao;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		keywordsDao=(ITKeywordsDao)ac.getBean("KeyWordsDao");
		//System.out.println("userdao is initing...");
	}
	
	@Test
	public void testUpdateKeyWords(){
		keywordsDao.updateKeyWords("蜜桃");
	}
	
	@Test
	public void testUpdateKeyWordsMulti(){
		String[] words=new String[]{"苹果","哈密瓜","草莓","泥猴桃","梨子","桃","新西兰","四川","香蕉","西瓜","火龙果"};
		for(String word:words){
			for(int i=0,j=new Random().nextInt(100);i<j;i++){
				keywordsDao.updateKeyWords(word);
			}	
		}
	}
	
	@Test
	public void testGetKeyWordsList(){
		System.out.println(keywordsDao.getKeyWordsList(8));
	}
}
