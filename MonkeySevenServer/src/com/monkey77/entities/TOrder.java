package com.monkey77.entities;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * TOrder entity. @author MyEclipse Persistence Tools
 */

public class TOrder implements java.io.Serializable {

	// Fields

	private Integer id;
	private TShop TShop;
	private String status;
	private Float totalPrice;
	private Timestamp generatedTime;
	private Timestamp payTime;
	private Timestamp takeTime;
	private String remarks;
	private String payWay;
	private String orderNo;
	private Set TUsers = new HashSet(0);
	private Set TOrderDetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public TOrder() {
	}

	/** minimal constructor */
	public TOrder(String status, Float totalPrice) {
		this.status = status;
		this.totalPrice = totalPrice;
	}

	/** full constructor */
	public TOrder(TShop TShop, String status, Float totalPrice,
			Timestamp generatedTime, Timestamp payTime, Timestamp takeTime,
			String remarks, Set TUserOrders, Set TOrderDetails) {
		this.TShop = TShop;
		this.status = status;
		this.totalPrice = totalPrice;
		this.generatedTime = generatedTime;
		this.payTime = payTime;
		this.takeTime = takeTime;
		this.remarks = remarks;
		this.TUsers = TUserOrders;
		this.TOrderDetails = TOrderDetails;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TShop getTShop() {
		return this.TShop;
	}

	public void setTShop(TShop TShop) {
		this.TShop = TShop;
	}

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Float getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Timestamp getGeneratedTime() {
		return this.generatedTime;
	}

	public void setGeneratedTime(Timestamp generatedTime) {
		this.generatedTime = generatedTime;
	}

	public Timestamp getPayTime() {
		return this.payTime;
	}

	public void setPayTime(Timestamp payTime) {
		this.payTime = payTime;
	}

	public Timestamp getTakeTime() {
		return this.takeTime;
	}

	public void setTakeTime(Timestamp takeTime) {
		this.takeTime = takeTime;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	

	public Set getTUsers() {
		return TUsers;
	}

	public void setTUsers(Set tUsers) {
		TUsers = tUsers;
	}

	public Set getTOrderDetails() {
		return this.TOrderDetails;
	}

	public void setTOrderDetails(Set TOrderDetails) {
		this.TOrderDetails = TOrderDetails;
	}

}