package com.vaidy.billing.entity;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.print.DocFlavor.STRING;

import org.apache.commons.codec.binary.Base64;

//website of code algorithm: https://aesencryption.net/
//Base64 download: https://commons.apache.org/proper/commons-codec/download_codec.cgi

public class AES
{
	//keys
	
    private static SecretKeySpec secretKey ;
//	  helps create a SecretKey from a byte[] key
//    A secret (symmetric) key. The purpose of this interface is to group 
//    (and provide type safety for) all secret key interfaces. 
    
    private static byte[] key ;
    
    
    //string after AES encryption
	private static String encryptedString;
	//string given by user
	private static String decryptedString;
    
	
	private static IvParameterSpec ivParams;
	
	
    public static void setKey(String myKey){
//    	MessageDigest: Message digests are secure one-way hash functions that take 
//    	arbitrary-sized data and output a fixed-length hash value. 
    	MessageDigest temp = null;
    	
		try {
			
			key = myKey.getBytes("UTF-8");
//			UTF-8 is a variable width character encoding capable of encoding all 1,112,064 
//			valid code points in Unicode using one to four 8-bit bytes.
			
			temp = MessageDigest.getInstance("SHA-1");
//			Returns a MessageDigest object that implements the specified digest algorithm.
			
			
			key = temp.digest(key);
//			Performs a final update on the digest using the specified array 
//			of bytes, then completes the digest computation.
			
	    	key = Arrays.copyOf(key, 16); // use only first 128 bit
	    	
	    	System.out.println(new String(key,"UTF-8"));
	    	
		    secretKey = new SecretKeySpec(key, "AES");
		    
		    
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	    	  
	

    }
    
    //accesor methods+ mutator methods
    public static String getDecryptedString() {
		return decryptedString;
	}

	public static void setDecryptedString(String decryptedString) {
		AES.decryptedString = decryptedString;
	}

    public static String getEncryptedString() {
		return encryptedString;
	}

	public static void setEncryptedString(String encryptedString) {
		AES.encryptedString = encryptedString;
	}
	
	//encryption
	public static String encrypt(String strToEncrypt)
    {
        try
        {
        	//encryption and decryption transformation
        	
//        	A transformation is a string that describes the operation (or set of operations) 
//        	to be performed on the given input, to produce some output. A transformation always 
//        	includes the name of a cryptographic algorithm (e.g., AES), and may be followed by 
//        	a feedback mode and padding scheme. 
        	
        	
            Cipher AEScipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecureRandom randomSecureRandom = SecureRandom.getInstance("SHA1PRNG");
            byte[] iv = new byte[AEScipher.getBlockSize()];
            randomSecureRandom.nextBytes(iv);

            ivParams = new IvParameterSpec(iv);
          
            
            AEScipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParams);
            setEncryptedString(Base64.encodeBase64String(AEScipher.doFinal(strToEncrypt.getBytes("UTF-8"))));
            
            // AES:ECB:PKCS5PADDING = algorithm:mode:padding
            // ECB: Electronic CodeBook
            // CBC: Cipher Block Chaining
            // initialization vector info: https://stackoverflow.com/questions/29267435/generating-random-iv-for-aes-in-java
            
            
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: "+e.toString());
        }
        return null;

    }

    public static String decrypt(String strToDecrypt)
    {
        try
        {
            Cipher AEScipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");

           
            AEScipher.init(Cipher.DECRYPT_MODE, secretKey, ivParams);
            setDecryptedString(new String(AEScipher.doFinal(Base64.decodeBase64(strToDecrypt))));
            
            
           
            
        }
        catch (Exception e)
        {
         
            System.out.println("Error while decrypting: "+e.toString());

        }
        return null;
    }


//    public static void main(String args[])
//    {
// 
//                final String strToEncrypt = "My text to encrypt";
//                final String strPssword = "encryptor key";
//                AES.setKey(strPssword);
//               
//                AES.encrypt(strToEncrypt.trim());
//                
//                System.out.println("String to Encrypt: " + strToEncrypt); 
//                System.out.println("Encrypted: " + AES.getEncryptedString());
//           
//                final String strToDecrypt =  AES.getEncryptedString();
//                AES.decrypt(strToDecrypt.trim());
//               
//                System.out.println("String To Decrypt : " + strToDecrypt);
//                System.out.println("Decrypted : " + AES.getDecryptedString());
//        
//    }
     
}