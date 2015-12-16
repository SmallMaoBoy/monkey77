package com.monkey77.entities;

import java.util.HashSet;
import java.util.Set;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */

public class TUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private Short sex;
	private String mobile;
	private String account;
	private String password;
	private Set TOrders = new HashSet(0);
	private Set TCarts = new HashSet(0);
	private Set TGoods = new HashSet(0);

	// Constructors

	/** default constructor */
	public TUser() {
	}

	/** minimal constructor */
	public TUser(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public TUser(Integer id, Short sex, String mobile, String account,
			String password, Set TOrders, Set TCarts, Set TGoods) {
		this.id = id;
		this.sex = sex;
		this.mobile = mobile;
		this.account = account;
		this.password = password;
		this.TOrders = TOrders;
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

	public Set getTOrders() {
		return this.TOrders;
	}

	public void setTOrders(Set TOrders) {
		this.TOrders = TOrders;
	}

	public Set getTCarts() {
		return this.TCarts;
	}

	public void setTCarts(Set TCarts) {
		this.TCarts = TCarts;
	}

	public Set getTGoods() {
		return this.TGoods;
	}

	public void setTGoods(Set TGoods) {
		this.TGoods = TGoods;
	}

}