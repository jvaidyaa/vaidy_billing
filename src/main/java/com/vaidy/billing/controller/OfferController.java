package com.vaidy.billing.controller;

import java.io.File;
import java.util.List;

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
import com.vaidy.billing.entity.Account;
import com.vaidy.billing.entity.Offer;
import com.vaidy.billing.service.AccountService;
import com.vaidy.billing.service.OfferService;

@RestController
public class OfferController {
	@Autowired
	private OfferService offerService;
	
	public OfferController( OfferService offerService ) {
		this.offerService = offerService;
	}
	
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
		Offer offer = offerService.createOffer(registerRequest);
		return offer;
	
	}
	@RequestMapping(value="/getOffer",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public Offer getOffer( @RequestParam(value="name") String name) {
	{
		Offer offer = offerService.getName(name);
		return offer;
	}
	}
	@RequestMapping(value="/getOffers",    method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public Offer[] getOffers( ) {
	{
		//String email = "vaidy1@abc.com";
		 List<Offer> loffs =  offerService.getOffers();

		 Offer[] offerArray = (Offer[]) loffs.toArray(new Offer[loffs.size()]);
		 return offerArray;

	}
}

}
