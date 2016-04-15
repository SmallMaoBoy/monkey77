package com.alex.action;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alex.DAO.ShowbuyOrderDAO;
import com.alex.DAO.ShowdataOrderDAO;
import com.monkey77.dao.ITOrderDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowbuyorderAciton extends ActionSupport {
	private int offset=0;
	private int pageSize=10;
	
	public String execute() throws Exception {
		
		 return "success";
	}
	
	private ITOrderDao orderDao;
	private int index;//起始下标
	private int num=10;//每页记录数
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		orderDao=(ITOrderDao)ac.getBean("OrderDao");
		//System.out.println("userdao is initing...");
	}
	
	public String getBuyingData() throws Exception {
		 init();
		 List ls  =orderDao.getOrderListByOrderStatus("待购买",index,num);
		 ActionContext.getContext().getSession().put("Order",ls);
		 return "success123";
	}

	public String showToday(){
		 ShowbuyOrderDAO sdo=new ShowbuyOrderDAO();
		 List ls  =sdo.showToday(offset, pageSize);
		 Long sum=sdo.resum();
		 ActionContext.getContext().getSession().put("Tbuyoder",ls);
		 ActionContext.getContext().getSession().put("sumnumber",sum);
		 return "success";
	}
	public String showAll(){
		 ShowbuyOrderDAO sdo=new ShowbuyOrderDAO();
		 List ls  =sdo.showAll(offset, pageSize);
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
