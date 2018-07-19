package com.vaidy.billing.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

//@ApiModel("Account response model")
public class RegisterAccountPaymentReq {

	@JsonProperty(value = "accountid")
	private String accountid;

	@JsonProperty(value = "paymentmethodid")
	private String pmid;

	@JsonProperty(value = "firstname")
	private String firstname;

	@JsonProperty(value = "middlename")
	private String middlename;
	
	@JsonProperty(value = "lastname")
	private String lastname;
	
	@JsonProperty(value = "street")
	private String street;
	
	@JsonProperty(value = "aptsuite")
	private String aptsuite;
	
	@JsonProperty(value = "street3")
	private String street3;
	
	@JsonProperty(value = "city")
	private String city;
	
	@JsonProperty(value = "state")
	private String state;
	
	@JsonProperty(value = "country")
	private String country;
	
	@JsonProperty(value = "zip")
	private String zip;
	
	public String getAccountId() {
		return accountid;
	}
	public void setAccountId( String s ) {
		accountid = s;
	}
	
	public String getpmid() {
		return pmid;
	}
	public void setpmid( String s ) {
		pmid = s;
	}
	
	public String getFirstName() {
		return firstname;
	}
	public void setFirstName( String s ) {
		firstname = s;
	}
	
	public String getMiddleName() {
		return middlename;
	}
	public void setMiddleName( String s ) {
		middlename = s;
	}
	
	public String getLastName() {
		return lastname;
	}
	public void setLastName( String s ) {
		lastname = s;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet( String s ) {
		street = s;
	}
	
	public String getStreet3() {
		return street3;
	}
	public void setStreet3( String s ) {
		street3 = s;
	}
	
	public String getAptSuite() {
		return aptsuite;
	}
	public void setAptSuite( String s ) {
		aptsuite = s;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity( String s ) {
		city = s;
	}
	
	public String getState() {
		return state;
	}
	public void setState( String s ) {
		state = s;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry( String s ) {
		country = s;
	}
	
	public String getZip() {
		return zip;
	}
	public void setZip( String s ) {
		zip = s;
	}
	
	
}
