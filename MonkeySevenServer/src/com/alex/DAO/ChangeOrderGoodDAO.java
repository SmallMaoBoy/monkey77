package com.alex.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alex.entity.TBuyorder;
import com.alex.util.Hibernateutil;



public class ChangeOrderGoodDAO {
	private Session session;  
    private Transaction tx;  
      
    public ChangeOrderGoodDAO() {  
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
      
    public TBuyorder show(Integer orderid) {  
//        session.beginTransaction();
    	TBuyorder order=(TBuyorder) session.get(TBuyorder.class, orderid);
        session.flush();
        session.close();
        return order;   
    }  
      
}

