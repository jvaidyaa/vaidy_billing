package com.vaidy.billing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//Table Asc
@Entity(name="Account")
public class Account {
	@Id
	@Column(name="account_id")
	private String id;
	
	@Column(name="guid")
	private String guid;
	
	@Column(name="merchant")
	private String merchant;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	

	@Override
	public String toString() {
		return "Account [id=" + id + ", guid=" + guid + ", merchant=" + merchant + ", email=" + email + ", password= " + password + "]";
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getGuid() {
		return guid;
	}


	public void setGuid(String guid) {
		this.guid = guid;
	}


	public String getMerchant() {
		return merchant;
	}


	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}
	

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}


}
