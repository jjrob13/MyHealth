package Communicators;
import java.sql.*;

public class GeneralDataCommunicator {
	
	//data here makes it a model this class needs to be refactored
	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;
	

	public static ResultSet executeQuery(String query){
		try {
			rs =  getStatement().executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public static void executeInsertQuery(String query){
		try {
			getStatement().executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void executeUpdateQuery(String query){
		executeInsertQuery(query);
	}
	
	public static double getMax(String category, int id){
		//Create Query using id and category
		String query = "Select MAX(" + category.toLowerCase() + ") from " + category + " where user_id = " + id;
		
		
		try {
			rs = getStatement().executeQuery(query);
			//return amount if it is present
			if(rs.next()){
				return rs.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Query failed
		return -1;
	}
	
	public static double getMin(String category, int id){
		//Create Query using id and category
		String query = "Select MIN(" + category.toLowerCase() + ") from " + category + " where user_id = " + id;
		
		
		try {
			rs = getStatement().executeQuery(query);
			
			//return min amount if it exists
			if(rs.next()){
				return rs.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Query failed
		return -1;
	}
	
	public static int getUserID(String username){
		//Create Query using id and category
		String query = "Select Profile.user_id from Profile where username = '" + username + "'";
		
		
		try {
			rs = getStatement().executeQuery(query);
			
			//return userid amount if it exists
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Query failed
		return -1;
	}
	
	public static double returnQueryDouble(String query){
		try {
			rs = getStatement().executeQuery(query);
			if(rs.next())
				return rs.getDouble(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;

	}
	
	public static double returnSumAfterDate(int userID, String category, String date){
		String query = "";
		double result = 0;
		
		//Just sum up the categories if it is not weight loss
		if(!category.toLowerCase().equals("weight")){
			query = "select sum("+ category.toLowerCase() + ") from " + fixSQLCategory(category) + " where entered >= \"" + date +
					"\" and user_id = " + userID + " group by user_id";
		
			try {
				rs = st.executeQuery(query);
				rs.first();
				
				result = rs.getDouble("sum("+ category.toLowerCase() + ")");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		//If category is weight, find start weight and end weight
		}else{
			query = "select startWeight,endWeight from " +
					"(select user_id,weight as startWeight from Weight " +
					"where entered >= \"" + date + "\" " +
					"and user_id = " + userID +
					" order by entered asc " +
					"limit 1) as StartWeight," +
					"(select user_id,weight as endWeight from Weight " +
					"where entered >= \"" + date + "\" " +
					"and user_id = " + userID +
					" order by entered desc " +
					"limit 1) as EndWeight " +
					"where StartWeight.user_id = EndWeight.user_id";
			
			//pull result out of result set
			try {
				rs = st.executeQuery(query);
				rs.first();
				
				result = rs.getDouble("startWeight") - rs.getDouble("endWeight");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		return result;
		
	}
	
	public static void closeConnection(){
		try {
			con.close();
			st.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		if(con == null)
		{
			try {
				con = DriverManager.getConnection("jdbc:mysql://192.254.236.69/daruma_JavaTest", "daruma_myhealth", "MyHealthCSE360");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return con;
	}
	
	private static String fixSQLCategory(String category){
		return (category.substring(0, 1).toUpperCase() + category.substring(1).toLowerCase());
	}
	
	private static Statement getStatement(){
		if(st == null)
		{
			try {
				st = getConnection().createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		return st;
	}
}

