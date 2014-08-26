package View;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;

import Control.HealthMeasurementControl;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class InputErrorView extends HealthMeasurementCollectionView {
	public InputErrorView() {
		setBackground(Color.DARK_GRAY);
		setBorder(new LineBorder(new Color(176, 224, 230), 5, true));
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4853906931837658343L;
	private JButton submitButton = new JButton("Submit"); 
	private JLabel message = new JLabel();

	@Override
	public void updateView(List<HealthMeasurementControl> model) {
		this.add(message);
		GridLayout grid = new GridLayout(model.size() + 2,0);
		this.add(new JLabel("Please input all required information for your health log!"));
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
		this.add(message);
	}
}
