package com.monkey77.entities;

import java.sql.Timestamp;


/**
 * TSmsIdentifyingCode entity. @author MyEclipse Persistence Tools
 */

public class TSmsIdentifyingCode  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String mobile;
     private String identifyingCode;
     private Timestamp createTime;


    // Constructors

    /** default constructor */
    public TSmsIdentifyingCode() {
    }

    
    /** full constructor */
    public TSmsIdentifyingCode(String mobile, String identifyingCode, Timestamp createTime) {
        this.mobile = mobile;
        this.identifyingCode = identifyingCode;
        this.createTime = createTime;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIdentifyingCode() {
        return this.identifyingCode;
    }
    
    public void setIdentifyingCode(String identifyingCode) {
        this.identifyingCode = identifyingCode;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
   








}