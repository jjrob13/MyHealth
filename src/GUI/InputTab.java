package GUI;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Communicators.HealthMeasurementsDataCommunicator;
import Control.AccountControl;
import Control.HealthMeasurementCollectionControl;
import Control.HealthMeasurementControl;
import Control.MeasurementTypeControl;
import Model.HealthMeasurement;
import View.AddHealthMeasurementView;
import View.AddHealthMeasurementsView;
import View.HealthMeasurementCollectionView;
import View.InputErrorView;

public class InputTab 
{
	HealthMeasurementCollectionView view;
	public InputTab(AccountControl account)
	{
		Date dateOfLastEntry = account.getHealthCollectionControl().getLastEntryDate();
		if (isSameDay(new Date(), dateOfLastEntry))
		{
			createAlreadyEnteredTab(account);
		}
		else
		{
			createInputTab(account);
		}
	}

	private void createAlreadyEnteredTab(AccountControl account) {
		this.view = new InputErrorView();
		view.updateView("You Already Added Measurements for today");
	}

	private void createInputTab(AccountControl account) {
		List<HealthMeasurementControl> control = new ArrayList<HealthMeasurementControl>();
		
		List<MeasurementTypeControl> measurementType = account.getTypeCollectionControl().getModel();
		for (MeasurementTypeControl measurementTypeControl : measurementType) {
			HealthMeasurement model = new HealthMeasurement(measurementTypeControl.getModel(), 0.0, new Timestamp(0));
			control.add(new HealthMeasurementControl(model, new AddHealthMeasurementView()));
		}
		
		this.view = new AddHealthMeasurementsView();
		HealthMeasurementCollectionControl collectionControl = new HealthMeasurementCollectionControl(
				control, view, new HealthMeasurementsDataCommunicator());
		
		collectionControl.updateView();
	}
	
	public HealthMeasurementCollectionView getView()
	{
		return view;
	}
	
	  public int compareDate(Date d1, Date d2) {
		  Calendar c1 = Calendar.getInstance();
		  c1.setTime(d1);
		  Calendar c2 = Calendar.getInstance();
		  c2.setTime(d2);
		  
		    if (c1.get(Calendar.YEAR) != c2.get(Calendar.YEAR)) 
		        return c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR);
		    if (c1.get(Calendar.MONTH) != c2.get(Calendar.MONTH)) 
		        return c1.get(Calendar.MONTH) - c2.get(Calendar.MONTH);
		    return c1.get(Calendar.DATE) - c2.get(Calendar.DATE);
		  }
	  
	  public boolean isSameDay(Date d1, Date d2)
	  {
		  return compareDate(d1, d2) == 0;
	  }
}
