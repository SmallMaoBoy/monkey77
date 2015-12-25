/**
 * @date:创建时间：2015-12-25上午11:33:01
 * @author:mao
 * 
 */
package com.monkey77.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.monkey77.entities.TKeywords;

/**
 * @author mao
 * @time 创建时间 2015-12-25上午11:33:01
 * 
 */
public class TKeywordsDaoImp extends HibernateDaoSupport implements ITKeywordsDao {

	/**
	 * @author mao
	 * @date 创建时间：2015-12-25上午11:33:31
	 * @see com.monkey77.dao.ITKeywordsDao#updateKeyWords(java.lang.String)
	 */
	@Override
	public void updateKeyWords(String keyWords) {
		// TODO Auto-generated method stub
		List<TKeywords> list=this.getHibernateTemplate().find("from TKeywords t where t.name =?",keyWords);
		if(list.isEmpty()){
			TKeywords newKeywords=new TKeywords();
			newKeywords.setCount(1);
			newKeywords.setName(keyWords);
			this.getHibernateTemplate().save(newKeywords);
		}else{
			TKeywords oldKeywords=list.get(0);
			oldKeywords.setCount(oldKeywords.getCount()+1);
			this.getHibernateTemplate().update(oldKeywords);
		}
	}

	/**
	 * @author mao
	 * @date 创建时间：2015-12-25上午11:33:31
	 * @see com.monkey77.dao.ITKeywordsDao#getKeyWordsList(int)
	 */
	@Override
	public List<TKeywords> getKeyWordsList(int num) {
		// TODO Auto-generated method stub
		HibernateTemplate ht=this.getHibernateTemplate();
		  DetachedCriteria criteria=DetachedCriteria.forClass(TKeywords.class);
		  criteria.addOrder(Order.desc("count") );
		  return ht.findByCriteria(criteria,0,num);
	}

}
