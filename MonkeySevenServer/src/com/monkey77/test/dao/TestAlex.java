/**
 * @date:创建时间：2016-4-8下午2:11:50
 * @author:mao
 * 
 */
package com.monkey77.test.dao;

import org.junit.Test;

import com.alex.DAO.ShowbuyOrderDAO;
import com.alex.entity.TBuyorder;

/**
 * @author mao
 * @time 创建时间 2016-4-8下午2:11:50
 * 
 */
public class TestAlex {

	
	@Test
	public void testGetOrder(){
		ShowbuyOrderDAO dao=new ShowbuyOrderDAO();
		TBuyorder order=(TBuyorder) dao.showAll(0, 1).get(0);
		System.out.println(order.getDayprice());
		System.out.println(order.getTDaySale().getTGood().getName());
	}
}
