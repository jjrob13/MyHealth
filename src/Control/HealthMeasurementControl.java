package Control;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.regex.Pattern;

import Interfaces.IDataControl;
import Model.HealthMeasurement;
import Model.MeasurementType;
import View.HealthMeasurementView;

public class HealthMeasurementControl implements IDataControl {
	private HealthMeasurement model;
	private HealthMeasurementView view;
	private ActionListener actionListener;
	
	public HealthMeasurementControl(HealthMeasurement model,
			HealthMeasurementView view) {
		super();
		this.model = model;
		this.view = view;
	}
	
	public boolean validateViewAmount() {
		if(!DoubleCheck.stringIsDouble(view.getTextField().getText())){
			view.getErrorLabel().setText("This amount needs to be a number");
			view.getErrorLabel().setForeground(Color.RED);
			return false;
		}
		if(view.getAmount() < model.getType().getMin()){
			view.getErrorLabel().setText("Number needs to be Larger than " + model.getType().getMin());
			view.getErrorLabel().setForeground(Color.RED);
			return false;
		}
		if(view.getAmount() > model.getType().getMax()){
			view.getErrorLabel().setText("Number needs to be Samller than " + model.getType().getMax());
			view.getErrorLabel().setForeground(Color.RED);
			return false;
		}
		else{
			view.getErrorLabel().setText("Valid");
			view.getErrorLabel().setForeground(Color.BLACK);
			return true;
		}
	}
	
	public HealthMeasurementControl(HealthMeasurement model)
	{
		super();
		this.model = model;
		this.view = new HealthMeasurementView();
		actionListener = new ActionListener() {
			@Override
        	public void actionPerformed(ActionEvent actionEvent) {                  
                validateViewAmount(); 
            }
	      };        
	      
	      this.view.getTextField().addActionListener(actionListener);
	}
	
	public MeasurementType getType() {
		return model.getType();
	}
	public void setType(MeasurementType type) {
		model.setType(type);
	}
	public double getAmount() {
		return model.getAmount();
	}
	public void setAmount(double amount) {
		model.setAmount(amount);
	}
	public Timestamp getTimestamp() {
		return model.getTimestamp();
	}
	public void setTimestamp(Timestamp timestamp) {
		model.setTimestamp(timestamp);
	}
	
	public String toString()
	{
		return model.toString();
	}

	@Override
	public void updateView() {
		view.updateView(model);
	}

	@Override
	public void retrieveFromDataBase(int userID) {
		// TODO Auto-generated method stub
		
	}

	public Component getView() {
		return view;
	}

	public void updateModelFromView() {
		model.setAmount(view.getAmount());
	}

	public void printModel() {
		view.printModel(model);
	}
}


