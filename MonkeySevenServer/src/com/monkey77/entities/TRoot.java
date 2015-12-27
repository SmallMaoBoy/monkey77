package com.monkey77.entities;

/**
 * TRoot entity. @author MyEclipse Persistence Tools
 */

public class TRoot implements java.io.Serializable {

	// Fields

	private Integer id;
	private String account;
	private String password;

	// Constructors

	/** default constructor */
	public TRoot() {
	}

	/** full constructor */
	public TRoot(String account, String password) {
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