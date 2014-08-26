package Tests;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import Communicators.GoalDataCommunicator;
import Control.GoalCollectionControl;
import Control.GoalControl;
import Model.Goal;
import Model.MeasurementType;
import View.GoalCollectionView;
import View.GoalView;

public class GoalDataCommunicatorShould {
	
	@Test
	public void insertIntoDB()
	{
		List<GoalControl> model= new ArrayList<GoalControl>();
		GoalCollectionView view = new GoalCollectionView();
		GoalDataCommunicator communicator = new GoalDataCommunicator();
		Goal goal = new Goal(
						new MeasurementType("weight", "lbs"), 2, 
						new Timestamp(
								new Date().getTime()));
		GoalCollectionControl control = new GoalCollectionControl(model, view, communicator);
		control.addNewGoal(1, new GoalControl(goal, 
						new GoalView()));
		
		assertTrue(control.contains(goal));
		
	}

}
