package Tests.TestDoubles;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import Communicators.HealthMeasurementsDataCommunicator;
import Control.HealthMeasurementControl;
import Interfaces.IDataCommunicator;
import Model.HealthMeasurement;
import Model.MeasurementType;
import View.HealthMeasurementView;


public class HealthMeasurementsDataCommunicatorStub extends HealthMeasurementsDataCommunicator implements IDataCommunicator{

	@Override
	public List<HealthMeasurementControl> retrieveFromDataBase(int userID) {
		List<HealthMeasurementControl> list = new ArrayList<HealthMeasurementControl>();
		MeasurementType type1 = new MeasurementType("Name", "Units");
		MeasurementType type2 = new MeasurementType("Sleep", "Hours");
		list.add(new HealthMeasurementControl(new HealthMeasurement(type1, 10.0, new Timestamp(1)), new HealthMeasurementView()));
		list.add(new HealthMeasurementControl(new HealthMeasurement(type2, 30.0, new Timestamp(3)), new HealthMeasurementView()));
		list.add(new HealthMeasurementControl(new HealthMeasurement(type2, 50.0, new Timestamp(10)), new HealthMeasurementView()));
		list.add(new HealthMeasurementControl(new HealthMeasurement(type1, 80.0, new Timestamp(30)), new HealthMeasurementView()));
		
		return list;
	}

}
