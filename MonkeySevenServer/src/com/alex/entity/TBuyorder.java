package com.alex.entity;

/**
 * TBuyorder entity. @author MyEclipse Persistence Tools
 */

public class TBuyorder implements java.io.Serializable {

	// Fields

	private Integer id;
	private String good;
	private Integer buyinprice;
	private String status;
	private Integer dayprice;
	private String number;
	private String sum;

	// Constructors

	/** default constructor */
	public TBuyorder() {
	}

	/** full constructor */
	public TBuyorder(String good, Integer buyinprice, String status,
			Integer dayprice, String number, String sum) {
		this.good = good;
		this.buyinprice = buyinprice;
		this.status = status;
		this.dayprice = dayprice;
		this.number = number;
		this.sum = sum;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGood() {
		return this.good;
	}

	public void setGood(String good) {
		this.good = good;
	}

	public Integer getBuyinprice() {
		return this.buyinprice;
	}

	public void setBuyinprice(Integer buyinprice) {
		this.buyinprice = buyinprice;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getDayprice() {
		return this.dayprice;
	}

	public void setDayprice(Integer dayprice) {
		this.dayprice = dayprice;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getSum() {
		return this.sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

}