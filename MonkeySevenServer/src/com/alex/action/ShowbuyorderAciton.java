package com.alex.action;

import java.util.List;

import com.alex.DAO.ShowbuyOrderDAO;
import com.alex.DAO.ShowdataOrderDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowbuyorderAciton extends ActionSupport {
	private int offset=0;
	private int pageSize=10;
	
	public String execute() throws Exception {
		ShowbuyOrderDAO sdo=new ShowbuyOrderDAO();
		 List ls  =sdo.show(offset, pageSize);
		 Long sum=sdo.resum();
		 ActionContext.getContext().getSession().put("Tbuyoder",ls);
		 ActionContext.getContext().getSession().put("sumnumber",sum);
		 return "success";
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	

}
