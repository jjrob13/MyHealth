package Control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.*;

import Communicators.HealthMeasurementsDataCommunicator;
import GUI.MyHealthRemake;
import Interfaces.IDataControlCollection;
import Model.HealthMeasurement;
import Model.MeasurementType;
import View.HealthMeasurementCollectionView;
import View.HealthMeasurementView;

public class HealthMeasurementCollectionControl implements IDataControlCollection{
	private List<HealthMeasurementControl> model;
	private HealthMeasurementCollectionView view;
	private HealthMeasurementsDataCommunicator communicator;

	private ActionListener actionListener;
	private static final long DAY_IN_MS = 1000 * 60 * 60 * 24;

	public List<HealthMeasurementControl> getModel() {
		return model;
	}

	public void setModel(List<HealthMeasurementControl> model) {
		this.model = model;
	}

	public HealthMeasurementCollectionView getView() {
		return view;
	}

	public void setView(HealthMeasurementCollectionView view) {
		this.view = view;
	}

	public HealthMeasurementsDataCommunicator getCommunicator() {
		return communicator;
	}

	public void setCommunicator(HealthMeasurementsDataCommunicator communicator) {
		this.communicator = communicator;
	}

	public HealthMeasurementCollectionControl(
			List<HealthMeasurementControl> model,
			HealthMeasurementCollectionView view,
			HealthMeasurementsDataCommunicator communicator) {
		super();
		this.model = model;
		this.view = view;
		this.communicator = communicator;

		actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				if (vaildateAmount()) {
					addMeasurementsFromView();
					addToDatabase();
					changeViewtoDashboard();
				}
			}
		};
		this.view.getButton().addActionListener(actionListener);
	}


	private void changeViewtoDashboard() {
			MyHealthRemake myHealthRemake = (MyHealthRemake)view.getParent().getParent();
			myHealthRemake.backToDash();
	}
	
	private boolean vaildateAmount() {
		boolean vaildValues = true;
		for (HealthMeasurementControl control : model) {
			if (!control.validateViewAmount())
				vaildValues = false;
		}
		return vaildValues;
	}

	private void addToDatabase() {
		for (HealthMeasurementControl control : model) {
			if (AuthenticationControl.getUserID() < 0) {
				communicator.addToDataBase(0, control);
			} else
				communicator.addToDataBase(AuthenticationControl.getUserID(),
						control);
		}
	}

	private void addMeasurementsFromView() {
		for (HealthMeasurementControl control : model) {
			control.updateModelFromView();
		}
	}
	
	public HealthMeasurementCollectionControl()
	{
		this.model = new ArrayList<HealthMeasurementControl>();
		this.view = new HealthMeasurementCollectionView();
		this.communicator = new HealthMeasurementsDataCommunicator();
	}

	public void addHealthMeasurement(HealthMeasurementControl model) {
		this.model.add(model);
	}

	public void deleteHealthMeasurement(HealthMeasurementControl model) {
		this.model.remove(model);
	}

	public List<HealthMeasurementControl> getMeasurementsAfterDate(MeasurementType type, Date date)
	{
		List<HealthMeasurementControl> result = new ArrayList<HealthMeasurementControl>();
		for(HealthMeasurementControl temp : this.model)
		{
			if(temp.getType().equals(type) && temp.getTimestamp().after(date))
			{
				result.add(temp);
			}
		}

		return result;
	}

	public HealthMeasurementControl getCurrentMeasurement(MeasurementType type) {
		Timestamp currentTime = model.get(0).getTimestamp();

		HealthMeasurementControl currentMeasurement = model.get(0);

		for (HealthMeasurementControl measurement : model) {
			if (measurement.getType().equals(type) && measurement.getTimestamp().after(currentTime))
			{
				currentMeasurement = measurement;
			}
		}
		return currentMeasurement;
	}
	
	public double getAverageAfterDate(MeasurementType type, Date date) {
		List<HealthMeasurementControl> list = getMeasurementsAfterDate(type, date);
		
		double total = 0;
		int count = 0;
		for (HealthMeasurementControl measurement : list) {
			total += measurement.getAmount();
			count += 1;
		}

		return total / count;
	}

	public double getCurrentValue(MeasurementType type)
	{
		return getCurrentMeasurement(type).getAmount();
	}
	
	//overload to allow string as input instead of MeasurementType
	
	public double getCurrentWeight()
	{
		return getCurrentValue(new MeasurementType("weight", "lbs"));
	}

	public List<HealthMeasurementControl> getAllMeasurements()
	{
		return model;
	}

	public String toString()
	{
		return model.toString();
	}
	
	
	@Override	
	public void updateView(){
		view.updateView(model);
	}
	
	public boolean addNewMeasurement(int userID, String category, double amount)
	{
		boolean result = true;
		
		HealthMeasurementControl newMeasurement = new HealthMeasurementControl(
				new HealthMeasurement(
						new MeasurementType(category), amount, 
						new Timestamp(
								new Date().getTime())), new HealthMeasurementView());
		
		
		try{
			//add to database and collection
			communicator.addToDataBase(userID, newMeasurement);
			this.addNewHealthMeasurement(newMeasurement);
		}catch(Exception e)
		{
			result = false;
		}
		
		return result;

	}
	
	public boolean addNewMeasurement(int userID, HealthMeasurementControl control)
	{
		boolean result = true;
		
		
		try{
			//add to database and collection
			communicator.addToDataBase(userID, control);
			this.addNewHealthMeasurement(control);
		}catch(Exception e)
		{
			result = false;
		}

		return result;

	}

	public double getAverageOfLastWeek(MeasurementType type) {
		return this.getAverageAfterDate(type,
				new Date(System.currentTimeMillis() - (7 * DAY_IN_MS)));

	}

	public List<HealthMeasurementControl> getAllMeasurements(
			MeasurementType type) {
		List<HealthMeasurementControl> result = new ArrayList<HealthMeasurementControl>();

		for (HealthMeasurementControl temp : model) {
			if (temp.getType().equals(type)) {
				result.add(temp);
			}
		}

		return result;
	}

	private void addNewHealthMeasurement(HealthMeasurementControl measurement) {
		model.add(measurement);
	}

	@Override
	public void retrieveFromDataBase(int userID) {
		model = communicator.retrieveFromDataBase(userID);
	}

	public Number getAverageForPastDays(MeasurementType measurementType, int i) {
		return getAverageAfterDate(measurementType, getPastDate(i));
	}

	public Date getPastDate(int i) {
		Calendar cal = Calendar.getInstance();
		i = -1 * i;
		cal.add(Calendar.DATE, i);
		return cal.getTime();
	}

	public double getMinByPastDays(MeasurementType type, int days) {
		return getMinValueAfterDate(type, getPastDate(days));
	}

	public double getMaxByPastDays(MeasurementType type, int days) {
		return getMaxValueAfterDate(type, getPastDate(days));
	}

	public double getMinValueAfterDate(MeasurementType type, Date date) {
		double min = 99999;
		List<HealthMeasurementControl> list = getAllMeasurements(type);
		for (HealthMeasurementControl temp : list) {
			if (temp.getAmount() < min) {
				min = temp.getAmount();
			}
		}

		return min;
	}

	public double getMaxValueAfterDate(MeasurementType type, Date date) {
		double max = -999999;
		List<HealthMeasurementControl> list = getAllMeasurements(type);
		for (HealthMeasurementControl temp : list) {
			if (temp.getAmount() > max) {
				max = temp.getAmount();
			}
		}
		
		return max;
	}
	
	public List<HealthMeasurementControl> getMeasurementsFromLastWeek(MeasurementType type)
	{
		return this.getMeasurementsAfterDate(type, new Date(System.currentTimeMillis() - (7 * DAY_IN_MS)));
				
		
	}
	
	public double getSumFromLastWeek(MeasurementType type)
	{
		List<HealthMeasurementControl> list = getMeasurementsFromLastWeek(type);
		double result = 0;
		for(HealthMeasurementControl measurement : list)
		{
			result += measurement.getAmount();
		}
		
		return result;
	}

	public void toConsole() {
		view.printModel(model);
	}

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

	public Date getLastEntryDate() {
		Timestamp latestDate = new Timestamp(0);
		for (HealthMeasurementControl control : model) {
			if(latestDate.before(control.getTimestamp()))
			{
				latestDate = control.getTimestamp();
			}
				
		}
		return latestDate;
	}

}
