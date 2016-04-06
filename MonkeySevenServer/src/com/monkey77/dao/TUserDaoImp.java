package com.monkey77.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.monkey77.entities.TGood;
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

	@Override
	public List<TUser> getUserList(int indexPage, int num) {
		// TODO Auto-generated method stub
		  HibernateTemplate ht=this.getHibernateTemplate();
		  DetachedCriteria criteria=DetachedCriteria.forClass(TUser.class);
		  return ht.findByCriteria(criteria,indexPage,num);
		
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from TUser").size();
		
	}

	/**
	 * @author mao
	 * @date 创建时间：2016-4-4下午8:23:33
	 * @see com.monkey77.dao.ITUserDao#updateUserPicUrl(int, java.lang.String)
	 */
	@Override
	public void updateUserPicUrl(int userId, String picUrl) {
		// TODO Auto-generated method stub
		TUser user=this.getHibernateTemplate().get(TUser.class, userId);
		user.setPic(picUrl);
		this.getHibernateTemplate().update(user);
	}

	/**
	 * @author mao
	 * @date 创建时间：2016-4-4下午10:18:38
	 * @see com.monkey77.dao.ITUserDao#updateUser(com.monkey77.entities.TUser)
	 */
	@Override
	public void updateUser(TUser user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(user);
	}
	

}
