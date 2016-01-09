package com.alex.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alex.util.Hibernateutil;
import com.monkey77.entities.TUser;

public class ShowdataCustomerDAO {
	private Session session;  
    private Transaction tx;  
      
    public ShowdataCustomerDAO() {  
        session = Hibernateutil.getSession();  
    }  
      
    /*  
     * 显示数据库中order表的内容到网页中 
     * 
     */  
    public void create(TUser customer) {  
        try {  
            tx = session.beginTransaction();  
            session.save(customer);  
            tx.commit();  
        } catch (HibernateException e) {  
            Hibernateutil.rollback(tx);  
        } finally {  
            Hibernateutil.closeSession();  
        }  
    }  
      
    public void delete(TUser customer) {  
        try {  
            tx = session.beginTransaction();  
            session.delete(customer);  
            tx.commit();  
        } catch (HibernateException e) {  
            Hibernateutil.rollback(tx);  
        } finally {  
            Hibernateutil.closeSession();  
        }  
    }  
      
    public TUser find(int id) {  
        TUser customer = null;  
        tx = session.beginTransaction();  
        customer = (TUser) session.get(TUser.class, id);  
        tx.commit();  
        Hibernateutil.closeSession();  
        return customer;      
    }  
      
    public void update(TUser order) {  
        tx = session.beginTransaction();  
        session.update(order);  
        tx.commit();  
        Hibernateutil.closeSession();  
    }  
      
    public List show() {  
        tx = session.beginTransaction();  
        String sql = "from TUser";  
        Query query=session.createQuery(sql);
        List list = query.list();
        
        Hibernateutil.closeSession();  
        return list;   
    }  
      
}
