package com.vaidy.billing.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vaidy.billing.controller.AccountController;
import com.vaidy.billing.dto.CreateAccountPaymentReq;
import com.vaidy.billing.entity.AccountPayment;
import com.vaidy.billing.exception.AccountRegistrationException;
import com.vaidy.billing.repository.AccountPaymentRepository;
import com.vaidy.billing.service.AccountService;

@Service

public class AccountPaymentService {

	@Autowired
	private AccountPaymentRepository accountPaymentRepository;
	
	static Logger log = LoggerFactory.getLogger(AccountService.class);
	
	@Transactional()
	public AccountPayment createPaymentMethod(CreateAccountPaymentReq request) {
		AccountPayment retAccountPayment = null;
		AccountPayment accountpayment = new AccountPayment();
		accountpayment.setAccountId(request.getAccountId());
		accountpayment.setFirstName(request.getFirstName());
		accountpayment.setMiddleName(request.getMiddleName());
		accountpayment.setLastName(request.getLastName());
		accountpayment.setStreet(request.getStreet());
		accountpayment.setAptSuite(request.getAptSuite());
		accountpayment.setStreet3(request.getStreet3());
		accountpayment.setCity(request.getCity());
		accountpayment.setState(request.getState());
		accountpayment.setZip(request.getZip());
		accountpayment.setCountry(request.getCountry());
		System.out.println(accountpayment.toString());
		

		try{
			retAccountPayment = accountPaymentRepository.save(accountpayment);
		}catch (Exception exception) {
			throw new AccountRegistrationException("Account ID'" + request.getAccountId() + "' already in use");
		}

		return retAccountPayment;		
		
	}


	public AccountPayment getAccountPaymentInfo(String accountid){
		return (accountPaymentRepository.findAccountPaymentByAccountid(accountid));
	}
	

	
}
