package com.vaidy.billing.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
//Table Asc
@Entity(name="Offer")
public class Offer {
	@Id
	@Column(name="name")
	private String name;
	
	@Column(name="offerid")
	private String offerid;
	
	@Column(name="price")
	private String price;
	
	@Column(name="language")
	private String language;
	
	@Override
	public String toString() {
		return "Offer [name=" + name + ", offerid=" + offerid + ", price=" + price + ", language=" + language + "]";
	}
	public String getName() {
		return name;
	}
	
	public void setName( String name) {
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
	
	public void setPrice( String price) {
		this.price = price;
	}
	
	public String getLang(){
		return language;
	}
	
	public void setLang( String language) {
		this.language = language;
	}
	
}