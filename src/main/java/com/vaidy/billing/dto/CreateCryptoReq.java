package com.vaidy.billing.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

//@ApiModel("Account response model")
public class CreateCryptoReq {

	@JsonProperty(value = "paymenttoken")
	private String paymenttoken;

	@JsonProperty(value = "encryptedaccnum")
	private String encryptedaccnum;

	public String getPaymentToken() {
		return paymenttoken;
	}
	
	public void setPaymentToken( String s ) {
		paymenttoken = s;
	}

	public String getEncryptedAccountNum() {
		return encryptedaccnum;
	}
	
	public void setEncryptedAccountNum( String s ) {
		encryptedaccnum = s;
	}
	
}
