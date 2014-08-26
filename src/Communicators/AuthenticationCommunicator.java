package Communicators;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import Model.Authentication;

public class AuthenticationCommunicator {

	public Authentication retrieveFromDataBase(String userName) {
		String query = "SELECT * FROM Profile where username = '" + userName +"';";

		ResultSet rs = GeneralDataCommunicator.executeQuery(query);
		Authentication authentication = null;
		
		try {
			rs.first();

			authentication = new Authentication(
					false, 
					userName, 
					rs.getInt("user_id"), 
					new Date(0));
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return authentication;

	}
	
	public Authentication retrieveFromDataBase(int userID) {
		String query = "SELECT * FROM Profile where user_id = '" + userID +"';";

		ResultSet rs = GeneralDataCommunicator.executeQuery(query);
		Authentication authentication = null;
		
		try {
			rs.first();

			authentication = new Authentication(
					false, 
					rs.getString("username"), 
					userID, 
					new Date(0));
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return authentication;

	}


}
