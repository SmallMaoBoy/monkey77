package com.alex.DAO;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.alex.entity.TBuyorder;
import com.alex.util.Hibernateutil;



public class ShowbuyOrderDAO {
	private Session session;  
    private Transaction tx;  
      
    public ShowbuyOrderDAO() {  
        session = Hibernateutil.getSession();  
    }  
      
    /*  
     * 显示数据库中order表的内容到网页中 
     * 
     */  
    public void create(TBuyorder order) {  
        try {  
            tx = session.beginTransaction();  
            session.save(order);  
            tx.commit();  
        } catch (HibernateException e) {  
            Hibernateutil.rollback(tx);  
        } finally {  
            Hibernateutil.closeSession();  
        }  
    }  
      
    public void delete(TBuyorder order) {  
        try {  
            tx = session.beginTransaction();  
            session.delete(order);  
            tx.commit();  
        } catch (HibernateException e) {  
            Hibernateutil.rollback(tx);  
        } finally {  
            Hibernateutil.closeSession();  
        }  
    }  
      
    public TBuyorder find(int id) {  
    	TBuyorder order = null;  
        tx = session.beginTransaction();  
        order = (TBuyorder) session.get(TBuyorder.class, id);  
        tx.commit();  
        Hibernateutil.closeSession();  
        return order;      
    }  
      
    public void update(TBuyorder order) {  
        tx = session.beginTransaction();  
        session.update(order);  
        tx.commit();  
        Hibernateutil.closeSession();  
    }  
      
    public List showToday(int offset,int pageSize) {  
        tx = session.beginTransaction();
        Calendar c = Calendar.getInstance();
		// 从一个 Calendar 对象中获取 Date 对象
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MINUTE, 0);
		Date d = c.getTime();
		Criteria criteria=session.createCriteria(TBuyorder.class);
		criteria.createAlias("TDaySale", "t");
		criteria.add(Restrictions.eq("t.saleDate",d));
        return criteria.list();   
    }
    public List showAll(int offset,int pageSize){
    	tx = session.beginTransaction();
        String sql = "from TBuyorder";  
        Query query=session.createQuery(sql);
        query.setFirstResult(offset*pageSize);
        query.setMaxResults(pageSize);
        List list = query.list();
        return list;   
    }
    public Long resum(){
    	String sql="select count(*) from TBuyorder";
    	Query query=session.createQuery(sql);
    	Long sum=(Long)query.list().get(0);
    	Hibernateutil.closeSession();
    	return sum;
    }
      
}