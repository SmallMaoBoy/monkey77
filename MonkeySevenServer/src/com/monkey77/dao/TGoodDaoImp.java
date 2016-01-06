/**
 * @date:创建时间：2015-12-23上午11:21:28
 * @author:mao
 * 
 */
package com.monkey77.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.monkey77.entities.TGood;

/**
 * @author mao
 * @time 创建时间 2015-12-23上午11:21:28
 * 
 */
public class TGoodDaoImp extends HibernateDaoSupport implements ITGoodDao {

	/**
	 * @author mao
	 * @date 创建时间：2015-12-23上午11:21:29
	 * @see com.monkey77.dao.ITGoodDao#saveGood(com.monkey77.entities.TGood)
	 */
	@Override
	public void saveGood(TGood good) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(good);
	}

	/**
	 * @author mao
	 * @date 创建时间：2015-12-23上午11:21:29
	 * @see com.monkey77.dao.ITGoodDao#getGoodsBySaleVolume()
	 */
	@Override
	public List<TGood> getGoodsBySaleVolumeAsc(int firstIndex,int num) {
		// TODO Auto-generated method stub
		  HibernateTemplate ht=this.getHibernateTemplate();
		  DetachedCriteria criteria=DetachedCriteria.forClass(TGood.class);
		  criteria.addOrder(Order.asc("saleVolume") );
		  return ht.findByCriteria(criteria,firstIndex,num);
	}

	/**
	 * @author mao
	 * @date 创建时间：2015-12-23下午5:00:26
	 * @see com.monkey77.dao.ITGoodDao#getTotalCount()
	 */
	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		
		return this.getHibernateTemplate().find("from TGood").size();
	}

	/**
	 * @author mao
	 * @date 创建时间：2015-12-24上午10:59:41
	 * @see com.monkey77.dao.ITGoodDao#getGoodsByPriceAsc()
	 */
	@Override
	public List<TGood> getGoodsByPriceAsc(int firstIndex,int num) {
		// TODO Auto-generated method stub
		  HibernateTemplate ht=this.getHibernateTemplate();
		  DetachedCriteria criteria=DetachedCriteria.forClass(TGood.class);
		  criteria.addOrder(Order.asc("price") );
		  return ht.findByCriteria(criteria,firstIndex,num);
	}

	/**
	 * @author mao
	 * @date 创建时间：2015-12-24上午11:07:08
	 * @see com.monkey77.dao.ITGoodDao#getGoodsByPriceDesc(int, int)
	 */
	@Override
	public List<TGood> getGoodsByPriceDesc(int firstIndex, int num) {
		// TODO Auto-generated method stub
		 HibernateTemplate ht=this.getHibernateTemplate();
		  DetachedCriteria criteria=DetachedCriteria.forClass(TGood.class);
		  criteria.addOrder(Order.desc("price"));
		  return ht.findByCriteria(criteria,firstIndex,num);
	}

	/**
	 * @author mao
	 * @date 创建时间：2015-12-24上午11:12:20
	 * @see com.monkey77.dao.ITGoodDao#getGoodsBySaleVolumeDesc(int, int)
	 */
	@Override
	public List<TGood> getGoodsBySaleVolumeDesc(int firstIndex, int num) {
		// TODO Auto-generated method stub
		HibernateTemplate ht=this.getHibernateTemplate();
		DetachedCriteria criteria=DetachedCriteria.forClass(TGood.class);
		criteria.addOrder(Order.desc("saleVolume") );
		return ht.findByCriteria(criteria,firstIndex,num);
	}

	/**
	 * @author mao
	 * @date 创建时间：2015-12-24下午4:29:36
	 * @see com.monkey77.dao.ITGoodDao#getGoodsByPriceWithSortDesc(int, int, java.lang.String)
	 */
	@Override
	public List<TGood> getGoodsByPriceWithSortDesc(int firstIndex, int num,
			String sort) {
		// TODO Auto-generated method stub
		HibernateTemplate ht=this.getHibernateTemplate();
		DetachedCriteria criteria=DetachedCriteria.forClass(TGood.class);
		criteria.addOrder(Order.desc("price"));
		criteria.createAlias("TCategory", "t");
		criteria.add(Restrictions.eq("t.name",sort));
		return ht.findByCriteria(criteria,firstIndex,num);
	}

	/**
	 * @author mao
	 * @date 创建时间：2015-12-24下午5:06:24
	 * @see com.monkey77.dao.ITGoodDao#getGoodsByPriceWithSortAsc(int, int, java.lang.String)
	 */
	@Override
	public List<TGood> getGoodsByPriceWithSortAsc(int firstIndex, int num,
			String sort) {
		// TODO Auto-generated method stub
		HibernateTemplate ht=this.getHibernateTemplate();
		DetachedCriteria criteria=DetachedCriteria.forClass(TGood.class);
		criteria.addOrder(Order.asc("price"));
		criteria.createAlias("TCategory", "t");
		criteria.add(Restrictions.eq("t.name",sort));
		return ht.findByCriteria(criteria,firstIndex,num);
	}

	/**
	 * @author mao
	 * @date 创建时间：2015-12-24下午5:06:24
	 * @see com.monkey77.dao.ITGoodDao#getGoodsBySaleVolumeWithSortAsc(int, int, java.lang.String)
	 */
	@Override
	public List<TGood> getGoodsBySaleVolumeWithSortAsc(int firstIndex, int num,
			String sort) {
		// TODO Auto-generated method stub
		HibernateTemplate ht=this.getHibernateTemplate();
		DetachedCriteria criteria=DetachedCriteria.forClass(TGood.class);
		criteria.addOrder(Order.asc("saleVolume"));
		criteria.createAlias("TCategory", "t");
		criteria.add(Restrictions.eq("t.name",sort));
		return ht.findByCriteria(criteria,firstIndex,num);
	}

	/**
	 * @author mao
	 * @date 创建时间：2015-12-24下午5:06:24
	 * @see com.monkey77.dao.ITGoodDao#getGoodsBySaleVolumeWithSortDesc(int, int, java.lang.String)
	 */
	@Override
	public List<TGood> getGoodsBySaleVolumeWithSortDesc(int firstIndex,
			int num, String sort) {
		// TODO Auto-generated method stub
		HibernateTemplate ht=this.getHibernateTemplate();
		DetachedCriteria criteria=DetachedCriteria.forClass(TGood.class);
		criteria.addOrder(Order.desc("saleVolume"));
		criteria.createAlias("TCategory", "t");
		criteria.add(Restrictions.eq("t.name",sort));
		return ht.findByCriteria(criteria,firstIndex,num);
	}

	/**
	 * @author mao
	 * @date 创建时间：2015-12-24下午9:11:54
	 * @see com.monkey77.dao.ITGoodDao#getCountWithSort(java.lang.String)
	 */
	@Override
	public int getCountWithSort(String sort) {
		// TODO Auto-generated method stub
		HibernateTemplate ht=this.getHibernateTemplate();
		DetachedCriteria criteria=DetachedCriteria.forClass(TGood.class);
		criteria.createAlias("TCategory", "t");
		criteria.add(Restrictions.eq("t.name",sort));
		return ht.findByCriteria(criteria).size();
	}

	/**
	 * @author mao
	 * @date 创建时间：2015-12-24下午10:00:08
	 * @see com.monkey77.dao.ITGoodDao#getCountWithKeyWords(java.lang.String)
	 */
	@Override
	public int getCountWithKeyWords(String keyWords) {
		// TODO Auto-generated method stub
		HibernateTemplate ht=this.getHibernateTemplate();
		DetachedCriteria criteria=DetachedCriteria.forClass(TGood.class);
		criteria.createAlias("TCategory", "t");
		LogicalExpression r1=Restrictions.or(Restrictions.like("name", "%"+keyWords+"%"), Restrictions.like("originPlace", "%"+keyWords+"%"));
		LogicalExpression r2=Restrictions.or(Restrictions.like("t.name", "%"+keyWords+"%"), Restrictions.like("title", "%"+keyWords+"%"));
		criteria.add(Restrictions.or(r1, r2));
		return ht.findByCriteria(criteria).size();
	}

	/**
	 * @author mao
	 * @date 创建时间：2015-12-24下午10:48:01
	 * @see com.monkey77.dao.ITGoodDao#getGoodsByPriceWithKeyWordsDesc(int, int, java.lang.String)
	 */
	@Override
	public List<TGood> getGoodsByPriceWithKeyWordsDesc(int firstIndex, int num,
			String keyWords) {
		// TODO Auto-generated method stub
		HibernateTemplate ht=this.getHibernateTemplate();
		DetachedCriteria criteria=DetachedCriteria.forClass(TGood.class);
		criteria.createAlias("TCategory", "t");
		LogicalExpression r1=Restrictions.or(Restrictions.like("name", "%"+keyWords+"%"), Restrictions.like("originPlace", "%"+keyWords+"%"));
		LogicalExpression r2=Restrictions.or(Restrictions.like("t.name", "%"+keyWords+"%"), Restrictions.like("title", "%"+keyWords+"%"));
		criteria.add(Restrictions.or(r1, r2));
		criteria.addOrder(Order.desc("price"));
		return ht.findByCriteria(criteria);
	}

	/**
	 * @author mao
	 * @date 创建时间：2015-12-24下午10:48:01
	 * @see com.monkey77.dao.ITGoodDao#getGoodsByPriceWithKeyWordsAsc(int, int, java.lang.String)
	 */
	@Override
	public List<TGood> getGoodsByPriceWithKeyWordsAsc(int firstIndex, int num,
			String keyWords) {
		// TODO Auto-generated method stub
		HibernateTemplate ht=this.getHibernateTemplate();
		DetachedCriteria criteria=DetachedCriteria.forClass(TGood.class);
		criteria.createAlias("TCategory", "t");
		LogicalExpression r1=Restrictions.or(Restrictions.like("name", "%"+keyWords+"%"), Restrictions.like("originPlace", "%"+keyWords+"%"));
		LogicalExpression r2=Restrictions.or(Restrictions.like("t.name", "%"+keyWords+"%"), Restrictions.like("title", "%"+keyWords+"%"));
		criteria.add(Restrictions.or(r1, r2));
		criteria.addOrder(Order.asc("price"));
		return ht.findByCriteria(criteria);
	}

	/**
	 * @author mao
	 * @date 创建时间：2015-12-24下午10:48:01
	 * @see com.monkey77.dao.ITGoodDao#getGoodsBySaleVolumeWithKeyWordsAsc(int, int, java.lang.String)
	 */
	@Override
	public List<TGood> getGoodsBySaleVolumeWithKeyWordsAsc(int firstIndex,
			int num, String keyWords) {
		// TODO Auto-generated method stub
		HibernateTemplate ht=this.getHibernateTemplate();
		DetachedCriteria criteria=DetachedCriteria.forClass(TGood.class);
		criteria.createAlias("TCategory", "t");
		LogicalExpression r1=Restrictions.or(Restrictions.like("name", "%"+keyWords+"%"), Restrictions.like("originPlace", "%"+keyWords+"%"));
		LogicalExpression r2=Restrictions.or(Restrictions.like("t.name", "%"+keyWords+"%"), Restrictions.like("title", "%"+keyWords+"%"));
		criteria.add(Restrictions.or(r1, r2));
		criteria.addOrder(Order.asc("saleVolume"));
		return ht.findByCriteria(criteria);
	}

	/**
	 * @author mao
	 * @date 创建时间：2015-12-24下午10:48:01
	 * @see com.monkey77.dao.ITGoodDao#getGoodsBySaleVolumeWithKeyWordsDesc(int, int, java.lang.String)
	 */
	@Override
	public List<TGood> getGoodsBySaleVolumeWithKeyWordsDesc(int firstIndex,
			int num, String keyWords) {
		// TODO Auto-generated method stub
		HibernateTemplate ht=this.getHibernateTemplate();
		DetachedCriteria criteria=DetachedCriteria.forClass(TGood.class);
		criteria.createAlias("TCategory", "t");
		LogicalExpression r1=Restrictions.or(Restrictions.like("name", "%"+keyWords+"%"), Restrictions.like("originPlace", "%"+keyWords+"%"));
		LogicalExpression r2=Restrictions.or(Restrictions.like("t.name", "%"+keyWords+"%"), Restrictions.like("title", "%"+keyWords+"%"));
		criteria.add(Restrictions.or(r1, r2));
		criteria.addOrder(Order.desc("saleVolume"));
		return ht.findByCriteria(criteria);
	}

	/**
	 * @author mao
	 * @date 创建时间：2016-1-1下午3:14:44
	 * @see com.monkey77.dao.ITGoodDao#getGoodById(int)
	 */
	@Override
	public TGood getGoodById(int id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(TGood.class, id);
	}

}
