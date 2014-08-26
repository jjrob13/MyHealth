package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Control.AccountControl;
import Control.GoalControl;
import Tests.TestDoubles.AccountControlStub;

public class GoalCollectionControlShould {

	AccountControl control = new AccountControlStub();
	
	@Test
	public void addNewGoal() {
		control.getGoalCollectionControl().addNewGoal(control.getUserID(), new GoalControl("sleep", 25));
		
	}

	
	@Test
	public void getWeekGoals()
	{
		System.out.println(control.getGoalCollectionControl().getGoalsFromWeek());
		assertFalse(control.getGoalCollectionControl().getGoalsFromWeek().isEmpty());
	}
}
