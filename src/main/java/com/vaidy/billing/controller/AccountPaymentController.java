package com.vaidy.billing.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vaidy.billing.dto.CreateAccountPaymentReq;
import com.vaidy.billing.entity.AccountPayment;
import com.vaidy.billing.service.AccountPaymentService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AccountPaymentController {
	@Autowired
	private AccountPaymentService apService;
	
	public AccountPaymentController( AccountPaymentService apService ) {
		this.apService = apService;
	}
	
	@RequestMapping(
	
	value = "/createPaymentMethod",
	method = RequestMethod.POST, 
	consumes = MediaType.APPLICATION_JSON_VALUE,
	produces = MediaType.APPLICATION_JSON_VALUE
	) 
	@ResponseBody()
	public AccountPayment registerOffer(
		//@ApiParam("Register Offer Request - This establishes an entity with the system ")
		@Validated @RequestBody CreateAccountPaymentReq registerRequest)
	{
		AccountPayment accpayment = apService.createPaymentMethod(registerRequest);
		return accpayment;
	
	}
	@RequestMapping(value="/getAccountPayment",   method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public AccountPayment getAccountPayment( @RequestParam(value="accountid") String accountid ) {
	{
	
		AccountPayment accountpmt = apService.getAccountPaymentInfo(accountid);
		return accountpmt;
	}
	}
}
