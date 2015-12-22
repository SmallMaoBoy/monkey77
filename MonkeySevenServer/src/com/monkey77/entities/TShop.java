package com.monkey77.entities;

import java.util.HashSet;
import java.util.Set;

/**
 * TShop entity. @author MyEclipse Persistence Tools
 */

public class TShop implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String description;
	private String location;
	private Short isDefault;
	private Set TGoods = new HashSet(0);
	private Set TAdmins = new HashSet(0);
	private Set TOrders = new HashSet(0);

	// Constructors

	/** default constructor */
	public TShop() {
	}

	/** minimal constructor */
	public TShop(String name, String description, String location) {
		this.name = name;
		this.description = description;
		this.location = location;
	}

	/** full constructor */
	public TShop(String name, String description, String location,
			Short isDefault, Set TGoods, Set TAdmins, Set TOrders) {
		this.name = name;
		this.description = description;
		this.location = location;
		this.isDefault = isDefault;
		this.TGoods = TGoods;
		this.TAdmins = TAdmins;
		this.TOrders = TOrders;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Short getIsDefault() {
		return this.isDefault;
	}

	public void setIsDefault(Short isDefault) {
		this.isDefault = isDefault;
	}

	public Set getTGoods() {
		return this.TGoods;
	}

	public void setTGoods(Set TGoods) {
		this.TGoods = TGoods;
	}

	public Set getTAdmins() {
		return this.TAdmins;
	}

	public void setTAdmins(Set TAdmins) {
		this.TAdmins = TAdmins;
	}

	public Set getTOrders() {
		return this.TOrders;
	}

	public void setTOrders(Set TOrders) {
		this.TOrders = TOrders;
	}

}