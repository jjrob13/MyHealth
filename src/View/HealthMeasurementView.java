package View;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import Model.HealthMeasurement;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class HealthMeasurementView extends JPanel{
	public HealthMeasurementView() {
		setBorder(new LineBorder(null, 0));
		setBackground(Color.DARK_GRAY);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 6351883261151975219L;
	public void printModel(HealthMeasurement model){
		System.out.println(model);
	}
	public void updateView(HealthMeasurement model) {
		System.out.println(model);
	}
	
	public double getAmount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public JTextField getTextField() {
		// TODO Auto-generated method stub\
		return null;
	}
	
	public JLabel getErrorLabel() {
		// TODO Auto-generated method stub
		return null;
	}
}

