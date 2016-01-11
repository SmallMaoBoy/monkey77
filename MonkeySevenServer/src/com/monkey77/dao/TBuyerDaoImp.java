package com.monkey77.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.alex.entity.TBusiness;
import com.alex.entity.TBuyer;
import com.monkey77.entities.TShop;

public class TBuyerDaoImp extends HibernateDaoSupport implements ITBuyerDao {

	@Override
	public List<TBuyer> getBuyerList(int indexPage, int num) {
		// TODO Auto-generated method stub
		 HibernateTemplate ht=this.getHibernateTemplate();
		  DetachedCriteria criteria=DetachedCriteria.forClass(TBuyer.class);
		  return ht.findByCriteria(criteria,indexPage,num);
	}

	@Override
	public int getBuyerCount() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from TBuyer").size();
	}

	@Override
	public void deleteBuyerById(int id) {
		// TODO Auto-generated method stub
		TBuyer s= (TBuyer) this.getHibernateTemplate().find("from TBuyer t where t.id=?",id).get(0);
		this.getHibernateTemplate().delete(s);
	}

	@Override
	public List<TBusiness> getBusinessList(int indexPage, int num) {
		// TODO Auto-generated method stub
		 HibernateTemplate ht=this.getHibernateTemplate();
		  DetachedCriteria criteria=DetachedCriteria.forClass(TBusiness.class);
		  return ht.findByCriteria(criteria,indexPage,num);
	}

	@Override
	public int getBusinessCount() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from TBusiness").size();
	}

	@Override
	public void deleteBusinessById(int id) {
		// TODO Auto-generated method stub
		TBusiness s= (TBusiness) this.getHibernateTemplate().find("from TBusiness t where t.id=?",id).get(0);
		this.getHibernateTemplate().delete(s);
	}

	@Override
	public void createBusiness(TBusiness business) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(business);
	}

	@Override
	public void createBuyer(TBuyer buyer) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(buyer);
	}

}
