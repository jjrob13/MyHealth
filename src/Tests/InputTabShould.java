package Tests;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.junit.Test;

import Control.DoubleCheck;
import Control.HealthMeasurementCollectionControl;
import Control.HealthMeasurementControl;
import Control.MeasurementTypeControl;
import Model.HealthMeasurement;
import Tests.TestDoubles.HealthMeasurementsDataCommunicatorStub;
import Tests.TestDoubles.MeasurementTypeDataCommunicatorStub;
import View.AddHealthMeasurementView;
import View.AddHealthMeasurementsView;
import View.HealthMeasurementCollectionView;
public class InputTabShould {

	@Test
	public void displayMeasurementTypes()
	{

		
		List<HealthMeasurementControl> control = new ArrayList<HealthMeasurementControl>();
		
		List<MeasurementTypeControl> measurementType = new MeasurementTypeDataCommunicatorStub().retrieveFromDataBase(0);
		for (MeasurementTypeControl measurementTypeControl : measurementType) {
			HealthMeasurement model = new HealthMeasurement(measurementTypeControl.getModel(), 0.0, new Timestamp(0));
			control.add(new HealthMeasurementControl(model, new AddHealthMeasurementView()));
		} 
		
		
		HealthMeasurementCollectionView view = new AddHealthMeasurementsView();
		HealthMeasurementCollectionControl collectionControl = new HealthMeasurementCollectionControl(
				control, view, new HealthMeasurementsDataCommunicatorStub());
		
		collectionControl.updateView();
		
		JFrame frame = new JFrame("InputTab");
		frame.getContentPane().add(view);

		
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.setVisible(true);
		collectionControl.toConsole();
		assertTrue(true);		
	}
	
	@Test
	public void isDoubleFromInt()
	{
		assertTrue(DoubleCheck.stringIsDouble("20"));
	}
	
	@Test
	public void isDoubleFromDouble()
	{
		assertTrue(DoubleCheck.stringIsDouble("20.00"));
	}
	
	@Test
	public void isDoubleDoubleDot()
	{
		assertFalse(DoubleCheck.stringIsDouble("20.0.0"));
	}
	
	@Test
	public void isDoubleText()
	{
		assertFalse(DoubleCheck.stringIsDouble("Entry"));
	}
}
