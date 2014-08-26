package View;


import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

import Model.HealthMeasurement;

public class AddHealthMeasurementView extends HealthMeasurementView {
	public AddHealthMeasurementView() {
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 5017218089226290363L;
	private JLabel name;
	private JLabel units;
	private JTextField textField;
	private JLabel errorLabel;
	
	@Override
	public JLabel getErrorLabel() {
		return errorLabel;
	}

	public void setErrorLabel(JLabel errorLabel) {
		this.errorLabel = errorLabel;
	}

	@Override
	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public double getAmount() {
		return Double.valueOf(textField.getText());
	}
	
	@Override
	public void updateView(HealthMeasurement model) {
		name = new JLabel(model.getType().getName());
		units = new JLabel(model.getType().getUnits());
		errorLabel = new JLabel();
		
		String defaultText = "Enter Amount"; 
		if(model.getAmount() > 0) defaultText = Double.toString(model.getAmount());
		textField = new JTextField(defaultText);
		textField.setColumns(10);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(
						groupLayout.createSequentialGroup()
						.addGap(48)
						.addComponent(name, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(48)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(48)
						.addComponent(units, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(48)
						.addComponent(errorLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						)
					);
	}
}
