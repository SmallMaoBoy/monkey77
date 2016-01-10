package com.monkey77.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.monkey77.dao.ITShopDao;
import com.monkey77.entities.TShop;



public class ShopServiceImp implements IShopService {
	private ITShopDao shopDao;
	public ITShopDao getShopDao() {
		return shopDao;
	}
	public void setShopDao(ITShopDao shopDao) {
		this.shopDao = shopDao;
	}
	private final int num = 12;
	@Override
	public Map<String, Object> getShopList(int indexPage) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		int count = shopDao.getShopCount();
		map.put("count", count);
		int page = (indexPage - 1) * num;
		List<TShop> list = shopDao.getShopList(page,num);
		map.put("shops", list);
		return map;
	}
	@Override
	public Map<String, Object> getShopById(int id) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("shop", shopDao.getShopById(id));
		return map;
	}
	@Override
	public void deleteShopById(int id) {
		// TODO Auto-generated method stub
		 shopDao.deleteShopById(id);
		
	}
	@Override
	public void createShop(String name, String description, float lat, float lng) {
		// TODO Auto-generated method stub
		TShop shop=new TShop();
		shop.setName(name);
		shop.setDescription(description);
		shop.setLat(lat);
		shop.setLng(lng);
		shopDao.createShop(shop);
	}

}
