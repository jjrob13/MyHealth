package Control;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.NoSuchAlgorithmException;

import Communicators.GeneralDataCommunicator;

public class VerificationController {

	public static boolean correctPassword(String username, String plainTextPassword){
		
		boolean result = false;
		String query = "Select password from Profile where username = '" + username + "'";
		ResultSet rs = GeneralDataCommunicator.executeQuery(query);
		
		try {
			rs.first();
			if(rs.getString(1).equals(setHashedPassword(plainTextPassword, username)))
			{
				result = true;
			}
		} catch (SQLException e) {
			result = false;
		}
		
		
		return result;
		
	}
	
	public static String setHashedPassword(String plainTextPassword, String username) {
		
		String finalPassword = null;
	
			try {
				finalPassword = getHashedPassword(plainTextPassword) + getSalt(username);
			} catch (NoSuchAlgorithmException e) {
				
			}
			
		
		
		return finalPassword;
	}

	private static String getHashedPassword(String plainTextPassword){
		String hashedPassword = null;
		
		try {
            
	        //Create MessageDigest object for SHA-256 hashing algorithm
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	         
	        //Update plain text password in message digest
	        digest.update(plainTextPassword.getBytes(), 0, plainTextPassword.length());
	 
	        //Converts message digest value in base 16 (hex) 
	       hashedPassword = new BigInteger(1, digest.digest()).toString(16);
	 
	        } catch (NoSuchAlgorithmException e){
	        	
	        }
		
		return hashedPassword;
		
	}
	
	private static String getSalt(String username) throws NoSuchAlgorithmException{
		
		String salt = null;
		
		try {
            
	        //Create MessageDigest object for SHA-256 hashing algorithm
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	         
	        //Update plain text password in message digest
	        digest.update(username.getBytes(), 0, username.length());
	 
	        //Converts message digest value in base 16 (hex) 
	      salt = new BigInteger(1, digest.digest()).toString(16);
	 
	        } catch (NoSuchAlgorithmException e){
	        	
	        }

		
		return salt;
		
	}
	public static boolean correctSecretAnswer(String username, String answer)
	{
		boolean result = false;
		String query = "Select security_answer from Profile where username = '" + username + "'";
		ResultSet rs = GeneralDataCommunicator.executeQuery(query);
		
		try {
			rs.first();
			String answerFromDatabase = rs.getString(1);
			String enteredAnswer = setHashedPassword(answer.toLowerCase(), username);
			
			if(answerFromDatabase.equals(enteredAnswer))
			{
				result = true;
			}
		} catch (Exception e) {
			result = false;
		}
		
		
		return result;
	}
	
	
	public static boolean updatePassword(String username, String password)
	{
		boolean result = false;
		String query = "UPDATE Profile SET password='" +
				setHashedPassword(password, username) + "' WHERE username = '" + username +"';";
		
		try{
			GeneralDataCommunicator.executeUpdateQuery(query);
		}catch(Exception e)
		{
			//Update Failed
			result = false;
		}
		
		return true;
		
	}
	
	public static boolean usernameAvailable(String username)
	{
		boolean result = false;
		String query = "Select username from Profile where username = '" + username + "';";
		
		try{
			ResultSet rs = GeneralDataCommunicator.executeQuery(query);
			rs.first();
			rs.getString("username");
			result = false;
		}
		catch(Exception e){
			//username does not exist
			result = true;
		}
		
		return result;
	}
	
	
	

}
