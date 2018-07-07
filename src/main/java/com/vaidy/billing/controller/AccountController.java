package com.vaidy.billing.controller;


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

import com.aol.billing.service.DbTableSourcesLoader;
import com.aol.billing.service.HandlersService;
import com.aol.billing.service.SourcesRegistry;
import com.vaidy.billing.dto.RegisterAccountReq;
import com.vaidy.billing.entity.Account;
import com.vaidy.billing.service.AccountService;


//import io.swagger.annotations.ApiParam;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;

	}

	
	@RequestMapping(
			value = "/register",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	@ResponseBody()
	public Account registerAccount(
			//@ApiParam("Register Account Request - This establishes an entity with the system ")
			@Validated @RequestBody RegisterAccountReq registerRequest)
	{
		Account account = accountService.createAccount(registerRequest);
		return account;
		

	}

	@RequestMapping(value="/getAccount",    method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public Account getAccount( @RequestParam(value="email") String email) {
	{
		Account account = accountService.getAccount(email);
		return account;
	}
	}
	
	@RequestMapping(value="/getAccounts",    method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public Account[] getAccounts( ) {
	{
		//String email = "vaidy1@abc.com";
		 List<Account> laccs =  accountService.getAccounts();
		 return (Account[])laccs.toArray();

	}
	}
}
