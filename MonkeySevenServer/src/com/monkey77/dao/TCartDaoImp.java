/**
 * @date:创建时间：2016-1-2下午2:58:45
 * @author:mao
 * 
 */
package com.monkey77.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.monkey77.entities.TCart;
import com.monkey77.entities.TGood;
import com.monkey77.entities.TUser;
import com.monkey77.jsonobj.JsonCart;

/**
 * @author mao
 * @time 创建时间 2016-1-2下午2:58:45
 * 
 */
public class TCartDaoImp extends HibernateDaoSupport implements ITCartDao{

	/**
	 * @author mao
	 * @date 创建时间：2016-1-2下午2:59:04
	 * @see com.monkey77.dao.ITCartDao#createCart(com.monkey77.entities.TCart)
	 */
	@Override
	public void createCart(TCart cart) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(cart);
	}

	/**
	 * @author mao
	 * @date 创建时间：2016-1-2下午3:21:39
	 * @see com.monkey77.dao.ITCartDao#getCartByUserId(int)
	 */
	@Override
	public List<JsonCart> getCartByUserId(int id) {
		// TODO Auto-generated method stub
		HibernateTemplate ht=this.getHibernateTemplate();
		DetachedCriteria cartCriteria=DetachedCriteria.forClass(TCart.class);
		cartCriteria.createAlias("TUser", "t");
		cartCriteria.add(Restrictions.eq("t.id",id));
		DetachedCriteria  goodCriteria=cartCriteria.createCriteria("TGood");
		List<TCart> list=ht.findByCriteria(goodCriteria);
		List<JsonCart> result=new ArrayList<JsonCart>();
		for(int i=0;i<list.size();i++){
			result.add(new JsonCart(list.get(i).getTGood().getName(), list.get(i).getGoodNumber()));
		}
		return result;
	}

	/**
	 * @author mao
	 * @date 创建时间：2016-1-2下午4:24:42
	 * @see com.monkey77.dao.ITCartDao#insertCart(int, int, int)
	 */
	@Override
	public void insertCart(int userId, int goodId, int num) {
		// TODO Auto-generated method stub
		Map<String, Object> result=new HashMap<String,Object>();
		HibernateTemplate ht=this.getHibernateTemplate();
		DetachedCriteria cartCriteria=DetachedCriteria.forClass(TCart.class);
		cartCriteria.createAlias("TUser", "u");
		cartCriteria.add(Restrictions.eq("u.id",userId));
		cartCriteria.createAlias("TGood", "g");
		cartCriteria.add(Restrictions.eq("g.id",goodId));
		List<TCart> list=(List<TCart>)ht.findByCriteria(cartCriteria);
		TCart cart=null;
		if(list.isEmpty()){
			cart=new TCart(new TUser(userId), new TGood(goodId), num);	
		}else{
			cart=list.get(0);
			cart.setGoodNumber(cart.getGoodNumber()+num);
		}
		ht.saveOrUpdate(cart);
	}

	/**
	 * @author mao
	 * @date 创建时间：2016-1-2下午11:33:01
	 * @see com.monkey77.dao.ITCartDao#delCart(int, int, int)
	 */
	@Override
	public void delCart(int userId, int goodId, int num) {
		// TODO Auto-generated method stub
		Map<String, Object> result=new HashMap<String,Object>();
		HibernateTemplate ht=this.getHibernateTemplate();
		DetachedCriteria cartCriteria=DetachedCriteria.forClass(TCart.class);
		cartCriteria.createAlias("TUser", "u");
		cartCriteria.add(Restrictions.eq("u.id",userId));
		cartCriteria.createAlias("TGood", "g");
		cartCriteria.add(Restrictions.eq("g.id",goodId));
		List<TCart> list=(List<TCart>)ht.findByCriteria(cartCriteria);
		TCart cart=list.get(0);
		cart.setGoodNumber(cart.getGoodNumber()-num);
		ht.update(cart);
	}

	/**
	 * @author mao
	 * @date 创建时间：2016-1-2下午11:33:01
	 * @see com.monkey77.dao.ITCartDao#clearCart(int)
	 */
	@Override
	public void clearCart(int userId) {
		// TODO Auto-generated method stub
		HibernateTemplate ht=this.getHibernateTemplate();
		DetachedCriteria cartCriteria=DetachedCriteria.forClass(TCart.class);
		cartCriteria.createAlias("TUser", "u");
		cartCriteria.add(Restrictions.eq("u.id",userId));
		List<TCart> list=(List<TCart>)ht.findByCriteria(cartCriteria);
		ht.deleteAll(list);
	}

}
