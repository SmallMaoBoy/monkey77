package com.monkey77.entities;

import java.sql.Timestamp;

import org.apache.struts2.json.annotations.JSON;

/**
 * TMessage entity. @author MyEclipse Persistence Tools
 */

public class TMessage implements java.io.Serializable {

	// Fields

	private Integer id;
	private TUser TUser;
	private Timestamp createTime;
	private String content;
	private String contact;

	// Constructors

	/** default constructor */
	public TMessage() {
	}

	/** minimal constructor */
	public TMessage(TUser TUser, Timestamp createTime, String content) {
		this.TUser = TUser;
		this.createTime = createTime;
		this.content = content;
	}

	/** full constructor */
	public TMessage(TUser TUser, Timestamp createTime, String content,
			String contact) {
		this.TUser = TUser;
		this.createTime = createTime;
		this.content = content;
		this.contact = contact;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@JSON(serialize=false)
	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "TMessage [id=" + id + ", createTime=" + createTime
				+ ", content=" + content + ", contact=" + contact + "]";
	}

	
	
}