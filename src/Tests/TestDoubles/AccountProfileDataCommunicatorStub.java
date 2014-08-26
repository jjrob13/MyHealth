package Tests.TestDoubles;

import java.sql.Date;

import Communicators.AccountProfileDataCommunicator;
import Interfaces.IDataCommunicator;
import Model.AccountProfile;

public class AccountProfileDataCommunicatorStub extends AccountProfileDataCommunicator implements IDataCommunicator{
	public AccountProfile retrieveFromDataBase(int userID) {
		AccountProfile model = new AccountProfile("username", "firstName", "lastName", "email", new Date(0), 'm', "securityAnswer", 50, "password", 150);
		return model;
	}
}
