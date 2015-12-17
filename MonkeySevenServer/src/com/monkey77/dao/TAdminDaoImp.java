package com.monkey77.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.monkey77.entities.TAdmin;

public class TAdminDaoImp extends HibernateDaoSupport implements ITAdminDao {

	@Override
	public void saveAdmin(TAdmin admin) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(admin);
	}

}
