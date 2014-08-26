package Communicators;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Control.HealthMeasurementControl;
import Interfaces.IDataCommunicator;
import Model.HealthMeasurement;
import Model.MeasurementType;
import View.HealthMeasurementView;

public class HealthMeasurementsDataCommunicator implements IDataCommunicator{
	
	@Override
	public List<HealthMeasurementControl> retrieveFromDataBase(int userID) {
		String query = "Select * from Measurements,MeasurementType where Measurements.type_id = MeasurementType.type_id and" +
				" user_id = " + userID;
		
		ResultSet result = GeneralDataCommunicator.executeQuery(query);
		List<HealthMeasurementControl> list = new ArrayList<HealthMeasurementControl>();

		try {
			while(result.next())
			{
				list.add(new HealthMeasurementControl(new HealthMeasurement(new MeasurementType(
						result.getString("name"), 
						result.getString("units")), 
						result.getDouble("amount"), 
						result.getTimestamp("timestamp")), new HealthMeasurementView()));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return list;
	}
		
	public void addToDataBase(int userID, HealthMeasurementControl control)
	{
		
		if(userID != 0)
		{
			String query = "INSERT INTO Measurements (`user_id`, `type_id`, `amount`) VALUES ('"
					+ userID + "', '"
					+ control.getType().getTypeID() + "', '"
					+ control.getAmount() + "');";
			
			GeneralDataCommunicator.executeInsertQuery(query);
		}
	}

}
