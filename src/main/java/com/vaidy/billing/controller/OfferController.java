package com.vaidy.billing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vaidy.billing.dto.RegisterOfferReq;
import com.vaidy.billing.entity.Offer;
import com.vaidy.billing.service.OfferService;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.sql.*;

@RestController
public class OfferController {
	@Autowired
	private OfferService offerservice;
	@RequestMapping(
	
	value = "/registeroffer",
	method = RequestMethod.POST, 
	consumes = MediaType.APPLICATION_JSON_VALUE,
	produces = MediaType.APPLICATION_JSON_VALUE
	) 
	@ResponseBody()
	public Offer registerOffer(
		//@ApiParam("Register Offer Request - This establishes an entity with the system ")
		@Validated @RequestBody RegisterOfferReq registerRequest)
	{
		Offer offer = offerservice.createOffer(registerRequest);
		return offer;
	
	}
	


	

}




































