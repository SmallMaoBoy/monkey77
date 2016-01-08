package com.alex.action;

import com.alex.DAO.ChangeOrderStDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ChangeOrderStAction extends ActionSupport {
	
	private String status;
	private Integer  id;
	private Integer result=0;
	public String execute() throws Exception {
		ChangeOrderStDAO cos=new ChangeOrderStDAO();
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
