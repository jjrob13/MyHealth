package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Control.VerificationController;

public class VerificationControllerShould {
	
	//Confirmed Working
	//@Test
	public void passwordCheck() {
		assertTrue(VerificationController.correctPassword("jjrob13", "hunter22"));
	}

	
	@Test
	public void incorrectAnswerCheck()
	{
		assertFalse(VerificationController.correctSecretAnswer("jjrob13", "alskdjfls"));
	}
	
	@Test
	public void correctAnswerCheck()
	{
		assertTrue(VerificationController.correctSecretAnswer("jjrob13", "oscar"));
	}
	
	//Confirmed Working
	//@Test
	public void usernameAvailable()
	{
		assertTrue(VerificationController.usernameAvailable("jjrobe10"));
	}
	
	//Confirmed Working
	//@Test
	public void usernameNotAvailable()
	{
		assertFalse(VerificationController.usernameAvailable("jjrob13"));
	}
	
	//@Test
	public void securityQuestionHash()
	{
		System.out.println(VerificationController.setHashedPassword("dog", "walter"));
	}
	
	
}
