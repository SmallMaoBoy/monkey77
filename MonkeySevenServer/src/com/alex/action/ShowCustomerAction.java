package com.alex.action;

import java.util.List;

import com.alex.DAO.ShowdataCustomerDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowCustomerAction extends ActionSupport {
	
	
	public String execute() throws Exception {
		ShowdataCustomerDAO sdo=new ShowdataCustomerDAO();
		 List ls  =sdo.show();
		 ActionContext.getContext().getSession().put("Customer",ls);
		 return "success";
	}

}
