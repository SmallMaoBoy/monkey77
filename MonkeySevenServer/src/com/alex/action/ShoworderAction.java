package com.alex.action;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alex.DAO.ShowdataOrderDAO;
import com.monkey77.dao.ITOrderDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShoworderAction extends ActionSupport {
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
		 return "success";
	}
	
	public String getAllData()throws Exception {
		 init();
		 List ls  =orderDao.getOrderList( index, num);
		 ActionContext.getContext().getSession().put("Order",ls);
		 return "success";
	}

}
