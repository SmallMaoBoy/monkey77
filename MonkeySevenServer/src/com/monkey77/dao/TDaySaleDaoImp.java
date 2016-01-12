/**
 * @date:创建时间：2016-1-10下午11:46:40
 * @author:mao
 * 
 */
package com.monkey77.dao;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.monkey77.entities.TDaySale;

/**
 * @author mao
 * @time 创建时间 2016-1-10下午11:46:40
 * 
 */
public class TDaySaleDaoImp extends HibernateDaoSupport implements ITDaySaleDao{

	/**
	 * @author mao
	 * @date 创建时间：2016-1-10下午11:47:07
	 * @see com.monkey77.dao.ITDaySaleDao#createDaySale(com.monkey77.entities.TDaySale)
	 */
	@Override
	public void createDaySale(TDaySale daySale) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(daySale);
	}

	/**
	 * @author mao
	 * @date 创建时间：2016-1-11上午12:33:08
	 * @see com.monkey77.dao.ITDaySaleDao#getDaySale(java.util.Date)
	 */
	@Override
	public List<TDaySale> getDaySale(Date date) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from TDaySale t where t.saleDate=?",date);
	}

	/**
	 * @author mao
	 * @date 创建时间：2016-1-11上午1:25:04
	 * @see com.monkey77.dao.ITDaySaleDao#createOrUpdate(com.monkey77.entities.TDaySale)
	 */
	@Override
	public void createOrUpdate(TDaySale daySale) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().saveOrUpdate(daySale);
	}

}
