package com.alex.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alex.util.Hibernateutil;
import com.monkey77.entities.TOrder;


public class ChangeOrderStDAO {
	private Session session;  
    private Transaction tx;  
      
    public ChangeOrderStDAO() {  
        session = Hibernateutil.getSession();  
    }  
      
    /*  
     * 显示数据库中order表的内容到网页中 
     * 
     */  
    public void create(TOrder order) {  
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
      
    public void delete(TOrder order) {  
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
      
    public TOrder find(int id) {  
    	TOrder order = null;  
        tx = session.beginTransaction();  
        order = (TOrder) session.get(TOrder.class, id);  
        tx.commit();  
        Hibernateutil.closeSession();  
        return order;      
    }  
      
    public void update(TOrder order) {  
        tx = session.beginTransaction();  
        session.update(order);  
        tx.commit();  
        Hibernateutil.closeSession();  
    }  
      
    public TOrder show(Integer orderid,String status) {  
//        session.beginTransaction();
        TOrder order=(TOrder) session.get(TOrder.class, orderid);
        order.setStatus(status);
        session.update(order);
        session.flush();
        session.close();
        return order;   
    }  
      
}
