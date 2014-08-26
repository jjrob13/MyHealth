package Tests;


import org.junit.Test;

import Tests.TestDoubles.AccountControlStub;


public class AccountShould {

	@Test
	public void AccountBasic() {
		AccountControlStub control = new AccountControlStub();
		
		control.retrieveFromDataBase(1);
		control.updateView();
				
	}
}
