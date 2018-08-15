package com.vaidy.billing.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

//@ApiModel("Account response model")
public class RegisterAccountReq {

	@JsonProperty(value = "guid")
	private String guid;

	@JsonProperty(value = "email")
	private String email;

	@JsonProperty(value = "merchant")
	private String merchant;

	@JsonProperty(value = "password")
	private String password;

	public String getGuid() {
		return guid;
	}


	public void setGuid(String guid) {
		this.guid = guid;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMerchant() {
		return merchant;
	}


	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



}
