/**
 * @date:创建时间：2015-12-23上午11:21:28
 * @author:mao
 * 
 */
package com.monkey77.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.monkey77.entities.TGood;

/**
 * @author mao
 * @time 创建时间 2015-12-23上午11:21:28
 * 
 */
public class TGoodDaoImp extends HibernateDaoSupport implements ITGoodDao {

	/**
	 * @author mao
	 * @date 创建时间：2015-12-23上午11:21:29
	 * @see com.monkey77.dao.ITGoodDao#saveGood(com.monkey77.entities.TGood)
	 */
	@Override
	public void saveGood(TGood good) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(good);
	}

	/**
	 * @author mao
	 * @date 创建时间：2015-12-23上午11:21:29
	 * @see com.monkey77.dao.ITGoodDao#getGoodsBySaleVolume()
	 */
	@Override
	public List<TGood> getGoodsBySaleVolume() {
		// TODO Auto-generated method stub
		  HibernateTemplate ht=this.getHibernateTemplate();
		  DetachedCriteria criteria=DetachedCriteria.forClass(TGood.class);
		  criteria.addOrder(Order.asc("saleVolume") );
		  return ht.findByCriteria(criteria);
	}

	/**
	 * @author mao
	 * @date 创建时间：2015-12-23下午5:00:26
	 * @see com.monkey77.dao.ITGoodDao#getTotalCount()
	 */
	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		
		return this.getHibernateTemplate().find("from TGood").size();
	}

}
