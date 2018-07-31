package com.vaidy.billing.repository;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vaidy.billing.entity.AccountPayment;


@Repository
public interface AccountPaymentRepository extends JpaRepository<AccountPayment,Long> {

	@Query("SELECT A FROM AccountPayment A WHERE A.accountid = ?1")
	public AccountPayment findAccountPaymentByAccountid(String accountid); 
	
	AccountPayment findByAccountid(String accountid);
	

}
