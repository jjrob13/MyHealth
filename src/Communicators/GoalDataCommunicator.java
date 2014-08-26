package Communicators;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Control.GoalControl;
import Interfaces.IDataCommunicator;
import Model.Goal;
import Model.MeasurementType;
import View.GoalView;


public class GoalDataCommunicator implements IDataCommunicator{

	@Override
	public List<GoalControl> retrieveFromDataBase(int userID) {
		String query = "Select * from Goals,MeasurementType where Goals.type_id = MeasurementType.type_id and" +
				" user_id = " + userID;
		
		List<GoalControl> list = new ArrayList<GoalControl>();
		
		ResultSet rs = GeneralDataCommunicator.executeQuery(query);
		
		try {
			while(rs.next())
			{
				list.add(new GoalControl(new Goal(new MeasurementType(
						rs.getString("name"), 
						rs.getString("units")), 
						rs.getDouble("amount"), 
						rs.getTimestamp("timestamp")), new GoalView()));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public void addToDataBase(int userID, GoalControl goal)
	{
		String query = "INSERT INTO Goals (`user_id`, `type_id`, `amount`) VALUES ('"
				+ userID + "', '"
				+ goal.getType().getTypeID() + "', '"
				+ goal.getAmount() + "');";
		
		GeneralDataCommunicator.executeInsertQuery(query);
	}
}
