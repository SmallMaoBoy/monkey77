package com.monkey77.service;

import java.util.Map;

public interface IBuyerService {
	public Map<String, Object> getBuyerList(int indexPage);
	public void deleteBuyerById(int id);
	public Map<String, Object> getBusinessList(int indexPage);
	public void deleteBusinessById(int id);
	public void createBusiness(String account,String sex,String worklocation,String password);
	public void createBuyer(String name,String sex,String worklocation,String password,String account);
}
