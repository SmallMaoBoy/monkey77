package com.alex.action;

import java.util.List;

import com.alex.DAO.ShowdataOrderDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShoworderAction extends ActionSupport {
	
	
	public String execute() throws Exception {
		ShowdataOrderDAO sdo=new ShowdataOrderDAO();
		 List ls  =sdo.show();
		 ActionContext.getContext().getSession().put("Order",ls);
		 return "success";
	}

}
