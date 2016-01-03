package com.monkey77.entities;

/**
 * TCart entity. @author MyEclipse Persistence Tools
 */

public class TCart implements java.io.Serializable {

	// Fields

	private Integer id;
	private TUser TUser;
	private TGood TGood;
	private Integer goodNumber;

	// Constructors

	/** default constructor */
	public TCart() {
	}

	/** minimal constructor */
	public TCart(TUser TUser, TGood TGood) {
		this.TUser = TUser;
		this.TGood = TGood;
	}

	/** full constructor */
	public TCart(TUser TUser, TGood TGood, Integer goodNumber) {
		this.TUser = TUser;
		this.TGood = TGood;
		this.goodNumber = goodNumber;
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

	public TGood getTGood() {
		return this.TGood;
	}

	public void setTGood(TGood TGood) {
		this.TGood = TGood;
	}

	public Integer getGoodNumber() {
		return this.goodNumber;
	}

	public void setGoodNumber(Integer goodNumber) {
		this.goodNumber = goodNumber;
	}
	
	
}