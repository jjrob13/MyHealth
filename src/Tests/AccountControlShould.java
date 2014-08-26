package Tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import Control.AccountControl;

public class AccountControlShould {

	//@Test
	public void test() {
		AccountControl account = new AccountControl();
		
		account.retrieveFromDataBase("jjrob13");
		
		System.out.println(account.getHealthCollectionControl());
		
		assertFalse(account.getHealthCollectionControl().getAllMeasurements().isEmpty());
		
		
	}
	
	@Test
	public void testBirthday()
	{
		AccountControl account = new AccountControl();
		
		account.retrieveFromDataBase("jjrob13");
		Calendar cal = Calendar.getInstance();
			cal.setTime(account.getProfile().getModel().getBirthday());
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.MONTH)+1);
		
		assertFalse(account.getHealthCollectionControl().getAllMeasurements().isEmpty());
	}

}
