/**
 * @date:创建时间：2015-12-23下午4:58:52
 * @author:mao
 * 
 */
package com.monkey77.service;

import java.util.HashMap;
import java.util.Map;

import com.monkey77.dao.ITGoodDao;

/**
 * @author mao
 * @time 创建时间 2015-12-23下午4:58:52
 * 
 */
public class GoodServiceImp implements IGoodService {

	/**
	 * @author mao
	 * @date 创建时间：2015-12-23下午4:58:52
	 * @see com.monkey77.service.IGoodService#getDefalutList(int)
	 */
	
	private ITGoodDao goodDao;
	
	public ITGoodDao getGoodDao() {
		return goodDao;
	}

	public void setGoodDao(ITGoodDao goodDao) {
		this.goodDao = goodDao;
	}

	@Override
	public Map<String, Object> getDefalutList(int page) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<String,Object>();
		int count=goodDao.getTotalCount();
		map.put("count", count);
		
		return map;
	}

}
