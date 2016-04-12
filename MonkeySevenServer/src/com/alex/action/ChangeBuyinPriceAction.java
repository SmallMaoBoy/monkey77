package com.alex.action;


import com.alex.DAO.ChangeBuyinPriceDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ChangeBuyinPriceAction extends ActionSupport {
	
	private Float buyinprice;
	private Integer  id;
	private Integer result=0;
	public String execute() throws Exception {
		ChangeBuyinPriceDAO cos=new ChangeBuyinPriceDAO();
		 cos.show(id, buyinprice);
		 result=1;
		 return "success12";
	}
	
	


	public Float getBuyinprice() {
		return buyinprice;
	}




	public void setBuyinprice(Float buyinprice) {
		this.buyinprice = buyinprice;
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
