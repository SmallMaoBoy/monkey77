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
import com.monkey77.dao.ITCategoryDao;
import com.monkey77.dao.ITGoodDao;
import com.monkey77.dao.ITKeywordsDao;
import com.monkey77.dao.ITProductPicDao;
import com.monkey77.entities.TGood;
import com.monkey77.entities.TProductPic;

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
	private final int numPerPage = 12;
	private ITGoodDao goodDao;
	private ITKeywordsDao keywordsDao;
	private ITProductPicDao productPicDao;
	private ITCategoryDao categoryDao;

	
	public ITCategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(ITCategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public ITProductPicDao getProductPicDao() {
		return productPicDao;
	}

	public void setProductPicDao(ITProductPicDao productPicDao) {
		this.productPicDao = productPicDao;
	}

	public ITKeywordsDao getKeywordsDao() {
		return keywordsDao;
	}

	public void setKeywordsDao(ITKeywordsDao keywordsDao) {
		this.keywordsDao = keywordsDao;
	}

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

	/**
	 * @author mao
	 * @date 创建时间：2015-12-24下午9:10:11
	 * @see com.monkey77.service.IGoodService#getSortList(int, int, java.lang.String)
	 *  * orderType
	 * 0代表按照销量从大到小获取商品
	 * 1代表按照销量从小到大获取商品
	 * 2代表按照价格从大到小获取商品
	 * 3代表按照价格从小到大获取商品
	 */
	@Override
	public Map<String, Object> getSortList(int page, int orderType, String sort) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		int count = goodDao.getCountWithSort(sort);
		map.put("count", count);
		int firstIndex = (page - 1) * numPerPage;
		List<TGood> list = null;
		switch (orderType) {
		case 0:
			list = goodDao.getGoodsBySaleVolumeWithSortDesc(firstIndex, numPerPage, sort);
			break;
		case 1:
			list = goodDao.getGoodsBySaleVolumeWithSortAsc(firstIndex, numPerPage, sort);
			break;
		case 2:
			list = goodDao.getGoodsByPriceWithSortDesc(firstIndex, numPerPage, sort);
			break;
		case 3:
			list = goodDao.getGoodsByPriceWithSortAsc(firstIndex, numPerPage, sort);
			break;
		}
		map.put("goods", list);
		return map;
	}

	/**
	 * @author mao
	 * @date 创建时间：2015-12-24下午10:52:07
	 * @see com.monkey77.service.IGoodService#getKeyWordsList(int, int, java.lang.String)
	 */
	@Override
	public Map<String, Object> getKeyWordsList(int page, int orderType,
			String keyWords) {
		// TODO Auto-generated method stub
		keywordsDao.updateKeyWords(keyWords);
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		int count = goodDao.getCountWithKeyWords(keyWords);
		map.put("count", count);
		int firstIndex = (page - 1) * numPerPage;
		List<TGood> list = null;
		switch (orderType) {
		case 0:
			list = goodDao.getGoodsBySaleVolumeWithKeyWordsDesc(firstIndex, numPerPage, keyWords);
			break;
		case 1:
			list = goodDao.getGoodsBySaleVolumeWithKeyWordsAsc(firstIndex, numPerPage, keyWords);
			break;
		case 2:
			list = goodDao.getGoodsByPriceWithKeyWordsDesc(firstIndex, numPerPage, keyWords);
			break;
		case 3:
			list = goodDao.getGoodsByPriceWithKeyWordsAsc(firstIndex, numPerPage, keyWords);
			break;
		}
		map.put("goods", list);
		return map;
	}

	/**
	 * @author mao
	 * @date 创建时间：2016-1-1下午3:12:56
	 * @see com.monkey77.service.IGoodService#getGoodDetailById(int)
	 */
	@Override
	public Map<String, Object> getGoodDetailById(int id) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("good", goodDao.getGoodById(id));
		map.put("productPic",productPicDao.getProductPicByGoodId(id));
		map.put("category", categoryDao.getCategoryByGoodId(id).getName());
		return map;
	}

	/**
	 * @author mao
	 * @date 创建时间：2016-4-6下午4:26:54
	 * @see com.monkey77.service.IGoodService#createGood(com.monkey77.entities.TGood)
	 */
	@Override
	public int createGood(TGood good) {
		// TODO Auto-generated method stub
		return goodDao.saveGood(good);
	}

	/**
	 * @author mao
	 * @date 创建时间：2016-4-6下午5:27:29
	 * @see com.monkey77.service.IGoodService#updateGoodPic(int, java.lang.String)
	 */
	@Override
	public void updateGoodPic(int goodId, String picUrl) {
		// TODO Auto-generated method stub
		TGood good=goodDao.getGoodById(goodId);
		good.setPicUrl(picUrl);
		goodDao.updateGood(good);
	}

	/**
	 * @author mao
	 * @date 创建时间：2016-4-6下午5:59:34
	 * @see com.monkey77.service.IGoodService#addGoodPic(int, java.lang.String, int)
	 */
	@Override
	public void addGoodPic(int goodId, String picUrl, int type) {
		// TODO Auto-generated method stub
		TProductPic productPic=new TProductPic();
		TGood g=new TGood(goodId);
		productPic.setPicUrl(picUrl);
		productPic.setType((short) type);
		productPic.setTGood(g);
		productPicDao.saveOrUpdatePic(productPic);
	}

}
