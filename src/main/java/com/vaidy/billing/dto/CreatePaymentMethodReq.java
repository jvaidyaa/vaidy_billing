package com.vaidy.billing.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

//@ApiModel("Account response model")
public class CreatePaymentMethodReq {

	@JsonProperty(value = "payment_method_id")
	private String paymentmethodid;

	@JsonProperty(value = "methodid")
	private String methodid;

	@JsonProperty(value = "routingnumber")
	private String routingnumber;

	public String getPaymentMethodId() {
		return paymentmethodid;
	}
	
	public void setPaymentMethodId( String s ) {
		paymentmethodid = s;
	}

	public String getMethodId() {
		return methodid;
	}
	
	public void setMethodId( String s ) {
		methodid = s;
	}
	
	public String getRoutingNumber() {
		return routingnumber;
	}
	
	public void setRoutingNumber( String s ) {
		routingnumber = s;
	}

}
