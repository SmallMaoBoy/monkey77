package com.alex.entity;

/**
 * TBuyer entity. @author MyEclipse Persistence Tools
 */

public class TBuyer implements java.io.Serializable {

	// Fields

	private Integer id;
	private String account;
	private String password;
	private String name;
	private String sex;
	private String worklocation;

	// Constructors

	/** default constructor */
	public TBuyer() {
	}

	/** full constructor */
	public TBuyer(String account, String password, String name, String sex,
			String worklocation) {
		this.account = account;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.worklocation = worklocation;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getWorklocation() {
		return this.worklocation;
	}

	public void setWorklocation(String worklocation) {
		this.worklocation = worklocation;
	}

}