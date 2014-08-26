package Control;

import java.util.*;

import Communicators.AuthenticationCommunicator;
import Interfaces.IDataControl;
import Model.Authentication;
import View.AuthenticationView;

public class AuthenticationControl  implements IDataControl {
	private static Authentication model;
	private AuthenticationView view;
	private AuthenticationCommunicator communicator;
	
	
		
	public AuthenticationControl(Authentication model, AuthenticationView view,
			AuthenticationCommunicator communicator) {
		super();
		AuthenticationControl.model = model;
		this.view = view;
		this.communicator = communicator;
	}
	
	public AuthenticationControl()
	{
		this.model = new Authentication();
		this.view = new AuthenticationView();
		this.communicator = new AuthenticationCommunicator();
		
	}

	public Boolean authenticate(String username, String password){
		return VerificationController.correctPassword(username, password);
	}
	
	public Boolean isTimedOut(){
		return false;
	}
	
	public Boolean checkSecurityQuestion(String answer)
	{
		return VerificationController.correctSecretAnswer(model.getUserName(), answer);
	}

	@Override
	public void updateView() {
		view.udateView(model);
		
	}

	public boolean getIsLocked() {
		return model.isLocked();
	}
	
	public void setLocked(boolean isLocked){
		model.setLocked(isLocked);
	}

	public String getUserName() {
		return model.getUserName();
	}

	public void setUserName(String userName) {
		model.setUserName(userName);		
	}

	
	
	public static int getUserID() {
		if (model == null)
			return -1;
		else
			return model.getUserID();
	}

	public void setUserID(int userID) {
		model.setUserID(userID);
	}
	
	public Date getLastActive() {
		return model.getLastActive();
	}
	
	public void setLastActive(java.util.Date lastActive) {
		model.setLastActive(lastActive);
	}

	public void retrieveFromDataBase(String userName) {
		model = communicator.retrieveFromDataBase(userName);		
	}
	
	@Override
	public void retrieveFromDataBase(int userID) {
		model = communicator.retrieveFromDataBase(userID);
	}


	
}
