package com.monkey77.entities;

/**
 * TShowPic entity. @author MyEclipse Persistence Tools
 */

public class TShowPic implements java.io.Serializable {

	// Fields

	private Integer id;
	private TGood TGood;
	private String picUrl;
	private Short type;
	private String description;

	// Constructors

	/** default constructor */
	public TShowPic() {
	}

	/** minimal constructor */
	public TShowPic(String picUrl, Short type) {
		this.picUrl = picUrl;
		this.type = type;
	}

	/** full constructor */
	public TShowPic(TGood TGood, String picUrl, Short type, String description) {
		this.TGood = TGood;
		this.picUrl = picUrl;
		this.type = type;
		this.description = description;
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

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Short getType() {
		return this.type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}