/**
 * @date:创建时间：2015-12-22下午12:01:45
 * @author:mao
 * 
 */
package com.monkey77.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.monkey77.entities.TCookieValidate;
import com.monkey77.entities.TUser;

/**
 * @author mao
 * @time 创建时间 2015-12-22下午12:01:45
 * 
 */
public class TCookieValidateDaoImp extends HibernateDaoSupport implements ITCookieValidateDao{

	/**
	 * @author mao
	 * @date 创建时间：2015-12-22下午12:03:00
	 * @see com.monkey77.dao.ITCookieValidateDao#saveCookieValidate(com.monkey77.entities.TCookieValidate)
	 */
	@Override
	public void saveCookieValidate(TCookieValidate cookieValidate) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(cookieValidate);
	}

	/**
	 * @author mao
	 * @date 创建时间：2015-12-22下午12:37:57
	 * @see com.monkey77.dao.ITCookieValidateDao#getCookieValidate(java.lang.String)
	 */
	@Override
	public TCookieValidate getCookieValidate(TUser user) {
		// TODO Auto-generated method stub
		List<TCookieValidate> list=this.getHibernateTemplate().find("from TCookieValidate t where t.TUser=?",user);
		return list.get(list.size()-1);
	}

}
