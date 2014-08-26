package Tests.TestDoubles;

import java.util.Date;

import Communicators.AuthenticationCommunicator;
import Model.Authentication;

public class AuthenticationCommunicatorStub extends AuthenticationCommunicator{
	public Authentication retrieveFromDataBase(String userName) {
		return new Authentication(false, userName, 1, new Date());
	}
}
