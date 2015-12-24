/**
 * @date:创建时间：2015-12-23下午4:19:43
 * @author:mao
 * 
 */
package com.monkey77.action;

import java.util.Map;

import com.monkey77.service.IGoodService;
import com.monkey77.service.IUserService;
import com.opensymphony.xwork2.Action;

/**
 * @author mao
 * @time 创建时间 2015-12-23下午4:19:43
 * 
 */
public class GoodAction {

	
	private Map<String, Object> map;
	private int page;
	private int orderType;
	private String sort;
	private IGoodService goodService;
	private String keyWords;
	

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	public IGoodService getGoodService() {
		return goodService;
	}

	public void setGoodService(IGoodService goodService) {
		this.goodService = goodService;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public String getDefalutGoods(){
		map=goodService.getDefalutList(page,orderType);
		return Action.SUCCESS;
	}
	
	public String getSortGoods(){
		map=goodService.getSortList(page, orderType, sort);
		return Action.SUCCESS;
	}
	
	public String getKeyWordsGoods(){
		map=goodService.getKeyWordsList(page, orderType, keyWords);
		return Action.SUCCESS;
	}
	
}
