package com.vaidy.billing.repository;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vaidy.billing.entity.Crypto;

@Repository
public interface CryptoRepository extends JpaRepository<Crypto,Long> {

	@Query("SELECT A FROM Crypto A WHERE A.paymenttoken = ?1")
	public Crypto findCryptoByPaymenttoken(String paymenttoken); 
	
	Crypto findByPaymenttoken(String paymenttoken);
	

}
