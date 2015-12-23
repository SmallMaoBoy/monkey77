package com.monkey77.entities;

import java.util.HashSet;
import java.util.Set;


/**
 * TAdmin entity. @author MyEclipse Persistence Tools
 */

public class TAdmin  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String account;
     private String password;
     private Short role;
     private String remarks;
     private Set TShops = new HashSet(0);


    // Constructors

    /** default constructor */
    public TAdmin() {
    }

	/** minimal constructor */
    public TAdmin(String account, String password, Short role) {
        this.account = account;
        this.password = password;
        this.role = role;
    }
    
    /** full constructor */
    public TAdmin(String account, String password, Short role, String remarks, Set TShops) {
        this.account = account;
        this.password = password;
        this.role = role;
        this.remarks = remarks;
        this.TShops = TShops;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return this.account;
    }
    
    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public Short getRole() {
        return this.role;
    }
    
    public void setRole(Short role) {
        this.role = role;
    }

    public String getRemarks() {
        return this.remarks;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Set getTShops() {
        return this.TShops;
    }
    
    public void setTShops(Set TShops) {
        this.TShops = TShops;
    }
   








}