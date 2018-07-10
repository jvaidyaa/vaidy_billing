package com.vaidy.billing.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vaidy.billing.entity.Offer;



@Repository
public interface OfferRepository extends JpaRepository<Offer,Long> {

	@Query("SELECT A FROM Offer A WHERE A.name = ?1")
	public Offer findOfferByName(String name); 
	
	Offer findByName(String name);
	

}