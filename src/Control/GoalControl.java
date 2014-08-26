package Control;


import Interfaces.IDataControl;
import Model.Goal;
import Model.MeasurementType;
import View.GoalView;

public class GoalControl implements IDataControl {
	private Goal model;
	private GoalView view;
	

	public GoalControl(Goal model, GoalView view) {
		super();
		this.model = model;
		this.view = view;
	}

	public GoalControl(Goal model)
	{
		this.model = model;
		this.view = new GoalView();
	}
	
	public GoalControl(String category, double amount)
	{
		this.model = new Goal(category, amount);
		this.view = new GoalView();
	}
	

	public Goal getModel() {
		return model;
	}


	public void setModel(Goal model) {
		this.model = model;
	}


	public GoalView getView() {
		return view;
	}


	public void setView(GoalView view) {
		this.view = view;
	}


	@Override
	public void updateView(){
		view.printModel(model);
	}
	
	public String toString()
	{
		return model.toString();
	}

	public MeasurementType getType() {
		return model.getType();
	}
	
	public double getAmount()
	{
		return model.getAmount();
	}

	@Override
	public void retrieveFromDataBase(int userID) {
		// TODO Auto-generated method stub
		
	}
	
}
