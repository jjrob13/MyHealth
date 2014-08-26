package Communicators;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Control.MeasurementTypeControl;
import Interfaces.IDataCommunicator;
import Model.MeasurementType;
import View.MeasurementTypeView;

public class MeasurementTypeDataCommunicator implements IDataCommunicator{

	@Override
	public List<MeasurementTypeControl> retrieveFromDataBase(int userID) {
		String query = "Select * from MeasurementType;";
		
		ResultSet result = GeneralDataCommunicator.executeQuery(query);
		List<MeasurementTypeControl> list = new ArrayList<MeasurementTypeControl>();

		try {
			while(result.next())
			{
				list.add(new MeasurementTypeControl(
							new MeasurementType(
								result.getString("name"), 
								result.getString("units"),
								result.getDouble("min"),
								result.getDouble("max")
								), 
							new MeasurementTypeView()));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return list;
	}
	
	public List<MeasurementTypeControl> retrieveFromDataBase() {
		String query = "Select * from MeasurementType;";
		
		ResultSet result = GeneralDataCommunicator.executeQuery(query);
		List<MeasurementTypeControl> list = new ArrayList<MeasurementTypeControl>();

		try {
			while(result.next())
			{
				list.add(new MeasurementTypeControl(
							new MeasurementType(
								result.getString("name"), 
								result.getString("units")), 
							new MeasurementTypeView()));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return list;
	}
}
	
	
