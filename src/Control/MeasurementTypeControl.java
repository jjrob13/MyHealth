package Control;

import Interfaces.IDataControl;
import Model.MeasurementType;
import View.MeasurementTypeView;

public class MeasurementTypeControl  implements IDataControl {
	private MeasurementType model;
	private MeasurementTypeView view;
	
	public MeasurementTypeControl(MeasurementType model,
			MeasurementTypeView view) {
		super();
		this.model = model;
		this.view = view;
	}
	
	public MeasurementTypeControl(String name)
	{
		this.model = new MeasurementType(name);
		this.view = new MeasurementTypeView();
	}
	
	public MeasurementTypeControl(String name, String units)
	{
		this.model = new MeasurementType(name, units);
		this.view = new MeasurementTypeView();
	}
	
	public String getName() {
		return model.getName();
	}

	public void setName(String name) {
		model.setName(name);
	}

	public String getUnits() {
		return model.getUnits();
	}

	public void setUnits(String units) {
		model.setUnits(units);
	}

	@Override
	public void updateView(){
		view.printModel(model);
	}
	
	public boolean equals(MeasurementTypeControl toCompare)
	{
		
		boolean result = false;
		if(toCompare.getName().equals(this.getName()))
		{
			result = true;
		}
		
		return result;
	}

			
	@Override
	public void retrieveFromDataBase(int userID) {
		// TODO Auto-generated method stub
		
	}

	public MeasurementType getModel() {
		return model;
	}

}
