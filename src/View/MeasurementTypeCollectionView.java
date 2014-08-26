package View;

import java.util.List;

import Control.MeasurementTypeControl;

public class MeasurementTypeCollectionView {	
   public void printModel(List<MeasurementTypeControl> model){
	   for (MeasurementTypeControl temp : model) {
			temp.updateView();
		}
   }
}

