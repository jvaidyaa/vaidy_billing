package com.vaidy.billing.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vaidy.billing.dto.RegisterAccountReq;
import com.vaidy.billing.entity.Account;
import com.vaidy.billing.exception.AccountRegistrationException;
import com.vaidy.billing.repository.AccountRepository;






@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	static Logger log = LoggerFactory.getLogger(AccountService.class);
	
	@Transactional()
	public Account createAccount(RegisterAccountReq request) {
		Account retAccount = null;
		Account account = new Account();
		account.setEmail(request.getEmail());
		account.setGuid(request.getGuid());
		account.setMerchant(request.getMerchant());
		account.setId( generateApiKey());
		System.out.println(account.toString());

		try{
			retAccount = accountRepository.save(account);
		}catch (Exception exception) {
			throw new AccountRegistrationException("Email address '" + request.getEmail() + "' already in use");
		}

		return retAccount;		
		
	}
	

	public Account getAccount(String email){
		return (accountRepository.findAccountByEmail(email));
	}

	private String generateApiKey() {
		return UUID.randomUUID().toString();
	}
}
