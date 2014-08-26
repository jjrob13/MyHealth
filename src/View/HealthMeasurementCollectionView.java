package View;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import Control.HealthMeasurementControl;

public class HealthMeasurementCollectionView extends JPanel {
	public HealthMeasurementCollectionView() {
	}
   /**
	 * 
	 */
	private static final long serialVersionUID = 3225705094566010706L;

	public void printModel(List<HealthMeasurementControl> model){
		   for (HealthMeasurementControl temp : model) {
				temp.printModel();
			}
	   }

	public void updateView(String string) {
	}
	public JButton getButton() {
		return null;
	}
	public void updateView(List<HealthMeasurementControl> model) {
	}
}


