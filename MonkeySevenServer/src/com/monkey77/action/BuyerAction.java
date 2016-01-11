package com.monkey77.action;

import java.util.Map;

import com.monkey77.service.IBuyerService;
import com.opensymphony.xwork2.Action;


public class BuyerAction {
	private int indexPage ;
    private Map<String, Object> map;
    private IBuyerService buyerService;
    private int id;
    private String account;
    private String password;
    private String sex;
    private String worklocation;
    private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getWorklocation() {
		return worklocation;
	}
	public void setWorklocation(String worklocation) {
		this.worklocation = worklocation;
	}
	public int getIndexPage() {
		return indexPage;
	}
	public void setIndexPage(int indexPage) {
		this.indexPage = indexPage;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public IBuyerService getBuyerService() {
		return buyerService;
	}
	public void setBuyerService(IBuyerService buyerService) {
		this.buyerService = buyerService;
	}
	public String getBuyerList(){
		map=buyerService.getBuyerList(indexPage);
		return Action.SUCCESS;
	}
	public String deceteBuyerById(){
	    buyerService.deleteBuyerById(id);
	     return Action.SUCCESS;
	}
	public String getBusinessList(){
		map=buyerService.getBusinessList(indexPage);
		return Action.SUCCESS;
	}
	public String deceteBusinessById(){
	    buyerService.deleteBusinessById(id);
	     return Action.SUCCESS;
	}
	public String createBusiness(){
		buyerService.createBusiness(account,sex,worklocation,password);
		return Action.SUCCESS;
	}
	public String createBuyer(){
		buyerService.createBuyer(name,sex,worklocation,password,account);
		return Action.SUCCESS;
	}
}
