package com.vaidy.billing.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.vaidy.billing.dto.RegisterAccountReq;
import com.vaidy.billing.service.AccountService;

public class AccountControllerTest {

	private AccountService accountService;
	private MockMvc mockController;
	
	@Before
	public void initialize() {
		accountService = Mockito.mock(AccountService.class);
		mockController = MockMvcBuilders
				.standaloneSetup(new AccountController(accountService))
				.build();
	}
	@Test
	public void testRegister() throws Exception{
		com.vaidy.billing.entity.Account retAccount = new com.vaidy.billing.entity.Account();
		retAccount.setId("asassad");

		when(accountService.createAccount(createRegObject())).thenReturn(retAccount);
		mockController.perform(post("http://localhost:8080/register").content("{\"email\": \"vaidy1@abc.com\",\"guid\":\"1234hh\", \"merchant\":\"vaidy\"}").contentType("application/json")).andExpect(MockMvcResultMatchers.status().isOk());
		
		
	}
	
	

	private RegisterAccountReq createRegObject() {
		RegisterAccountReq req = new RegisterAccountReq();
		req.setEmail("vaidy1@abc.com");
		req.setGuid("1234hh");
		req.setMerchant("vaidy");
		return req;
	}
}
