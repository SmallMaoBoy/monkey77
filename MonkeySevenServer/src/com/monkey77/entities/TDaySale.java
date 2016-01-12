package com.monkey77.entities;

import java.util.Date;

/**
 * TDaySale entity. @author MyEclipse Persistence Tools
 */

public class TDaySale implements java.io.Serializable {

	// Fields

	private Integer id;
	private TGood TGood;
	private Integer num;
	private Date saleDate;

	// Constructors

	/** default constructor */
	public TDaySale() {
	}

	/** full constructor */
	public TDaySale(TGood TGood, Integer num, Date saleDate) {
		this.TGood = TGood;
		this.num = num;
		this.saleDate = saleDate;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TGood getTGood() {
		return this.TGood;
	}

	public void setTGood(TGood TGood) {
		this.TGood = TGood;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Date getSaleDate() {
		return this.saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

}