package Tests;

//import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import Communicators.GeneralDataCommunicator;

public class myDataBaseShould {

	@Test
	public void test() {
		String userID = "jjrob13";
		String query = "SELECT * FROM Profile where username = '" + userID +"';";
		
		ResultSet rs = GeneralDataCommunicator.executeQuery(query);

		try {
			String name = rs.getMetaData().getColumnName(1);

			System.out.println(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
