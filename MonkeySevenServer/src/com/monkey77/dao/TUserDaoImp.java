package com.monkey77.dao;

import java.util.List;

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

	/**
	 * @author mao
	 * @date 创建时间：2015-12-20上午9:10:33
	 * @see com.monkey77.dao.ITUserDao#getPasswordByMobile(java.lang.String)
	 */
	@Override
	public String getPasswordByMobile(String mobile) {
		// TODO Auto-generated method stub
		List<TUser> list=this.getHibernateTemplate().find("from TUser t where t.mobile=?", mobile);
		return list.isEmpty()?null:list.get(0).getPassword();
	}

	/**
	 * @author mao
	 * @date 创建时间：2015-12-20上午9:25:13
	 * @see com.monkey77.dao.ITUserDao#getUserByMobile(java.lang.String)
	 */
	@Override
	public TUser getUserByMobile(String mobile) {
		// TODO Auto-generated method stub
		List<TUser> list=this.getHibernateTemplate().find("from TUser t where t.mobile=?", mobile);
		return list.isEmpty()?null:list.get(0);
	}

}
