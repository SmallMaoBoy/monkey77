/**
 * @date:创建时间：2015-12-25上午10:41:11
 * @author:mao
 * 
 */
package com.monkey77.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.monkey77.entities.TCategory;

/**
 * @author mao
 * @time 创建时间 2015-12-25上午10:41:11
 * 
 */
public class TCategoryDaoImp extends HibernateDaoSupport implements ITCategoryDao{

	/**
	 * @author mao
	 * @date 创建时间：2015-12-25上午10:41:34
	 * @see com.monkey77.dao.ITCategoryDao#getCategoryByName(java.lang.String)
	 */
	@Override
	public TCategory getCategoryByName(String name) {
		// TODO Auto-generated method stub
		List<TCategory> list=this.getHibernateTemplate().find("from TCategory t where t.name=?",name);
		return list.isEmpty()?null:list.get(0);
	}

}
