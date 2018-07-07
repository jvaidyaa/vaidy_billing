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
	

	@RequestMapping(value = "/offerlisting", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	
	@ResponseBody()
	public ArrayList<Offer> offerListing()
	{
		//USING A DATABASE
		// we're unsure at this point how to read in from a database primarily bc we don't have a database file yet
		
		
		
		//USING A FILE
		//File stmt = new File("C:\\Users\\Anjali\\Documents\\work\\summer '18\\vaidy_billing-master\\offerListings.txt");
		
		
		Scanner sc = new Scanner(file);
		ArrayList<Offer> offerList = new ArrayList<Offer>();
		
		while(sc.hasNext())
		{
			Offer offer1 = new Offer(); // create offer object
			//IN THE CASE THAT WE HAVE A DATABASE:
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			Statement stmt=con.createStatement();  
			ResultSet rs = stmt.executeQuery("select * from emp");
			
			while(rs.next())
			{
				offer1.setName(rs.getString(1));
				offer1.setOfferId(rs.getString(2));
				offer1.setPrice(rs.getString(3));
				offer1.setLang(rs.getString(4));
				offerList.add(offer1);			
			}
					
			
		}
		
		return offerList;
		
	}
	

}




































