package com.monkey77.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.monkey77.entities.TUser;

public class TUserDaoImp extends HibernateDaoSupport implements ITUserDao {

	@Override
	public void saveUser(TUser user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(user);
	}

	@Override
	public TUser getUserById(int id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(TUser.class, id);
	}

	@Override
	public boolean isRegistered(String number) {
		// TODO Auto-generated method stub
		return (this.getHibernateTemplate().find("from TUser u where u.mobile =?",number)).isEmpty()?false:true;
	}

}
