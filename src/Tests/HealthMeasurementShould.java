package Tests;

import java.sql.Timestamp;
import java.util.*;

import org.junit.Test;

import Control.HealthMeasurementCollectionControl;
import Control.HealthMeasurementControl;
import Model.HealthMeasurement;
import Model.MeasurementType;
import Tests.TestDoubles.HealthMeasurementsDataCommunicatorStub;
import View.HealthMeasurementCollectionView;
import View.HealthMeasurementView;

public class HealthMeasurementShould {

	@Test
	public void HealthMeasurementBasic() {
		HealthMeasurementControl control = new HealthMeasurementControl(retriveHealthMeasurementFromDataBase(),new HealthMeasurementView());
		control.updateView();
	}
	
	@Test
	public void HealthMeasurementCollectionBasic() {
		
				
		HealthMeasurementCollectionControl control = new HealthMeasurementCollectionControl(
				new ArrayList<HealthMeasurementControl>(), 
				new HealthMeasurementCollectionView(),
				new HealthMeasurementsDataCommunicatorStub());
		control.retrieveFromDataBase(1);
		control.updateView();
	}
	
	private static HealthMeasurement retriveHealthMeasurementFromDataBase(){
		return new HealthMeasurement(new MeasurementType("Name", "Units"), 10.0, new Timestamp(0));
		
	}

}
