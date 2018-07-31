package com.vaidy.billing.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
//Table Asc
@Entity(name="AccountPayment")
public class AccountPayment {
	@Id
	@Column(name="accountid")
	private String accountid;
	
	@Column(name="paymentmethodid")
	private String pmid;
	
	@Column(name= "firstname")
	private String firstname;
	
	@Column(name="middlename")
	private String middlename;
	
	@Column(name= "lastname")
	private String lastname;
	
	@Column(name= "street")
	private String street;
	
	@Column(name= "aptsuite")
	private String aptsuite;
	
	@Column(name= "street3")
	private String street3;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="zip")
	private String zip;
	
	@Column(name="country")
	private String country;
	
	@Override
	public String toString() {
		String output = "";
		output += "AccountPayment [ account_id= " + accountid + ", pmid= " + pmid + ", firstname= " + firstname + ", middlename= " + middlename + ", lastname= " + lastname + ", street=" + street;
		output+= ", aptsuite= " + aptsuite + ", street3= " + street3 + ", city= " + city + ", country= " + country + ", state= " + state + ", zip= " + zip + "]";
		return output;
	}
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