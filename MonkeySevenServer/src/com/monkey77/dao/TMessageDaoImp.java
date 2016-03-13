/**
 * @date:创建时间：2016-3-10上午12:18:24
 * @author:mao
 * 
 */
package com.monkey77.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.monkey77.entities.TGood;
import com.monkey77.entities.TMessage;
import com.monkey77.entities.TShop;

/**
 * @author mao
 * @time 创建时间 2016-3-10上午12:18:24
 * 
 */
public class TMessageDaoImp extends HibernateDaoSupport implements ITMessageDao{
    
	/**
	 * @author mao
	 * @date 创建时间：2016-3-10上午12:19:06
	 * @see com.monkey77.dao.ITMessageDao#createNewMessage(com.monkey77.entities.TMessage)
	 */
	@Override
	public void createNewMessage(TMessage message) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(message);
	}

	/**
	 * @author mao
	 * @date 创建时间：2016-3-10上午12:19:06
	 * @see com.monkey77.dao.ITMessageDao#getMessage(int, int)
	 */
	@Override
	
	public List<TMessage> getMessage(int indexPage, int num) {
		// TODO Auto-generated method stub
		HibernateTemplate ht=this.getHibernateTemplate();
		  DetachedCriteria criteria=DetachedCriteria.forClass(TMessage.class);
		  return ht.findByCriteria(criteria,indexPage,num);
	}

	/**
	 * @author mao
	 * @date 创建时间：2016-3-10上午12:19:06
	 * @see com.monkey77.dao.ITMessageDao#getMessageCount()
	 */
	@Override
	public int getMessageCount() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from TMessage").size();
	}

	
	

}
