package Tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import Communicators.AccountProfileDataCommunicator;
import Control.AccountControl;
import Model.AccountProfile;

public class AccountProfileDataCommunicatorShould {
	//Confirmed Working
	//@Test
	public void test() {
		AccountProfile profile = new AccountProfileDataCommunicator().retrieveFromDataBase(1);
		
		System.out.println(profile);
		assertEquals("jjrob13@gmail.com", profile.getEmail());
	}
	
	//Confirmed Working
	//@Test
	public void updateProfile()
	{
		AccountControl account = new AccountControl();
		account.retrieveFromDataBase("jjrob13");

		assertTrue(account.updateAccountProfile("John", "Robertson", 4, 19, 1994, "jjrob13@gmail.com", 69.5, 151));
	}
	
	
	public void addNewAccountProfile()
	{
		AccountControl account = new AccountControl();
		
	}
	

}
