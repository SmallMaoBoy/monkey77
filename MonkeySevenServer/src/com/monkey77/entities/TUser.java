package com.monkey77.entities;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;


/**
 * TUser entity. @author MyEclipse Persistence Tools
 */

public class TUser  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Short sex;
     private String mobile;
     private String password;
     private String name;
     private Set TOrders = new HashSet(0);
     private Set TCookieValidates = new HashSet(0);
     private Set TCarts = new HashSet(0);
     private Set TGoods = new HashSet(0);


    // Constructors

    /** default constructor */
    public TUser() {
    }

    
    public TUser(Integer id) {
		super();
		this.id = id;
	}


	/** full constructor */
    public TUser(Short sex, String mobile, String password, String name, Set TOrders, Set TCookieValidates, Set TCarts, Set TGoods) {
        this.sex = sex;
        this.mobile = mobile;
        this.password = password;
        this.name = name;
        this.TOrders = TOrders;
        this.TCookieValidates = TCookieValidates;
        this.TCarts = TCarts;
        this.TGoods = TGoods;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Short getSex() {
        return this.sex;
    }
    
    public void setSex(Short sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    @JSON(serialize=false)
    public Set getTOrders() {
        return this.TOrders;
    }
    
    public void setTOrders(Set TOrders) {
        this.TOrders = TOrders;
    }
    @JSON(serialize=false)
    public Set getTCookieValidates() {
        return this.TCookieValidates;
    }
    
    public void setTCookieValidates(Set TCookieValidates) {
        this.TCookieValidates = TCookieValidates;
    }
    @JSON(serialize=false)
    public Set getTCarts() {
        return this.TCarts;
    }
    
    public void setTCarts(Set TCarts) {
        this.TCarts = TCarts;
    }
    @JSON(serialize=false)
    public Set getTGoods() {
        return this.TGoods;
    }
    
    public void setTGoods(Set TGoods) {
        this.TGoods = TGoods;
    }
   








}