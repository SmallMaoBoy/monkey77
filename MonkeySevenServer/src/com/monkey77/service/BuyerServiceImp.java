package com.monkey77.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.alex.entity.TBusiness;
import com.alex.entity.TBuyer;
import com.monkey77.dao.ITBuyerDao;


public class BuyerServiceImp implements IBuyerService {
       private ITBuyerDao buyerDao;
       public ITBuyerDao getBuyerDao() {
		return buyerDao;
	}
	public void setBuyerDao(ITBuyerDao buyerDao) {
		this.buyerDao = buyerDao;
	}
	private final int num = 12;
	@Override
	public Map<String, Object> getBuyerList(int indexPage) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		int count = buyerDao.getBuyerCount();
		map.put("count", count);
		int page = (indexPage - 1) * num;
		List<TBuyer> list = buyerDao.getBuyerList(page,num);
		map.put("buyer", list);
		return map;
	}
	@Override
	public void deleteBuyerById(int id) {
		// TODO Auto-generated method stub
		 buyerDao.deleteBuyerById(id);
		
	}
	@Override
	public Map<String, Object> getBusinessList(int indexPage) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		int count = buyerDao.getBusinessCount();
		map.put("count", count);
		int page = (indexPage - 1) * num;
		List<TBusiness> list = buyerDao.getBusinessList(page,num);
		map.put("business", list);
		return map;
	}
	@Override
	public void deleteBusinessById(int id) {
		// TODO Auto-generated method stub
		 buyerDao.deleteBusinessById(id);
	}
	@Override
	public void createBusiness(String account, String sex, String worklocation,
			String password) {
		// TODO Auto-generated method stub
		TBusiness business=new TBusiness();
        business.setAccount(account);
        business.setSex(sex);
        business.setWorklocation(worklocation);
        business.setPassword(password);
        buyerDao.createBusiness(business);
        
		
	}
	@Override
	public void createBuyer(String name, String sex, String worklocation,
			String password, String account) {
		// TODO Auto-generated method stub
		TBuyer buyer=new TBuyer();
		buyer.setName(name);
		buyer.setSex(sex);
		buyer.setWorklocation(worklocation);
		buyer.setPassword(password);
		buyer.setAccount(account);
		buyerDao.createBuyer(buyer);
		
	}

}
