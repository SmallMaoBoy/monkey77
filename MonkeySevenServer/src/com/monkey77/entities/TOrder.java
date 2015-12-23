package com.monkey77.entities;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * TOrder entity. @author MyEclipse Persistence Tools
 */

public class TOrder  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private TShop TShop;
     private String status;
     private Float totalPrice;
     private String reamarks;
     private Timestamp generatedTime;
     private Timestamp payTime;
     private Timestamp takeTime;
     private Set TUsers = new HashSet(0);
     private Set TOrderDetails = new HashSet(0);


    // Constructors

    /** default constructor */
    public TOrder() {
    }

	/** minimal constructor */
    public TOrder(String status, Float totalPrice) {
        this.status = status;
        this.totalPrice = totalPrice;
    }
    
    /** full constructor */
    public TOrder(TShop TShop, String status, Float totalPrice, String reamarks, Timestamp generatedTime, Timestamp payTime, Timestamp takeTime, Set TUsers, Set TOrderDetails) {
        this.TShop = TShop;
        this.status = status;
        this.totalPrice = totalPrice;
        this.reamarks = reamarks;
        this.generatedTime = generatedTime;
        this.payTime = payTime;
        this.takeTime = takeTime;
        this.TUsers = TUsers;
        this.TOrderDetails = TOrderDetails;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public TShop getTShop() {
        return this.TShop;
    }
    
    public void setTShop(TShop TShop) {
        this.TShop = TShop;
    }

    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    public Float getTotalPrice() {
        return this.totalPrice;
    }
    
    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getReamarks() {
        return this.reamarks;
    }
    
    public void setReamarks(String reamarks) {
        this.reamarks = reamarks;
    }

    public Timestamp getGeneratedTime() {
        return this.generatedTime;
    }
    
    public void setGeneratedTime(Timestamp generatedTime) {
        this.generatedTime = generatedTime;
    }

    public Timestamp getPayTime() {
        return this.payTime;
    }
    
    public void setPayTime(Timestamp payTime) {
        this.payTime = payTime;
    }

    public Timestamp getTakeTime() {
        return this.takeTime;
    }
    
    public void setTakeTime(Timestamp takeTime) {
        this.takeTime = takeTime;
    }

    public Set getTUsers() {
        return this.TUsers;
    }
    
    public void setTUsers(Set TUsers) {
        this.TUsers = TUsers;
    }

    public Set getTOrderDetails() {
        return this.TOrderDetails;
    }
    
    public void setTOrderDetails(Set TOrderDetails) {
        this.TOrderDetails = TOrderDetails;
    }
   








}