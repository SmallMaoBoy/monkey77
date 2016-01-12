package com.alex.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alex.util.Hibernateutil;
import com.monkey77.entities.TGood;

public class ChangeGoodPriceDAO {
	private Session session;  
    private Transaction tx;  
      
    public ChangeGoodPriceDAO() {  
        session = Hibernateutil.getSession();  
    }  
      
    /*  
     * 显示数据库中order表的内容到网页中 
     * 
     */  
    public void create(TGood good) {  
        try {  
            tx = session.beginTransaction();  
            session.save(good);  
            tx.commit();  
        } catch (HibernateException e) {  
            Hibernateutil.rollback(tx);  
        } finally {  
            Hibernateutil.closeSession();  
        }  
    }  
      
    public void delete(TGood good) {  
        try {  
            tx = session.beginTransaction();  
            session.delete(good);  
            tx.commit();  
        } catch (HibernateException e) {  
            Hibernateutil.rollback(tx);  
        } finally {  
            Hibernateutil.closeSession();  
        }  
    }  
      
    public TGood find(int id) {  
    	TGood good = null;  
        tx = session.beginTransaction();  
        good = (TGood) session.get(TGood.class, id);  
        tx.commit();  
        Hibernateutil.closeSession();  
        return good;      
    }  
      
    public void update(TGood good) {  
        tx = session.beginTransaction();  
        session.update(good);  
        tx.commit();  
        Hibernateutil.closeSession();  
    }  
      
    public TGood show(Integer goodid,Float price) {  
//        session.beginTransaction();
    	TGood good=(TGood) session.get(TGood.class, goodid);
    	good.setPrice(price);
        session.update(good);
        session.flush();
        session.close();
        return good;   
    }  
      
}
