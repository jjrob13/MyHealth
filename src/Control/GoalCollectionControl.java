package Control;
import Communicators.GoalDataCommunicator;
import Interfaces.IDataControl;
import Model.Goal;
import View.GoalCollectionView;
import View.GoalView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoalCollectionControl implements IDataControl{
	private List<GoalControl> model;
	private GoalCollectionView view;
	private GoalDataCommunicator communicator;
	static final long DAY_IN_MS = 1000 * 60 * 60 * 24;

	public GoalCollectionControl(List<GoalControl> model,
			GoalCollectionView view, GoalDataCommunicator communicator) {
		super();
		this.model = model;
		this.view = view;
		this.communicator = communicator;
	}

	public GoalCollectionControl()
	{
		super();
		this.model = new ArrayList<GoalControl>();
		this.view = new GoalCollectionView();
		this.communicator = new GoalDataCommunicator();
	}
	
	public void addGoal(GoalControl model) {
		this.model.add(model);
	}
	
	public void deleteGoal(GoalControl model) {
		this.model.remove(model);
	}
	
	public List<GoalControl> getGoalsAfterDate(Date date)
	{
		List<GoalControl> result = new ArrayList<GoalControl>();
		
		for(GoalControl temp : model)
		{
			if(temp.getModel().getTimestamp().after(date))
			{
				result.add(temp);
			}
		}
		
		return result;
		
	}
	
	public List<GoalControl> getAllGoals()
	{
		return model;
	}
	
	public String toString()
	{
		return model.toString();
	}
	
	
	public boolean addNewGoal(int userID, String category, double amount)
	{
		boolean result = true;
		
		GoalControl newGoal = new GoalControl(
				new Goal(category, amount));
		
		
		try{
			communicator.addToDataBase(userID, newGoal);
			this.addGoal(newGoal);
		}catch(Exception e)
		{
			result = false;
		}
		
		return result;
		
	}
	
	public boolean addNewGoal(int userID, GoalControl control)
	{
		boolean result = true;
		
		try{
			//add to database and collection
			new GoalDataCommunicator().addToDataBase(userID, control);
			this.addGoal(control);
		}catch(Exception e)
		{
			result = false;
		}
		
		return result;
		
	}
	
	public List<GoalControl> getGoalsFromWeek()
	{
		return this.getGoalsAfterDate(new Date(System.currentTimeMillis() - (7 * DAY_IN_MS)));
	}

	public void updateView() {
		view.updateView(model);
		
	}
	
	public int getNumGoalsFromWeek()
	{
		return this.getGoalsFromWeek().size();
	}

	/*
	@Override
	public void updateData(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addData(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteData(Object object) {
		// TODO Auto-generated method stub
		
	}

*/
	public void retrieveFromDataBase(int userID) {
		model = communicator.retrieveFromDataBase(userID);
		
	}

	public boolean contains(Goal goal) {
		return model.contains(new GoalControl(goal, new GoalView()));
	}


}
