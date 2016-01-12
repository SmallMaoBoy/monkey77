package com.alex.entity;



/**
 * TBusiness entity. @author MyEclipse Persistence Tools
 */

public class TBusiness  implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 7001723875424629651L;
	private Integer id;
     private String account;
     private String password;


    // Constructors

    /** default constructor */
    public TBusiness() {
    }

    
    /** full constructor */
    public TBusiness(String account, String password) {
        this.account = account;
        this.password = password;
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
   








}