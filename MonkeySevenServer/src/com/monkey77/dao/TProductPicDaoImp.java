/**
 * @date:创建时间：2016-1-1下午4:47:17
 * @author:mao
 * 
 */
package com.monkey77.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.monkey77.entities.TGood;
import com.monkey77.entities.TProductPic;

/**
 * @author mao
 * @time 创建时间 2016-1-1下午4:47:17
 * 
 */
public class TProductPicDaoImp extends HibernateDaoSupport implements ITProductPicDao {

	/**
	 * @author mao
	 * @date 创建时间：2016-1-1下午4:47:17
	 * @see com.monkey77.dao.ITProductPicDao#getProductPicByGoodId(int)
	 */
	@Override
	public List<TProductPic> getProductPicByGoodId(int id) {
		// TODO Auto-generated method stub
		HibernateTemplate ht=this.getHibernateTemplate();
		DetachedCriteria criteria=DetachedCriteria.forClass(TProductPic.class);
		criteria.createAlias("TGood", "t");
		criteria.add(Restrictions.eq("t.id",id));
		return ht.findByCriteria(criteria);
	}

}
