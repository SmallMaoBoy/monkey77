package com.monkey77.dao;

import java.util.List;

import com.alex.entity.TBusiness;
import com.alex.entity.TBuyer;
import com.monkey77.entities.TShop;



public interface ITBuyerDao {
	//获取采购员列表
	public List<TBuyer> getBuyerList(int indexPage,int num);
	//获取采购员总数
	public int getBuyerCount();
	//删除采购员
	public void deleteBuyerById(int id);
	//获取店员列表
	public List<TBusiness> getBusinessList(int indexPage,int num);
	//获取店员总数
	public int getBusinessCount();
	//删除店员
	public void deleteBusinessById(int id);
	//增加店员
	public void createBusiness(TBusiness business);
	//增加采购员
	public void createBuyer(TBuyer buyer);
}
