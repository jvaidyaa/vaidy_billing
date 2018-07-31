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

import com.vaidy.billing.dto.CreatePaymentMethodReq;
import com.vaidy.billing.entity.PaymentMethod;
import com.vaidy.billing.service.PaymentMethodService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PaymentMethodController {
	@Autowired
	private PaymentMethodService pmService;
	
	public PaymentMethodController( PaymentMethodService pmService ) {
		this.pmService = pmService;
	}
	
	@RequestMapping(
	
	value = "/createPaymentof",
	method = RequestMethod.POST, 
	consumes = MediaType.APPLICATION_JSON_VALUE,
	produces = MediaType.APPLICATION_JSON_VALUE
	) 
	@ResponseBody()
	public PaymentMethod registerOffer(
		//@ApiParam("Register Offer Request - This establishes an entity with the system ")
		@Validated @RequestBody CreatePaymentMethodReq registerRequest)
	{
		PaymentMethod pm = pmService.createPaymentMethod(registerRequest);
		return pm;
	
	}
	@RequestMapping(value="/getPaymentMethod",   method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public PaymentMethod getAccountPayment( @RequestParam(value="paymentmethodid") String paymentmethodid ) {
	{
	
		PaymentMethod paymentmethod = pmService.getPaymentMethod(paymentmethodid);
		return paymentmethod;
	}
	}
}
