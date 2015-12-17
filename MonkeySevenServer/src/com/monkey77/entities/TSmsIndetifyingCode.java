package com.monkey77.entities;

/**
 * TSmsIndetifyingCode entity. @author MyEclipse Persistence Tools
 */

public class TSmsIndetifyingCode implements java.io.Serializable {

	// Fields

	private Integer id;
	private String mobile;
	private String indetifyingCode;

	// Constructors

	/** default constructor */
	public TSmsIndetifyingCode() {
	}

	/** full constructor */
	public TSmsIndetifyingCode(String mobile, String indetifyingCode) {
		this.mobile = mobile;
		this.indetifyingCode = indetifyingCode;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getIndetifyingCode() {
		return this.indetifyingCode;
	}

	public void setIndetifyingCode(String indetifyingCode) {
		this.indetifyingCode = indetifyingCode;
	}

}