/**
 * @date:创建时间：2016-1-2下午2:58:45
 * @author:mao
 * 
 */
package com.monkey77.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.monkey77.entities.TCart;
import com.monkey77.entities.TGood;
import com.monkey77.entities.TOrderDetail;
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
			JsonCart cart=new JsonCart(list.get(i).getTGood().getName(), list.get(i).getGoodNumber());
			cart.setPicUrl(list.get(i).getTGood().getPicUrl());
			cart.setPrice(list.get(i).getTGood().getPrice());
			cart.setSpecification(list.get(i).getTGood().getSpecification());
			cart.setGoodId(list.get(i).getTGood().getId());
			cart.setTotalPrice((float)(Math.round(list.get(i).getGoodNumber()*list.get(i).getTGood().getPrice()*100))/100);
			result.add(cart);
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

	/**
	 * @author mao
<<<<<<< HEAD
	 * @date 创建时间：2016-1-7上午10:52:44
	 * @see com.monkey77.dao.ITCartDao#insertCartWithResult(int, int, int)
	 */
	@Override
	public List<JsonCart> insertCartWithResult(int userId, int goodId, int num) {
		HibernateTemplate ht=this.getHibernateTemplate();
		DetachedCriteria cartCriteria=DetachedCriteria.forClass(TCart.class);
		cartCriteria.createAlias("TUser", "t");
		cartCriteria.add(Restrictions.eq("t.id",userId));
		DetachedCriteria  goodCriteria=cartCriteria.createCriteria("TGood");
		List<TCart> list=ht.findByCriteria(goodCriteria);
		for(TCart t:list){
			if(t.getTGood().getId().equals(goodId)){
				t.setGoodNumber(t.getGoodNumber()+num);
				ht.saveOrUpdate(t);
			}
			
		}
		List<JsonCart> result=new ArrayList<JsonCart>();
		for(int i=0;i<list.size();i++){
			JsonCart cart=new JsonCart(list.get(i).getTGood().getName(), list.get(i).getGoodNumber());
			cart.setPicUrl(list.get(i).getTGood().getPicUrl());
			cart.setPrice(list.get(i).getTGood().getPrice());
			cart.setSpecification(list.get(i).getTGood().getSpecification());
			cart.setGoodId(list.get(i).getTGood().getId());
			cart.setTotalPrice((float)(Math.round(list.get(i).getGoodNumber()*list.get(i).getTGood().getPrice()*100))/100);
			result.add(cart);
		}
		return result;
	}

	@Override
	public List<JsonCart> getCartByMobile(String mobile) {

		// TODO Auto-generated method stub
		HibernateTemplate ht=this.getHibernateTemplate();
		DetachedCriteria cartCriteria=DetachedCriteria.forClass(TCart.class);
		cartCriteria.createAlias("TUser", "t");
		cartCriteria.add(Restrictions.eq("t.mobile",mobile));
		DetachedCriteria  goodCriteria=cartCriteria.createCriteria("TGood");
		List<TCart> list=ht.findByCriteria(goodCriteria);
		List<JsonCart> result=new ArrayList<JsonCart>();
		for(int i=0;i<list.size();i++){
			JsonCart cart=new JsonCart(list.get(i).getTGood().getName(), list.get(i).getGoodNumber());
			cart.setPicUrl(list.get(i).getTGood().getPicUrl());
			cart.setPrice(list.get(i).getTGood().getPrice());
			cart.setSpecification(list.get(i).getTGood().getSpecification());
			cart.setGoodId(list.get(i).getTGood().getId());
			cart.setTotalPrice((float)(Math.round(list.get(i).getGoodNumber()*list.get(i).getTGood().getPrice()*100))/100);
			result.add(cart);
		}
		return result;
	}

	/**
	 * @author mao
	 * @date 创建时间：2016-1-7上午10:52:44
	 * @see com.monkey77.dao.ITCartDao#delCartWithResult(int, int, int)
	 */
	@Override
	public List<JsonCart> delCartWithResult(int userId, int goodId, int num) {
		// TODO Auto-generated method stub
		HibernateTemplate ht=this.getHibernateTemplate();
		DetachedCriteria cartCriteria=DetachedCriteria.forClass(TCart.class);
		cartCriteria.createAlias("TUser", "t");
		cartCriteria.add(Restrictions.eq("t.id",userId));
		DetachedCriteria  goodCriteria=cartCriteria.createCriteria("TGood");
		List<TCart> list=ht.findByCriteria(goodCriteria);
		for(TCart t:list){
			if(t.getTGood().getId().equals(goodId)){
				t.setGoodNumber(t.getGoodNumber()-num);
				ht.saveOrUpdate(t);
			}
			
		}
		
		List<JsonCart> result=new ArrayList<JsonCart>();
		for(int i=0;i<list.size();i++){
			JsonCart cart=new JsonCart(list.get(i).getTGood().getName(), list.get(i).getGoodNumber());
			cart.setPicUrl(list.get(i).getTGood().getPicUrl());
			cart.setPrice(list.get(i).getTGood().getPrice());
			cart.setSpecification(list.get(i).getTGood().getSpecification());
			cart.setGoodId(list.get(i).getTGood().getId()); 
			cart.setTotalPrice((float)(Math.round(list.get(i).getGoodNumber()*list.get(i).getTGood().getPrice()*100))/100);
			result.add(cart);
		}
		return result;
	}

	/**
	 * @author mao
	 * @date 创建时间：2016-1-7下午10:35:37
	 * @see com.monkey77.dao.ITCartDao#delCartWithResult(int, int)
	 */
	@Override
	public List<JsonCart> delCartWithResult(int userId, int goodId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @author mao
	 * @date 创建时间：2016-1-10下午4:36:35
	 * @see com.monkey77.dao.ITCartDao#getOrderDetil(int)
	 */
	@Override
	public Set<TOrderDetail> getOrderDetil(int userId) {
		// TODO Auto-generated method stub
		HibernateTemplate ht=this.getHibernateTemplate();
		DetachedCriteria cartCriteria=DetachedCriteria.forClass(TCart.class);
		cartCriteria.createAlias("TUser", "t");
		cartCriteria.add(Restrictions.eq("t.id",userId));
		DetachedCriteria  goodCriteria=cartCriteria.createCriteria("TGood");
		List<TCart> list=ht.findByCriteria(goodCriteria);
		Set<TOrderDetail> result=new HashSet<TOrderDetail>();
		for(int i=0;i<list.size();i++){
			TOrderDetail t=new TOrderDetail();
			t.setTGood(list.get(i).getTGood());
			t.setGoodNumber(list.get(i).getGoodNumber());
			t.setGoodPrice(list.get(i).getTGood().getPrice());
			result.add(t);
		}
		return result;
	}

	/**
	 * @author mao
	 * @date 创建时间：2016-3-23下午2:18:48
	 * @see com.monkey77.dao.ITCartDao#updateCartByMobile(java.util.List, int)
	 */
	@Override
	public void updateCartByMobile(List<JsonCart> list, int userId) {
		// TODO Auto-generated method stub
		HibernateTemplate ht=this.getHibernateTemplate();
		DetachedCriteria cartCriteria=DetachedCriteria.forClass(TCart.class);
		cartCriteria.createAlias("TUser", "u");
		cartCriteria.add(Restrictions.eq("u.id",userId));
		List<TCart> oldData=(List<TCart>)ht.findByCriteria(cartCriteria);
		ht.deleteAll(oldData);
		List<JsonCart> newData=list;
		List<TCart> cartList=new ArrayList<TCart>();
		TUser user=new TUser(userId);
		for(JsonCart jc:newData){
			TCart t=new TCart();
			t.setTUser(user);
			t.setTGood(new TGood(jc.getGoodId()));
			t.setGoodNumber(jc.getNum());
			cartList.add(t);
		}
		ht.saveOrUpdateAll(cartList);
	}


}
