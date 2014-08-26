package Control;
import java.util.*;

import Communicators.MeasurementTypeDataCommunicator;
import Interfaces.IDataControl;
import View.MeasurementTypeCollectionView;

public class MeasurementTypeCollectionControl  implements IDataControl {
	private List<MeasurementTypeControl> model;
	private MeasurementTypeCollectionView view;
	private MeasurementTypeDataCommunicator communicator;
	
	public MeasurementTypeCollectionControl(List<MeasurementTypeControl> model,
			MeasurementTypeCollectionView view,
			MeasurementTypeDataCommunicator communicator) {
		super();
		this.model = model;
		this.view = view;
		this.communicator = communicator;
	}

	public void addMeasurementType(MeasurementTypeControl model) {
		this.model.add(model);
	}

	public MeasurementTypeCollectionControl()
	{
		this.view = new MeasurementTypeCollectionView();
		this.communicator = new MeasurementTypeDataCommunicator();
	}
	@Override
	public void updateView(){
		view.printModel(model);
	}

	@Override
	public void retrieveFromDataBase(int userID) {
		model = communicator.retrieveFromDataBase(userID);
	}

	public List<MeasurementTypeControl> getModel() {
		return model;
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

}
