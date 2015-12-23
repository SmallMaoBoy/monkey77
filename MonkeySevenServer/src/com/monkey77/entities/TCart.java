package com.monkey77.entities;



/**
 * TCart entity. @author MyEclipse Persistence Tools
 */

public class TCart  implements java.io.Serializable {


    // Fields    

     private TCartId id;
     private TUser TUser;
     private TGood TGood;


    // Constructors

    /** default constructor */
    public TCart() {
    }

	/** minimal constructor */
    public TCart(TCartId id) {
        this.id = id;
    }
    
    /** full constructor */
    public TCart(TCartId id, TUser TUser, TGood TGood) {
        this.id = id;
        this.TUser = TUser;
        this.TGood = TGood;
    }

   
    // Property accessors

    public TCartId getId() {
        return this.id;
    }
    
    public void setId(TCartId id) {
        this.id = id;
    }

    public TUser getTUser() {
        return this.TUser;
    }
    
    public void setTUser(TUser TUser) {
        this.TUser = TUser;
    }

    public TGood getTGood() {
        return this.TGood;
    }
    
    public void setTGood(TGood TGood) {
        this.TGood = TGood;
    }
   








}