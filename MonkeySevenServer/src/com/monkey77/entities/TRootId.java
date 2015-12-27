package com.monkey77.entities;

/**
 * TRootId entity. @author MyEclipse Persistence Tools
 */

public class TRootId implements java.io.Serializable {

	// Fields

	private Integer id;
	private String account;
	private String password;

	// Constructors

	/** default constructor */
	public TRootId() {
	}

	/** full constructor */
	public TRootId(Integer id, String account, String password) {
		this.id = id;
		this.account = account;
		this.password = password;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TRootId))
			return false;
		TRootId castOther = (TRootId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getAccount() == castOther.getAccount()) || (this
						.getAccount() != null && castOther.getAccount() != null && this
						.getAccount().equals(castOther.getAccount())))
				&& ((this.getPassword() == castOther.getPassword()) || (this
						.getPassword() != null
						&& castOther.getPassword() != null && this
						.getPassword().equals(castOther.getPassword())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getAccount() == null ? 0 : this.getAccount().hashCode());
		result = 37 * result
				+ (getPassword() == null ? 0 : this.getPassword().hashCode());
		return result;
	}

}