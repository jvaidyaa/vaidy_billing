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

import com.vaidy.billing.dto.RegisterAccountPaymentReq;
import com.vaidy.billing.service.AccountPaymentService;

public class AccountPaymentControllerTest {

	private AccountPaymentService accountPaymentService;
	private MockMvc mockController;
	
	@Before
	public void initialize() {
		accountPaymentService = Mockito.mock(AccountPaymentService.class);
		mockController = MockMvcBuilders
				.standaloneSetup(new AccountPaymentController(accountPaymentService))
				.build();
	}
	@Test
	public void testRegister() throws Exception{
		com.vaidy.billing.entity.AccountPayment retAccount = new com.vaidy.billing.entity.AccountPayment();
		retAccount.setAccountId("asassad");

		when(accountPaymentService.createAccountPaymentInfo(createRegObject())).thenReturn(retAccount);
		mockController.perform(post("http://localhost:8080/accountpaymentinfo").content("{\"pmid\":\"1234\", \"firstname\":\"Peter\", \"middlename\":\"John\", \"lastname\":\"Samuels\", \"street\":\"32 Gulley Way\", \"aptsuite\":\"n/a\", \"street3\":\"n/a\", \"country\":\"USA\", \"state\":\"Tennessee\", \"city\": \"Memphis\", \"zip\":\"92134\"}").contentType("application/json")).andExpect(MockMvcResultMatchers.status().isOk());
		
		mockController.perform(get("http://localhost:8080/getAccountPayment"));
		
	}
	
	

	private RegisterAccountPaymentReq createRegObject() {
		RegisterAccountPaymentReq req = new RegisterAccountPaymentReq();
		req.setAccountId("98134892374");
		req.setAptSuite("n/a");
		req.setCity("Memphis");
		req.setCountry("USA");
		req.setFirstName("Peter");
		req.setLastName("Samuels");
		req.setMiddleName("John");
		req.setpmid("1234");
		req.setState("Tennessee");
		req.setStreet("32 Gulley Way");
		req.setStreet3("n/a");
		req.setZip("92134");
		return req;
	}
}