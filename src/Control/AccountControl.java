package Control;

import java.util.Calendar;
import java.util.Date;

import Communicators.AccountProfileDataCommunicator;
import Communicators.GeneralDataCommunicator;
import Interfaces.IDataControl;


public class AccountControl implements IDataControl {
	protected AuthenticationControl authenticationControl;
	
	protected AccountProfileControl accountProfileControl;
	protected GoalCollectionControl goalCollectionControl;
	protected HealthMeasurementCollectionControl healthCollectionControl;
	protected MeasurementTypeCollectionControl typeCollectionControl;
	
	
	
	public AuthenticationControl getAuthenticationControl() {
		return authenticationControl;
	}

	public void setAuthenticationControl(AuthenticationControl authenticationControl) {
		this.authenticationControl = authenticationControl;
	}

	public AccountProfileControl getAccountProfileControl() {
		return accountProfileControl;
	}

	public void setAccountProfileControl(AccountProfileControl accountProfileControl) {
		this.accountProfileControl = accountProfileControl;
	}

	public GoalCollectionControl getGoalCollectionControl() {
		return goalCollectionControl;
	}

	public void setGoalCollectionControl(GoalCollectionControl goalCollectionControl) {
		this.goalCollectionControl = goalCollectionControl;
	}

	public HealthMeasurementCollectionControl getHealthCollectionControl() {
		return healthCollectionControl;
	}

	public void setHealthCollectionControl(
			HealthMeasurementCollectionControl healthCollectionControl) {
		this.healthCollectionControl = healthCollectionControl;
	}

	public MeasurementTypeCollectionControl getTypeCollectionControl() {
		return typeCollectionControl;
	}

	public void setTypeCollectionControl(
			MeasurementTypeCollectionControl typeCollectionControl) {
		this.typeCollectionControl = typeCollectionControl;
	}

	public AccountControl() {
		super();
		accountProfileControl = new AccountProfileControl();
		goalCollectionControl = new GoalCollectionControl();
		healthCollectionControl = new HealthMeasurementCollectionControl();
		typeCollectionControl = new MeasurementTypeCollectionControl();
		authenticationControl = new AuthenticationControl();
	}

	public AccountControl(AuthenticationControl authenticationControl,
			AccountProfileControl accountProfileControl,
			GoalCollectionControl goalCollectionControl,
			HealthMeasurementCollectionControl healthCollectionControl,
			MeasurementTypeCollectionControl typeCollectionControl) {
		super();
		this.accountProfileControl = accountProfileControl;
		this.goalCollectionControl = goalCollectionControl;
		this.authenticationControl = authenticationControl;
		this.healthCollectionControl = healthCollectionControl;
		this.typeCollectionControl = typeCollectionControl;
	}

	public AccountProfileControl getProfile() {
		return accountProfileControl;
	}

	public void setProfile(AccountProfileControl profile) {
		accountProfileControl = profile;
	}

	public HealthMeasurementCollectionControl getHealthMeasurements() {
		return healthCollectionControl;
	}
	
	public void addNewHealthMeasurement(HealthMeasurementControl measurement) {
		healthCollectionControl.addHealthMeasurement(measurement);
	}
	
	public void setHealthMeasurements(HealthMeasurementCollectionControl healthMeasurements) {
		this.healthCollectionControl = healthMeasurements;
	}

	public boolean getIsLocked() {
		return authenticationControl.getIsLocked();
	}

	public void setIsLocked(Boolean isLocked) {
		authenticationControl.setLocked(isLocked);
	}

	public String getUserName() {
		return authenticationControl.getUserName();
	}

	public void setUserName(String userName) {
		authenticationControl.setUserName(userName);
	}

	public int getUserID() {
		return authenticationControl.getUserID();
	}

	public void setUserID(int userID) {
		authenticationControl.setUserID(userID);
	}

	public Date getLastActive() {
		return authenticationControl.getLastActive();
	}

	public void setLastActive(Date lastActive) {
		authenticationControl.setLastActive(lastActive);
	}
	
	@Override
	public void updateView(){
		this.accountProfileControl.updateView();
		this.goalCollectionControl.updateView();
		this.authenticationControl.updateView();
		this.healthCollectionControl.updateView();
		this.typeCollectionControl.updateView();

	}

	public char getGender() {
		return accountProfileControl.getSex();
	}


	public void setGoals(GoalCollectionControl goals) {
		this.goalCollectionControl = goals;
	}
	
	public void addGoal(GoalControl goal) {
		this.goalCollectionControl.addGoal(goal);
	}

	public void authenticate(String userName){
		authenticationControl.retrieveFromDataBase(userName);
	}
	
	@Override
	public void retrieveFromDataBase(int userID) {
		{
			
			try{
			accountProfileControl.retrieveFromDataBase(userID);
			goalCollectionControl.retrieveFromDataBase(userID);
			healthCollectionControl.retrieveFromDataBase(userID);
			typeCollectionControl.retrieveFromDataBase(userID);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
	}
	
	public boolean retrieveFromDataBase(String username)
	{
		
		boolean result = true;
		
		try{
		authenticationControl.retrieveFromDataBase(username);
		int userID = authenticationControl.getUserID();
		accountProfileControl.retrieveFromDataBase(userID);
		goalCollectionControl.retrieveFromDataBase(userID);
		healthCollectionControl.retrieveFromDataBase(userID);
		typeCollectionControl.retrieveFromDataBase(userID);
		}
		catch(Exception e)
		{
			result = false;
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	
	public boolean updateAccountProfile(String firstName, String lastName, int month, int day, int year, String email, double heightInches, double goalWeight)
	{
		Calendar cal = Calendar.getInstance();
		//the - 1 sets it to the correct month because Calendar months start at zero
		cal.set(year, month - 1, day);
		
		this.getAccountProfileControl().setFirstName(firstName);
		this.getAccountProfileControl().setLastName(lastName);
		this.getAccountProfileControl().setEmail(email);
		this.getAccountProfileControl().getModel().setBirthday(cal.getTime());
		this.getAccountProfileControl().getModel().setHeightInches(heightInches);
		this.getAccountProfileControl().getModel().setGoalWeight(goalWeight);
		return this.getAccountProfileControl().getCommunicator().updateAccountProfile(this.getUserID(), firstName, lastName, cal.getTime(), email, heightInches, goalWeight);
		
	
	}
	
	
	public boolean addNewAccount(String username, String firstName, String lastName, String email, int birthdayYear, int birthdayMonth, int birthdayDay, char sex, String securityAnswer, String password, double heightInches, double goalWeight)
	{
		boolean result = false;
		
		try
		{
			this.getAccountProfileControl().getCommunicator().addToDataBase(username, firstName, lastName, email, birthdayYear, birthdayMonth, birthdayDay, sex, securityAnswer, password, heightInches, goalWeight);
			result = true;
		}catch(Exception e)
		{
			result = false;
		}
		
		if(result == true)
		{
			Calendar cal = Calendar.getInstance();
			//cal months start at 0 where sql months start at 1, hence the plus 1
			cal.set(birthdayYear, birthdayMonth, birthdayDay);
			this.setUserID(GeneralDataCommunicator.getUserID(username));
			this.getProfile().setFirstName(firstName);
			this.setUserName(username);
			this.getProfile().getModel().setUsername(username);
			this.getProfile().getModel().setLastName(lastName);
			this.getProfile().getModel().setEmail(email);
			this.getProfile().getModel().setBirthday(cal.getTime());
			this.getProfile().getModel().setSex(sex);
			this.getProfile().getModel().setSecurityAnswer(VerificationController.setHashedPassword(securityAnswer.toLowerCase(), username));
			this.getProfile().getModel().setPassword(VerificationController.setHashedPassword(password, username));
			this.getProfile().getModel().setHeightInches(heightInches);
			this.getProfile().getModel().setGoalWeight(goalWeight);
			
			

		}
		
		return result;
	}



}
