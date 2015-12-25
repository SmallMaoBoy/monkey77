package com.monkey77.entities;

/**
 * TKeywords entity. @author MyEclipse Persistence Tools
 */

public class TKeywords implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer count;

	// Constructors

	/** default constructor */
	public TKeywords() {
	}

	/** full constructor */
	public TKeywords(String name, Integer count) {
		this.name = name;
		this.count = count;
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

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "TKeywords [id=" + id + ", name=" + name + ", count=" + count
				+ "]";
	}
	
}