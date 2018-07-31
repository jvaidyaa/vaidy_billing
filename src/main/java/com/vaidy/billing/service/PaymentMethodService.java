package com.vaidy.billing.service;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vaidy.billing.dto.CreatePaymentMethodReq;
import com.vaidy.billing.entity.PaymentMethod;
import com.vaidy.billing.exception.AccountRegistrationException;
import com.vaidy.billing.repository.PaymentMethodRepository;


@Service
public class PaymentMethodService {

	@Autowired
	private PaymentMethodRepository pmRepository;
	
	
	static Logger log = LoggerFactory.getLogger(AccountService.class);
	
	@Transactional()
	public PaymentMethod createPaymentMethod(CreatePaymentMethodReq request) {
		PaymentMethod retPaymentMethod = null;
		PaymentMethod pm = new PaymentMethod();
		pm.setPaymentMethodId(generateApiKey());
		pm.setMethodId(request.getMethodId());
		pm.setRoutingNumber(request.getRoutingNumber());
		System.out.println(pm.toString());

		try{
			retPaymentMethod = pmRepository.save(pm);
		}catch (Exception exception) {
			throw new AccountRegistrationException("PaymentMethodId '" + request.getPaymentMethodId() + "' already in use");
		}

		return retPaymentMethod;		
		
	}
	

	public PaymentMethod getPaymentMethod(String pmid){
		return (pmRepository.findPaymentMethodBypaymentmethodid(pmid));
	}
//	public List<Account> getAccounts(){
//		return (accountRepository.findAll());
//	}

	private String generateApiKey() {
		return UUID.randomUUID().toString();
	}
	
}
