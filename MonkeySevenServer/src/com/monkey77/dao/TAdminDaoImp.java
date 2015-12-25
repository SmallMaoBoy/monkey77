package com.monkey77.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.monkey77.entities.TAdmin;

public class TAdminDaoImp extends HibernateDaoSupport implements ITAdminDao {

	@Override
	public void saveAdmin(TAdmin admin) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(admin);
	}

	/**
	 * @author mao
	 * @date 创建时间：2015-12-25下午5:12:21
	 * @see com.monkey77.dao.ITAdminDao#getPasswordByAccount(java.lang.String)
	 */
	@Override
	public String getPasswordByAccount(String account) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @author mao
	 * @date 创建时间：2015-12-25下午5:12:21
	 * @see com.monkey77.dao.ITAdminDao#isRegistered(java.lang.String)
	 */
	@Override
	public boolean isRegistered(String account) {
		// TODO Auto-generated method stub
		return false;
	}

}
