/**
 * @date:创建时间：2015-12-25上午10:41:11
 * @author:mao
 * 
 */
package com.monkey77.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.monkey77.entities.TCategory;
import com.monkey77.entities.TProductPic;

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

	/**
	 * @author mao
	 * @date 创建时间：2015-12-25下午3:58:00
	 * @see com.monkey77.dao.ITCategoryDao#getCategoryList()
	 */
	@Override
	public List<TCategory> getCategoryList() {
		// TODO Auto-generated method stub
		List<TCategory> list=this.getHibernateTemplate().find("from TCategory");
		return list.isEmpty()?null:list;
	}

	/**
	 * @author mao
	 * @date 创建时间：2016-1-1下午5:08:27
	 * @see com.monkey77.dao.ITCategoryDao#getCategoryByGoodId(int)
	 */
	@Override
	public TCategory getCategoryByGoodId(int id) {
		// TODO Auto-generated method stub
		HibernateTemplate ht=this.getHibernateTemplate();
		DetachedCriteria criteria=DetachedCriteria.forClass(TCategory.class);
		criteria.createAlias("TGoods", "t");
		criteria.add(Restrictions.eq("t.id",id));
		return (TCategory) ht.findByCriteria(criteria).get(0);
	}

}
