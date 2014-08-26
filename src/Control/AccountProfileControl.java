package Control;

import java.util.Date;

import Communicators.AccountProfileDataCommunicator;
import Interfaces.IDataControl;
import Model.AccountProfile;
import View.AccountProfileView;

public class AccountProfileControl  implements IDataControl {
	private AccountProfile model;
	private AccountProfileView view;
	private AccountProfileDataCommunicator communicator;
	
	
	
	public AccountProfileControl(AccountProfile model, AccountProfileView view,
			AccountProfileDataCommunicator communicator) {
		super();
		this.model = model;
		this.view = view;
		this.communicator = communicator;
	}
	
	public AccountProfileControl()
	{
		super();
		this.view = new AccountProfileView();
		this.communicator = new AccountProfileDataCommunicator();
		this.model = new AccountProfile();
		
	}
	
	public AccountProfileControl(AccountProfile model)
	{
		super();
		this.view = new AccountProfileView();
		this.communicator = new AccountProfileDataCommunicator();
		this.model = model;
	}

	public AccountProfileControl(String username, String firstName, String lastName,
			String email, Date birthday, char sex, String securityAnswer,
			double heightInches, String password, double goalWeight)
	{
		this.model = new AccountProfile(username, firstName, lastName, email, birthday, sex, securityAnswer, heightInches, password, goalWeight);
		this.view = new AccountProfileView();
		this.communicator = new AccountProfileDataCommunicator();
	}

	public String getEmail() {
		return model.getEmail();
	}

	public void setEmail(String email) {
		model.setEmail(email);
	}

	public char getSex() {
		return model.getSex();
	}

	public void setSex(char sex) {
		model.setSex(sex);
	}

	public void setSecurityAnswer(String answer)
	{
		model.setSecurityAnswer(answer);
	}
	
	public String getSecurityAnswer()
	{
		return model.getSecurityAnswer();
	}
	
	public String toString()
	{
		return model.toString();
	}
	
	public String getFirstName() {
		return this.model.getFirstName();
	}
	public void setFirstName(String firstName) {
		this.model.setFirstName(firstName);
	}
	public String getLastName() {
		return this.model.getLastName();
	}
	public void setLastName(String lastName) {
		this.model.setLastName(lastName);
	}
	
	public AccountProfile getModel()
	{
		return model;
	}

	@Override
	public void updateView(){
		view.printModel(model);
	}

	public AccountProfileDataCommunicator getCommunicator()
	{
		return this.communicator;
	}
	@Override
	public void retrieveFromDataBase(int userID) {
		model = communicator.retrieveFromDataBase(userID);
	}
	
	
}
