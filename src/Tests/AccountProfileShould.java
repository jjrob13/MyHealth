package Tests;

import org.junit.Test;

import Model.AccountProfile;
import Tests.TestDoubles.AccountProfileDataCommunicatorStub;
import View.AccountProfileView;
import Control.AccountProfileControl;

public class AccountProfileShould {

	@Test
	public void AccountProfileBasic() {
		AccountProfileControl control = new AccountProfileControl(
				new AccountProfile(),
				new AccountProfileView(),
				new AccountProfileDataCommunicatorStub());
				;
		control.retrieveFromDataBase(1);
		control.updateView();
	}

}
