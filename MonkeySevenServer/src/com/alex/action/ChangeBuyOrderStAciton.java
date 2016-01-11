package com.alex.action;

import com.alex.DAO.ChangeBuyOrderStDAO;
import com.opensymphony.xwork2.ActionSupport;



public class ChangeBuyOrderStAciton extends ActionSupport {
	
	private String status;
	private Integer  id;
	private Integer result=0;
	public String execute() throws Exception {
		ChangeBuyOrderStDAO cos=new ChangeBuyOrderStDAO();
		 cos.show(id, status);
		 result=1;
		 return "success12";
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
