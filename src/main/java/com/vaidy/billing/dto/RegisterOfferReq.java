package com.vaidy.billing.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterOfferReq {
	@JsonProperty(value = "name")
	private String name;

	@JsonProperty(value = "offerid")
	private String offerid;

	@JsonProperty(value = "price")
	private String price;
	
	@JsonProperty(value = "language")
	private String language;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getOfferId() {
		return offerid;
	}
	
	public void setOfferId( String offerid ) {
		this.offerid = offerid;
	}
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getLang(){
		return language;
	}
	
	public void setLang(String language) {
		this.language = language;
		
	}

}