/**
 * @date:创建时间：2015-12-28上午11:02:59
 * @author:mao
 * 
 */
package com.monkey77.service;

import java.util.HashMap;
import java.util.Map;

import com.monkey77.dao.ITCategoryDao;
import com.monkey77.dao.ITKeywordsDao;
import com.monkey77.dao.ITShowPicDao;

/**
 * @author mao
 * @time 创建时间 2015-12-28上午11:02:59
 * 
 */
public class ContextServiceImp implements IContextService {

	/**
	 * @author mao
	 * @date 创建时间：2015-12-28上午11:02:59
	 * @see com.monkey77.service.IContextService#getMainInfo()
	 */
	
	private ITKeywordsDao keywordsDao;
	private ITCategoryDao categoryDao;
	private ITShowPicDao showPicDao;
	private final int keywordsNum=6;
	
	
	public ITShowPicDao getShowPicDao() {
		return showPicDao;
	}


	public void setShowPicDao(ITShowPicDao showPicDao) {
		this.showPicDao = showPicDao;
	}


	public ITKeywordsDao getKeywordsDao() {
		return keywordsDao;
	}


	public void setKeywordsDao(ITKeywordsDao keywordsDao) {
		this.keywordsDao = keywordsDao;
	}


	public ITCategoryDao getCategoryDao() {
		return categoryDao;
	}


	public void setCategoryDao(ITCategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}


	@Override
	public Map<String, Object> getMainInfo() {
		// TODO Auto-generated method stub
		Map<String,Object> json=new HashMap<String,Object>();
		json.put("keywords",keywordsDao.getKeyWordsList(keywordsNum));
		json.put("category", categoryDao.getCategoryList());
		json.put("showpics", showPicDao.getAllTShowPicList());
		return json;
	}

}
