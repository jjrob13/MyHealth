package Tests.TestDoubles;

import java.util.ArrayList;
import java.util.List;

import Communicators.MeasurementTypeDataCommunicator;
import Control.MeasurementTypeControl;
import Interfaces.IDataCommunicator;
import Model.MeasurementType;
import View.MeasurementTypeView;


public class MeasurementTypeDataCommunicatorStub extends MeasurementTypeDataCommunicator implements IDataCommunicator{

	@Override
	public List<MeasurementTypeControl> retrieveFromDataBase(int userID) {
		List<MeasurementTypeControl> list = new ArrayList<MeasurementTypeControl>();
		
		list.add(new MeasurementTypeControl(new MeasurementType("Height","Inches",0.0,100.0), new MeasurementTypeView()));
		list.add(new MeasurementTypeControl(new MeasurementType("Fuel","Calorie",0.0,5000.0), new MeasurementTypeView()));
		list.add(new MeasurementTypeControl(new MeasurementType("Exercise","Minutes",0.0, 24*60.0), new MeasurementTypeView()));
		list.add(new MeasurementTypeControl(new MeasurementType("Sleep","Hours", 0.0, 24.0), new MeasurementTypeView()));
		return list;
	
	}


}
