package com.vaidy.billing.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.vaidy.billing.dto.RegisterAccountReq;
import com.vaidy.billing.dto.RegisterOfferReq;
import com.vaidy.billing.service.AccountService;
import com.vaidy.billing.service.OfferService;

public class OfferControllerTest {
	private OfferService offerService;
	private MockMvc mockController;
	
	@Before
	public void initialize() {
		offerService = Mockito.mock(OfferService.class);
		mockController = MockMvcBuilders
				.standaloneSetup(new OfferController(offerService))
				.build();
	}
	@Test
	public void testRegister() throws Exception{
		com.vaidy.billing.entity.Offer retOffer = new com.vaidy.billing.entity.Offer();
		retOffer.setName("asassad");

		when(offerService.createOffer(createRegObject())).thenReturn(retOffer);
		mockController.perform(post("http://localhost:8080/registeroffer").content("{\"name\": \"Indian Shows\",\"offerid\":\"1234hh\", \"price\":\"2.00\", \"language\":\"Tamil\"}").contentType("application/json")).andExpect(MockMvcResultMatchers.status().isOk());
		
		mockController.perform(get("http://localhost:8080/getOffer"));
		
	}
	private RegisterOfferReq createRegObject() {
		RegisterOfferReq req = new RegisterOfferReq();
		req.setName("Indian News Channels");
		req.setOfferId("001");
		req.setPrice("7.99");
		req.setLang("Tamil");
		return req;
	}

}
