/**
 * @date:创建时间：2016-1-8上午11:46:50
 * @author:mao
 * 
 */
package com.monkey77.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.monkey77.entities.TGood;
import com.monkey77.entities.TShop;
import com.monkey77.entities.TUser;

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

	@Override
	public List<TShop> getShopList(int indexPage, int num) {
		// TODO Auto-generated method stub
		  HibernateTemplate ht=this.getHibernateTemplate();
		  DetachedCriteria criteria=DetachedCriteria.forClass(TShop.class);
		  return ht.findByCriteria(criteria,indexPage,num);
	}

	@Override
	public int getShopCount() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from TShop").size();
	}

	@Override
	public Object getShopById(int id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(TShop.class, id);
	}

	@Override
	public void deleteShopById(int id) {
		// TODO Auto-generated method stub
		TShop s= (TShop) this.getHibernateTemplate().find("from TShop t where t.id=?",id).get(0);
		this.getHibernateTemplate().delete(s);
		
		
	}

	/**
	 * @author mao
	 * @date 创建时间：2016-1-12下午4:49:16
	 * @see com.monkey77.dao.ITShopDao#getShopList()
	 */
	@Override
	public List<TShop> getShopList() {
		// TODO Auto-generated method stub
		 HibernateTemplate ht=this.getHibernateTemplate();
		  DetachedCriteria criteria=DetachedCriteria.forClass(TShop.class);
		  return ht.findByCriteria(criteria);
	}

}
