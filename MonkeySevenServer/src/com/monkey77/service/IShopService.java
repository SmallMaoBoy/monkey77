package com.monkey77.service;

import java.util.Map;

public interface IShopService {
           //获取商店列表
	public Map<String, Object> getShopList(int indexPage);

	public Map<String, Object> getShopById(int id);
	public void deleteShopById(int id);
	public void createShop(String name,String description,float lat,float lng);
}
