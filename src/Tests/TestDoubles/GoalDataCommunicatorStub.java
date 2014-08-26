package Tests.TestDoubles;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import Communicators.GoalDataCommunicator;
import Control.GoalControl;
import Control.MeasurementTypeControl;
import Interfaces.IDataCommunicator;
import Model.Goal;
import View.GoalView;

public class GoalDataCommunicatorStub extends GoalDataCommunicator implements IDataCommunicator {

	@Override
	public List<GoalControl> retrieveFromDataBase(int userID) {
		List<MeasurementTypeControl> typeList = new MeasurementTypeDataCommunicatorStub().retrieveFromDataBase(0);
		List<GoalControl> list = new ArrayList<GoalControl>();
		list.add(new GoalControl(new Goal(typeList.get(0).getModel(), 20.0, new Timestamp(2132)), new GoalView()));
		list.add(new GoalControl(new Goal(typeList.get(1).getModel(), 40.0, new Timestamp(2314)), new GoalView()));
		list.add(new GoalControl(new Goal(typeList.get(2).getModel(), 70.0, new Timestamp(7332)), new GoalView()));
		list.add(new GoalControl(new Goal(typeList.get(3).getModel(), 90.0, new Timestamp(4357)), new GoalView()));
		return list;
	}



}
