package com.vaidy.billing.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vaidy.billing.dto.RegisterOfferReq;
import com.vaidy.billing.entity.Account;
import com.vaidy.billing.entity.Offer;
import com.vaidy.billing.repository.OfferRepository;
@SpringBootApplication
@ComponentScan({"com.vaidy.billing.service"})
@EntityScan("com.vaidy.billing.entity")
public class OfferService {
	@Autowired
	private OfferRepository offerRepository;
	
	static Logger log = LoggerFactory.getLogger(OfferService.class);
	
	@Transactional()
	public Offer createOffer(RegisterOfferReq request) {
		Offer retOffer = null;
		Offer offer = new Offer();
		offer.setName(request.getName());
		offer.setOfferId(request.getOfferId());
		offer.setPrice(request.getPrice());
		offer.setLang(request.getLang());
		System.out.println(offer.toString());
		return retOffer;
	}
	public Offer getName(String name){
		return (offerRepository.findOfferByName(name));
	}
	public List<Offer> getOffers(){
		return (offerRepository.findAll());
}
	

}
