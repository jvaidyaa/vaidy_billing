package com.vaidy.billing.service;

import java.security.Provider;
import java.security.Security;
import java.util.Arrays;
import java.util.HashSet;

import static java.lang.System.exit;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vaidy.billing.dto.CreateCryptoReq;
import com.vaidy.billing.dto.CreatePaymentMethodReq;
import com.vaidy.billing.entity.AES;
import com.vaidy.billing.entity.Crypto;
import com.vaidy.billing.entity.PaymentMethod;
import com.vaidy.billing.exception.AccountRegistrationException;
import com.vaidy.billing.repository.CryptoRepository;

@Service
public class CryptoService {
	@Autowired
	private CryptoRepository cryptoRepository;
	
	
	static Logger log = LoggerFactory.getLogger(AccountService.class);
	
	@Transactional()
	public Crypto createCrypto(CreateCryptoReq request) {
		Crypto retCrypto = null;
		Crypto crypto = new Crypto();
		crypto.setPaymentToken(generateApiKey());
		crypto.setEncryptedAccountNum( encrypt(request.getEncryptedAccountNum()) );
		System.out.println(encrypt(request.getEncryptedAccountNum()) );
		System.out.println(crypto.toString());

		try{
			retCrypto = cryptoRepository.save(crypto);
		}catch (Exception exception) {
			throw new AccountRegistrationException("PaymentToken '" + request.getPaymentToken() + "' already in use");
		}

		return retCrypto;		
		
	}
	public Crypto getCrypto(String paymenttoken){
		return cryptoRepository.findCryptoByPaymenttoken(paymenttoken);
	}
	
	private String generateApiKey() {
		return UUID.randomUUID().toString();
	}
	
	private String encrypt( String accnum ) {
		final String strToEncrypt = accnum;
		final String encryptorKey = "password";
		
		AES.setKey(encryptorKey);
		AES.encrypt(strToEncrypt.trim());
		
		return AES.getEncryptedString();
	}
}
