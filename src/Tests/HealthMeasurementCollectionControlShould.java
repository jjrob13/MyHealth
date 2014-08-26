package Tests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import Communicators.HealthMeasurementsDataCommunicator;
import Control.AccountControl;
import Control.HealthMeasurementCollectionControl;
import Model.MeasurementType;

public class HealthMeasurementCollectionControlShould {
	double amount = 2500;
	
	//Confirmed Working
	//@Test
	public void currentWeightUpdate()
	{
		AccountControl account = new AccountControl();
		account.retrieveFromDataBase("jjrob13");
		double firstWeight = account.getHealthCollectionControl().getCurrentWeight();
		account.getHealthCollectionControl().addNewMeasurement(account.getUserID(), "weight", firstWeight + .5);
		
		//The new current weight should not equal the old current weight
		double secondWeight = account.getHealthCollectionControl().getCurrentWeight();
		System.out.println(firstWeight);
		System.out.println(secondWeight);
		
		assertFalse(secondWeight == firstWeight);
	}
	
	
	//Confirmed Working
	//@Test
	public void dataPullSuccess() {
		HealthMeasurementCollectionControl control = new HealthMeasurementCollectionControl();
		control.setCommunicator(new HealthMeasurementsDataCommunicator());
		control.retrieveFromDataBase(1);
		assertFalse(control.getAllMeasurements().isEmpty());
	}
	
	//Confirmed Working
	//@Test
	public void addNewMeasurement()
	{
		HealthMeasurementCollectionControl control = new HealthMeasurementCollectionControl();
		control.setCommunicator(new HealthMeasurementsDataCommunicator());
		control.retrieveFromDataBase(1);

		assertTrue(control.addNewMeasurement(1,"calories", amount));
	}

	
	//Confirmed Working
	//@Test
	public void correctCurrentWeight()
	{
		HealthMeasurementCollectionControl control = new HealthMeasurementCollectionControl();
		control.setCommunicator(new HealthMeasurementsDataCommunicator());
		control.retrieveFromDataBase(1);

		
		System.out.println(control.getAllMeasurements());
	}
	
	
	//Confirmed Working
	//@Test
	public void getsCorrectAverage()
	{
		HealthMeasurementCollectionControl control = new HealthMeasurementCollectionControl();
		control.setCommunicator(new HealthMeasurementsDataCommunicator());
		control.retrieveFromDataBase(1);

		double average = control.getAverageAfterDate(new MeasurementType("calories"), new Date());
		System.out.println(average);
		assertTrue(average == 2200);
	}
	
	
	

	
}
