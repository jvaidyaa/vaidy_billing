package com.vaidy.billing.repository;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vaidy.billing.entity.PaymentMethod;


@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod,Long> {

	@Query("SELECT A FROM PaymentMethod A WHERE A.paymentmethodid = ?1")
	public PaymentMethod findPaymentMethodBypaymentmethodid(String paymentmethodid); 
	
	PaymentMethod findBypaymentmethodid(String paymentmethodid);
	

}
