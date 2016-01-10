package com.alex.action;

import java.util.List;

import com.alex.DAO.ShowbuyOrderDAO;
import com.alex.DAO.ShowdataOrderDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowbuyorderAciton extends ActionSupport {
	
	
	public String execute() throws Exception {
		ShowbuyOrderDAO sdo=new ShowbuyOrderDAO();
		 List ls  =sdo.show();
		 ActionContext.getContext().getSession().put("Tbuyoder",ls);
		 return "success";
	}

}
