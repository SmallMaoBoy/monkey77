package com.alex.entity;

import com.monkey77.entities.TDaySale;

/**
 * TBuyorder entity. @author MyEclipse Persistence Tools
 */

public class TBuyorder implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8894498133267118441L;
	private Integer id;
	private TDaySale TDaySale;
	private Float orderprice;
	private Float dayprice;

	// Constructors

	/** default constructor */
	public TBuyorder() {
	}

	/** minimal constructor */
	public TBuyorder(TDaySale TDaySale) {
		this.TDaySale = TDaySale;
	}

	/** full constructor */
	public TBuyorder(TDaySale TDaySale, Float orderprice, Float dayprice) {
		this.TDaySale = TDaySale;
		this.orderprice = orderprice;
		this.dayprice = dayprice;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TDaySale getTDaySale() {
		return this.TDaySale;
	}

	public void setTDaySale(TDaySale TDaySale) {
		this.TDaySale = TDaySale;
	}

	public Float getOrderprice() {
		return orderprice;
	}

	public void setOrderprice(Float orderprice) {
		this.orderprice = orderprice;
	}

	public Float getDayprice() {
		return dayprice;
	}

	public void setDayprice(Float dayprice) {
		this.dayprice = dayprice;
	}


}