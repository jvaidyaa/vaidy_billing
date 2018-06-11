package com.vaidy.billing.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vaidy.billing.entity.Account;



@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

	@Query("SELECT A FROM Account A WHERE A.email = ?1")
	public Account findAccountByEmail(String email); 
	
	Account findByEmail(String email);
	

}
