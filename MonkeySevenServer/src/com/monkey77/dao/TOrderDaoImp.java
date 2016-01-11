/**
 * @date:创建时间：2016-1-9下午2:31:22
 * @author:mao
 * 
 */
package com.monkey77.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.monkey77.entities.TOrder;

/**
 * @author mao
 * @time 创建时间 2016-1-9下午2:31:22
 * 
 */
public class TOrderDaoImp extends HibernateDaoSupport implements ITOrderDao{

	/**
	 * @author mao
	 * @date 创建时间：2016-1-9下午2:32:15
	 * @see com.monkey77.dao.ITOrderDao#createOrder(com.monkey77.entities.TOrder)
	 */
	@Override
	public void createOrder(TOrder t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(t);
	}

	/**
	 * @author mao
	 * @date 创建时间：2016-1-10下午5:27:44
	 * @see com.monkey77.dao.ITOrderDao#getOrderById(int)
	 */
	@Override
	public TOrder getOrderById(int id) {
		// TODO Auto-generated method stub
	
		return this.getHibernateTemplate().get(TOrder.class, id);
	}

	/**
	 * @author mao
	 * @date 创建时间：2016-1-10下午5:27:44
	 * @see com.monkey77.dao.ITOrderDao#getOrderByOrderNo(java.lang.String)
	 */
	@Override
	public TOrder getOrderByOrderNo(String orderNo) {
		// TODO Auto-generated method stub
		List<TOrder> list=(List) this.getHibernateTemplate().find("from TOrder t where t.orderNo=?",orderNo);
		return list.isEmpty()?null:list.get(0);
	}

	/**
	 * @author mao
	 * @date 创建时间：2016-1-10下午6:14:26
	 * @see com.monkey77.dao.ITOrderDao#updateOrder(com.monkey77.entities.TOrder)
	 */
	@Override
	public void updateOrder(TOrder t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(t);
	}

}