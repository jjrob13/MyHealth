package Tests;

//import static org.junit.Assert.*;

import static org.junit.Assert.*;

import org.junit.Test;

import java.sql.Timestamp;
import java.util.*;

import Communicators.HealthMeasurementsDataCommunicator;
import Control.HealthMeasurementCollectionControl;
import Control.HealthMeasurementControl;
import Model.HealthMeasurement;
import Model.MeasurementType;
import View.HealthMeasurementView;

public class HealthMeasurementDataCommunicatorShould {

	@Test
	public void pullFromDatabase()
	{
		HealthMeasurementCollectionControl measurements = new HealthMeasurementCollectionControl();
		measurements.retrieveFromDataBase(1);
		System.out.println(measurements.getAllMeasurements());
		assertFalse(measurements.getAllMeasurements().isEmpty());
	}
	
	//@Test
	public void insertIntoDatabase() {
		HealthMeasurementControl newMeasurement = new HealthMeasurementControl(new HealthMeasurement(new MeasurementType("sleep", "hours"), 10.0 , new Timestamp(new Date().getTime())), new HealthMeasurementView());
		HealthMeasurementCollectionControl control = new HealthMeasurementCollectionControl();
		control.setCommunicator(new HealthMeasurementsDataCommunicator());
		control.addHealthMeasurement(newMeasurement);
	}
	
	

}
