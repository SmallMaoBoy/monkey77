/**
 * @date:创建时间：2016-1-8上午11:46:50
 * @author:mao
 * 
 */
package com.monkey77.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.monkey77.entities.TShop;

/**
 * @author mao
 * @time 创建时间 2016-1-8上午11:46:50
 * 
 */
public class TShopDaoImp extends HibernateDaoSupport implements ITShopDao {

	/**
	 * @author mao
	 * @date 创建时间：2016-1-8上午11:47:15
	 * @see com.monkey77.dao.ITShopDao#createShop(com.monkey77.entities.TShop)
	 */
	@Override
	public void createShop(TShop shop) {
		// TODO Auto-generated method stub
			this.getHibernateTemplate().save(shop);
	}

}
