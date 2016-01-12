package com.alex.action;


import com.alex.DAO.ChangeGoodPriceDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ChangeGoodPriceAction extends ActionSupport {
	
	private Float price;
	private Integer  id;
	private Integer result=0;
	public String execute() throws Exception {
		ChangeGoodPriceDAO cos=new ChangeGoodPriceDAO();
		 cos.show(id, price);
		 result=1;
		 return "success12";
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getResult() {
		return result;
	}
	public void setResult(Integer result) {
		this.result = result;
	}
}
	
	
