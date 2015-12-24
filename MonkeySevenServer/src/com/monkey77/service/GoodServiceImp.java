/**
 * @date:创建时间：2015-12-23下午4:58:52
 * @author:mao
 * 
 */
package com.monkey77.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.monkey77.dao.ITGoodDao;
import com.monkey77.entities.TGood;

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
	private final int numPerPage = 9;
	private ITGoodDao goodDao;

	public ITGoodDao getGoodDao() {
		return goodDao;
	}

	public void setGoodDao(ITGoodDao goodDao) {
		this.goodDao = goodDao;
	}

	/**
	 * orderType 0代表按照销量从大到小获取商品 1代表按照销量从小到大获取商品 2代表按照价格从大到小获取商品 3代表按照价格从小到大获取商品
	 */
	@Override
	public Map<String, Object> getDefalutList(int page, int orderType) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		int count = goodDao.getTotalCount();
		map.put("count", count);
		int firstIndex = (page - 1) * numPerPage;
		List<TGood> list = null;
		switch (orderType) {
		case 0:
			list = goodDao.getGoodsBySaleVolumeDesc(firstIndex, numPerPage);
			break;
		case 1:
			list = goodDao.getGoodsBySaleVolumeAsc(firstIndex, numPerPage);
			break;
		case 2:
			list = goodDao.getGoodsByPriceDesc(firstIndex, numPerPage);
			break;
		case 3:
			list = goodDao.getGoodsByPriceAsc(firstIndex, numPerPage);
			break;
		}
		map.put("goods", list);
		return map;
	}

}
