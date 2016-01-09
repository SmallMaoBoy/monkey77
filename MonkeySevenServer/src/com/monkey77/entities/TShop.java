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
	private Float lat;
	private Float lng;
	private Set TAdmins = new HashSet(0);
	private Set TOrders = new HashSet(0);

	// Constructors

	/** default constructor */
	public TShop() {
	}

	/** minimal constructor */
	public TShop(String name, String description, Float lat, Float lng) {
		this.name = name;
		this.description = description;
		this.lat = lat;
		this.lng = lng;
	}

	/** full constructor */
	public TShop(String name, String description, Float lat, Float lng,
			Set TAdmins, Set TOrders) {
		this.name = name;
		this.description = description;
		this.lat = lat;
		this.lng = lng;
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

	public Float getLat() {
		return this.lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	public Float getLng() {
		return this.lng;
	}

	public void setLng(Float lng) {
		this.lng = lng;
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