package com.monkey77.entities;

import java.sql.Timestamp;


/**
 * TCookieValidate entity. @author MyEclipse Persistence Tools
 */

public class TCookieValidate  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private TUser TUser;
     private String sessionId;
     private Timestamp createTime;


    // Constructors

    /** default constructor */
    public TCookieValidate() {
    }

    
    /** full constructor */
    public TCookieValidate(TUser TUser, String sessionId, Timestamp createTime) {
        this.TUser = TUser;
        this.sessionId = sessionId;
        this.createTime = createTime;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public TUser getTUser() {
        return this.TUser;
    }
    
    public void setTUser(TUser TUser) {
        this.TUser = TUser;
    }

    public String getSessionId() {
        return this.sessionId;
    }
    
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
   








}