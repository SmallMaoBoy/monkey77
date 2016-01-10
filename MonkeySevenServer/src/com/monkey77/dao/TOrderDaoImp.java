/**
 * @date:创建时间：2016-1-9下午2:31:22
 * @author:mao
 * 
 */
package com.monkey77.dao;

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

}
