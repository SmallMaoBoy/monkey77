/**
 * @date:创建时间：2016-4-6下午3:25:07
 * @author:mao
 * 
 */
package com.alex.action;

import java.util.List;

import com.monkey77.dao.ITCategoryDao;
import com.monkey77.entities.TCategory;
import com.monkey77.entities.TGood;
import com.monkey77.service.IGoodService;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author mao
 * @time 创建时间 2016-4-6下午3:25:07
 * 
 */
public class CreateGoodAction {

	private ITCategoryDao categoryDao;
	private IGoodService goodService;
	private String edibleMethod;
	private String name;
	private float price;
	private Short number;
	private String originPlace;
	private String specification;
	private String status;
	private String storage;
	private String title;
	private int categoryId;
	
	
	public IGoodService getGoodService() {
		return goodService;
	}


	public void setGoodService(IGoodService goodService) {
		this.goodService = goodService;
	}


	public String getEdibleMethod() {
		return edibleMethod;
	}


	public void setEdibleMethod(String edibleMethod) {
		this.edibleMethod = edibleMethod;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public Short getNumber() {
		return number;
	}


	public void setNumber(Short number) {
		this.number = number;
	}


	public String getOriginPlace() {
		return originPlace;
	}


	public void setOriginPlace(String originPlace) {
		this.originPlace = originPlace;
	}


	public String getSpecification() {
		return specification;
	}


	public void setSpecification(String specification) {
		this.specification = specification;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getStorage() {
		return storage;
	}


	public void setStorage(String storage) {
		this.storage = storage;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public ITCategoryDao getCategoryDao() {
		return categoryDao;
	}


	public void setCategoryDao(ITCategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}


	public String show(){
		 List tg  =categoryDao.getCategoryList();
		 ActionContext.getContext().getSession().put("category",tg);
		return "show";
	}
	
	public String create(){
			TGood good=new TGood(name, price, number, status, specification, originPlace, title, 0);
			TCategory category=new TCategory();
			category.setId(categoryId);
			good.setTCategory(category);
			good.setVersion(0);
			good.setStorage(storage);
			good.setEdibleMethod(edibleMethod);
			int goodId=goodService.createGood(good);
			ActionContext.getContext().getSession().put("goodId",goodId);
			return "createsuccess";
	}
}
