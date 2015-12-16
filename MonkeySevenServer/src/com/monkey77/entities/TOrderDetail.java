package com.monkey77.entities;

/**
 * TOrderDetail entity. @author MyEclipse Persistence Tools
 */

public class TOrderDetail implements java.io.Serializable {

	// Fields

	private Integer id;
	private TOrder TOrder;
	private TGood TGood;
	private Integer goodNumber;

	// Constructors

	/** default constructor */
	public TOrderDetail() {
	}

	/** full constructor */
	public TOrderDetail(Integer id, TOrder TOrder, TGood TGood,
			Integer goodNumber) {
		this.id = id;
		this.TOrder = TOrder;
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

	public TOrder getTOrder() {
		return this.TOrder;
	}

	public void setTOrder(TOrder TOrder) {
		this.TOrder = TOrder;
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