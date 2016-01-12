package com.alex.action;

import java.util.List;

import com.monkey77.dao.ITGoodDao;
import com.opensymphony.xwork2.ActionContext;

public class ShowGoodDataAction  {
private ITGoodDao itGoodDao;
private int id;
private int firstIndex;
private int num;


public String execute() throws Exception {
	
	 List tg  =itGoodDao.getGoodsByPriceAsc(firstIndex*num, num);
	 ActionContext.getContext().getSession().put("Gooddata",tg);
	 return "success";
}



public int getId() {
	return id;
}



public int getFirstIndex() {
	return firstIndex;
}



public void setFirstIndex(int firstIndex) {
	this.firstIndex = firstIndex;
}



public int getNum() {
	return num;
}



public void setNum(int num) {
	this.num = num;
}



public void setId(int id) {
	this.id = id;
}



public ITGoodDao getItGoodDao() {
	return itGoodDao;
}

public void setItGoodDao(ITGoodDao itGoodDao) {
	this.itGoodDao = itGoodDao;
}


}
