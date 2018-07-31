package com.vaidy.billing.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
//Table Asc
@Entity(name="Crypto")
public class Crypto {
	@Id
	@Column(name="paymenttoken")
	private String paymenttoken;
	
	@Column(name="encryptedaccnum")
	private String encryptedaccnum;
	
	@Override
	public String toString() {
		return "Crypto [paymenttoken= " + paymenttoken + ", encrypted account num= " + encryptedaccnum + "]";
	}
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
