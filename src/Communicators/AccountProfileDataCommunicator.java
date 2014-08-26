package Communicators;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import Control.VerificationController;
import Interfaces.IDataCommunicator;
import Model.AccountProfile;

public class AccountProfileDataCommunicator implements IDataCommunicator {
	
	@Override
	public AccountProfile retrieveFromDataBase(int userID) {
		String query = "SELECT * FROM Profile where user_id = '" + userID +"';";

		ResultSet rs = GeneralDataCommunicator.executeQuery(query);
		// TODO Auto-generated method stub
		AccountProfile newProfile = null;
		
		try {
			rs.first();

			newProfile = new AccountProfile(
					rs.getString("username"), 
					rs.getString("first_name"), 
					rs.getString("last_name"), 
					rs.getString("email"),
					rs.getDate("birthday"), 
					rs.getString("sex").toCharArray()[0], 
					rs.getString("security_answer"),
					rs.getDouble("height_inches"),
					rs.getString("password"),
					rs.getDouble("goal_weight"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newProfile;
	}
	
	public AccountProfile addToDataBase(String username, String firstName, String lastName, String email, int birthdayYear, int birthdayMonth, int birthdayDay, char sex, String securityAnswer, String password, double heightInches, double goalWeight)
	{
		Date birthday = new Date(new GregorianCalendar(birthdayYear, birthdayMonth, birthdayDay).getTimeInMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		AccountProfile accountProfile = new AccountProfile(username, firstName, lastName, email, birthday, sex, securityAnswer, heightInches, password, goalWeight);
		
		String query = "INSERT INTO Profile (username, first_name, last_name, email, birthday, sex, security_answer, password, height_inches, goal_weight) " +
				"VALUES ('" + 
					username + "', '" +
					firstName + "', '" +
					lastName + "', '" +
					email + "', '" +
					dateFormat.format(birthday) + "', '" +
					sex + "', '" +
					VerificationController.setHashedPassword(securityAnswer, username) + "', '" +
					VerificationController.setHashedPassword(password, username) + "', '" +
					heightInches + "', '" +
					goalWeight + "')";
		
		
		//Insert into DB
		GeneralDataCommunicator.executeInsertQuery(query);
		//set UserId
		//authenticate after create new account
		
		return accountProfile;
	}
	
	
	public boolean updateAccountProfile(int userID, String firstName, String lastName, Date birthday, String email, double height, double goalWeight)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String query = "UPDATE Profile SET first_name='" +
				firstName + "', last_name= '" +
						lastName + "', email='" +
								email + "', birthday='" +
										dateFormat.format(birthday.getTime()) + "', height_inches='" +
												height + "', goal_weight = '"
												+ goalWeight + "' WHERE user_id='" +
														userID + "';";
		boolean result = false;
		
		
		try
		{
			GeneralDataCommunicator.executeUpdateQuery(query);
			result = true;
		}catch(Exception e)
		{
			result = false;
		}
		
		return result;
		
	}
	
}
