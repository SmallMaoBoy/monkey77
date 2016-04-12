/**
 * @date:创建时间：2016-1-11上午12:06:17
 * @author:mao
 * 
 */
package com.monkey77.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.monkey77.entities.TCart;
import com.monkey77.entities.TOrderDetail;
import com.monkey77.jsonobj.Good;

/**
 * @author mao
 * @time 创建时间 2016-1-11上午12:06:17
 * 
 */
public class TOrderDetailDaoImp extends HibernateDaoSupport implements ITOrderDetailDao{

	/**
	 * @author mao
	 * @date 创建时间：2016-1-11上午12:06:39
	 * @see com.monkey77.dao.ITOrderDetailDao#getOrderDetail(int)
	 */
	@Override
	public List<TOrderDetail> getOrderDetail(int orderId) {
		// TODO Auto-generated method stub
		HibernateTemplate ht=this.getHibernateTemplate();
		DetachedCriteria criteria=DetachedCriteria.forClass(TOrderDetail.class);
		criteria.createAlias("TOrder", "t");
		criteria.add(Restrictions.eq("t.id",orderId));
		return ht.findByCriteria(criteria);
	}

	/**
	 * @author mao
	 * @date 创建时间：2016-1-11上午12:25:40
	 * @see com.monkey77.dao.ITOrderDetailDao#getGoodsByOrderId(int)
	 */
	@Override
	public List<Good> getGoodsByOrderId(int orderId) {
		// TODO Auto-generated method stub
		HibernateTemplate ht=this.getHibernateTemplate();
		DetachedCriteria criteria=DetachedCriteria.forClass(TOrderDetail.class);
		criteria.createAlias("TOrder", "t");
		criteria.add(Restrictions.eq("t.id",orderId));
		List<TOrderDetail> list=ht.findByCriteria(criteria);
		List<Good> goods=new ArrayList<Good>();
		for(TOrderDetail t:list){
			Good g=new Good();
			g.setId(t.getTGood().getId());
			g.setNum(t.getGoodNumber());
			g.setPrice(t.getGoodPrice());
			goods.add(g);
		}
		return goods;
	}

	/**
	 * @author mao
	 * @date 创建时间：2016-1-13上午10:36:14
	 * @see com.monkey77.dao.ITOrderDetailDao#getTotalPrice(int)
	 */
	@Override
	public float getTotalPrice(int orderId) {
		// TODO Auto-generated method stub
		HibernateTemplate ht=this.getHibernateTemplate();
		DetachedCriteria criteria=DetachedCriteria.forClass(TOrderDetail.class);
		criteria.createAlias("TOrder", "t");
		criteria.add(Restrictions.eq("t.id",orderId));
		DetachedCriteria  goodCriteria=criteria.createCriteria("TGood");
		List<TOrderDetail> list=ht.findByCriteria(goodCriteria);
		float result=0;
		for(TOrderDetail t:list){
			result+=t.getGoodNumber()*t.getTGood().getPrice();
		}
		result=((float)(Math.round(result*100))/100);
		return result;
	}

}
