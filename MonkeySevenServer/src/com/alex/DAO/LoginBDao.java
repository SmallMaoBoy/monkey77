package com.alex.DAO;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.alex.entity.TBuyer;
import com.alex.util.Hibernateutil;

public class LoginBDao {  
	  
    private Session session;  
    private Transaction tx;  
      
    public LoginBDao() {  
        session = Hibernateutil.getSession();  
    }  
      
    /*  
     * 将User对象插入到数据库中  
     * @param user  
     */  
    public void create(TBuyer user) {  
        try {  
            tx = session.beginTransaction();  
            session.save(user);  
            tx.commit();  
        } catch (HibernateException e) {  
            Hibernateutil.rollback(tx);  
        } finally {  
            Hibernateutil.closeSession();  
        }  
    }  
      
    public void delete(TBuyer user) {  
        try {  
            tx = session.beginTransaction();  
            session.delete(user);  
            tx.commit();  
        } catch (HibernateException e) {  
            Hibernateutil.rollback(tx);  
        } finally {  
            Hibernateutil.closeSession();  
        }  
    }  
      
    public TBuyer find(int id) {  
    	TBuyer user = null;  
        tx = session.beginTransaction();  
        user = (TBuyer) session.get(TBuyer.class, id);  
        tx.commit();  
        Hibernateutil.closeSession();  
        return user;      
    }  
      
    public void update(TBuyer user) {  
        tx = session.beginTransaction();  
        session.update(user);  
        tx.commit();  
        Hibernateutil.closeSession();  
    }  
      
    public boolean check(TBuyer user) {  
        tx = session.beginTransaction();  
        String sql = "from TBuyer u where u.account = ?";  
        Query query=session.createQuery(sql);
        query.setString(0, user.getAccount());
        List list = query.list();
        if(!list.isEmpty()) {  
            Iterator it = list.iterator();  
            while(it.hasNext()) {  
            	TBuyer get = (TBuyer) it.next();  
                System.out.println(get);  
                if(get.getPassword().equals(user.getPassword())) {  
                    Hibernateutil.closeSession();
                    return true;  
                }  
            }  
        }  
        Hibernateutil.closeSession();  
        return false;     
    }  
      
      
}  