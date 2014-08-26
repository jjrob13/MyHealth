package View;

import java.util.List;

import Control.GoalControl;


public class GoalCollectionView {
	public void printModel(List<GoalControl> model){
		   for (GoalControl temp : model) {
				temp.updateView();
			}
	   }

	public void updateView(List<GoalControl> model) {
		for (GoalControl temp : model) {
			temp.updateView();
		}
	}
}
