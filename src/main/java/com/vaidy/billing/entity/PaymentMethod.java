package com.vaidy.billing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//Table Asc
@Entity(name="PaymentMethod")
public class PaymentMethod {
	@Id
	@Column(name="payment_method_id")
	private String paymentmethodid;
	
	@Column(name="methodid")
	private String methodid;
	
	@Column(name="routingnumber")
	private String routingnumber;
	

	@Override
	public String toString() {
		return "PaymentMethod [paymentmethodid=" + paymentmethodid + ", methodid=" + methodid + "]";
	}
	
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
