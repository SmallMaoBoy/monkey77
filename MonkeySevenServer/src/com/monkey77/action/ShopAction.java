package com.monkey77.action;

import java.util.Map;

import com.monkey77.service.IShopService;
import com.opensymphony.xwork2.Action;


public class ShopAction {
	int indexPage ;
    private Map<String, Object> map;
    private IShopService shopService;
    private int id;
    private String name;
    private String description;
    private float lat;
    private float lng;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getLat() {
		return lat;
	}
	public void setLat(float lat) {
		this.lat = lat;
	}
	public float getLng() {
		return lng;
	}
	public void setLng(float lng) {
		this.lng = lng;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIndexPage() {
		return indexPage;
	}
	public void setIndexPage(int indexPage) {
		this.indexPage = indexPage;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	

	public IShopService getShopService() {
		return shopService;
	}
	public void setShopService(IShopService shopService) {
		this.shopService = shopService;
	}
	public String getShopList(){
		map=shopService.getShopList(indexPage);
		return Action.SUCCESS;
	}
	public String getShopById(){
		map=shopService.getShopById(id);
		return Action.SUCCESS;
	}
	public String deceteShopById(){
	     shopService.deleteShopById(id);
	     return Action.SUCCESS;
	}
	public String createShop(){
		shopService.createShop(name,description,lat,lng);
		return Action.SUCCESS;
	}
	
	}
	

