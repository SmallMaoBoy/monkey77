/**
 * @date:创建时间：2015-12-27下午12:56:22
 * @author:mao
 * 
 */
package com.monkey77.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.monkey77.entities.TRoot;

/**
 * @author mao
 * @time 创建时间 2015-12-27下午12:56:22
 * 
 */
public class TRootDaoImp extends HibernateDaoSupport implements ITRootDao {

	/**
	 * @author mao
	 * @date 创建时间：2015-12-27下午12:56:23
	 * @see com.monkey77.dao.ITRootDao#getPasswordByAccount(java.lang.String)
	 */
	@Override
	public String getPasswordByAccount(String account) {
		// TODO Auto-generated method stub
		List<TRoot> list=this.getHibernateTemplate().find("from TRoot t where t.account=?",account);
		return list.isEmpty()?null:list.get(0).getPassword();
	}

	/**
	 * @author mao
	 * @date 创建时间：2015-12-27下午12:56:23
	 * @see com.monkey77.dao.ITRootDao#createNewRoot(com.monkey77.entities.TRoot)
	 */
	@Override
	public void createNewRoot(TRoot root) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(root);
	}

}
