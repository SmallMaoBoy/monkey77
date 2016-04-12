package com.alex.action;


import com.alex.DAO.ChangeOrderGoodDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ChangeOrderGoodAction extends ActionSupport {
	
	private String good;
	private Integer  id;
	private Integer result=0;
	public String execute() throws Exception {
		ChangeOrderGoodDAO cos=new ChangeOrderGoodDAO();
		 cos.show(id);
		 result=1;
		 return "success12";
	}
	
	public String getGood() {
		return good;
	}


	public void setGood(String good) {
		this.good = good;
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
