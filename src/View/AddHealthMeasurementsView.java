package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Control.HealthMeasurementControl;

import java.awt.Color;

import javax.swing.border.LineBorder;

public class AddHealthMeasurementsView extends HealthMeasurementCollectionView {
	public AddHealthMeasurementsView() {
		setBorder(new LineBorder(new Color(255, 204, 204), 4, true));
		setBackground(Color.DARK_GRAY);
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6624589147176297678L;
	private JButton submitButton = new JButton("Submit"); 
	private JLabel message = new JLabel();
	private JLabel promt = new JLabel("Please input all required information for your health log!");

	@Override
	public void updateView(List<HealthMeasurementControl> model) {
		//this.add(message);
		promt.setHorizontalAlignment(SwingConstants.CENTER);
		GridLayout grid = new GridLayout(model.size() + 2,0);
		this.add(promt);
		this.setLayout(grid);
		
		for (HealthMeasurementControl temp : model) {
			this.add(temp.getView());
			temp.updateView();
			}
		this.add(submitButton);
		}

	@Override
	public JButton getButton() {
		return submitButton;
	}

	@Override
	public void updateView(String string) {
		message.setText(string);
	}
}
