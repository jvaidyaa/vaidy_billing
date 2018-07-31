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

import com.vaidy.billing.dto.CreateCryptoReq;
import com.vaidy.billing.entity.Crypto;
import com.vaidy.billing.service.CryptoService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CryptoController {
	@Autowired
	private CryptoService cryptoService;
	
	public CryptoController( CryptoService cryptoService ) {
		this.cryptoService = cryptoService;
	}
	
	@RequestMapping(
	
	value = "/enterPayment",
	method = RequestMethod.POST, 
	consumes = MediaType.APPLICATION_JSON_VALUE,
	produces = MediaType.APPLICATION_JSON_VALUE
	) 
	@ResponseBody()
	public Crypto registerOffer(
		//@ApiParam("Register Offer Request - This establishes an entity with the system ")
		@Validated @RequestBody CreateCryptoReq registerRequest)
	{
		Crypto c = cryptoService.createCrypto(registerRequest);
		return c;
	
	}
	@RequestMapping(value="/getPaymentInfo",   method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public Crypto getAccountPayment( @RequestParam(value="paymenttoken") String paymenttoken ) {
	
		Crypto paymentmethod = cryptoService.getCrypto(paymenttoken);
		return paymentmethod;
	}
}
