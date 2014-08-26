package Tests;

import java.util.*;

import org.junit.Test;

import Control.MeasurementTypeCollectionControl;
import Control.MeasurementTypeControl;
import Model.MeasurementType;
import Tests.TestDoubles.MeasurementTypeDataCommunicatorStub;
import View.MeasurementTypeCollectionView;
import View.MeasurementTypeView;

public class MeasurementTypeShould {

	@Test
	public void measurementTypeBasic() {
		MeasurementTypeControl control = new MeasurementTypeControl(retriveMeasurementTypeFromDataBase(),new MeasurementTypeView());
		control.updateView();
	}
	
	@Test
	public void measurementTypeCollectionBasic() {
		
		MeasurementTypeCollectionControl control = new MeasurementTypeCollectionControl(
				new ArrayList<MeasurementTypeControl>(), 
				new MeasurementTypeCollectionView(),
				new MeasurementTypeDataCommunicatorStub());
		control.retrieveFromDataBase(1);
		control.updateView();
	}
	
	private static MeasurementType retriveMeasurementTypeFromDataBase(){
		return new MeasurementType("Sleep","Hours");
	}

}
