package com.alex.action;


import com.alex.DAO.ChangeGoodNumberDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ChangeGoodNumberAction extends ActionSupport {
	
	private Short number;
	private Integer  id;
	private Integer result=0;
	public String execute() throws Exception {
		ChangeGoodNumberDAO cos=new ChangeGoodNumberDAO();
		 cos.show(id, number);
		 result=1;
		 return "success12";
	}
	
	public Short getNumber() {
		return number;
	}

	public void setNumber(Short number) {
		this.number = number;
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
	
