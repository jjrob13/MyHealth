package graphGenerators;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import Control.AccountControl;
import Control.GoalControl;
import Control.HealthMeasurementControl;
import Model.MeasurementType;

public class GoalPanelMaker {
	private JProgressBar[] pbars;
	private final int pbarScalar = 100;
	private int numGoals;
	private List<GoalControl> goals;
	
	public GoalPanelMaker(AccountControl account){
		goals = account.getGoalCollectionControl().getGoalsFromWeek();
		numGoals = account.getGoalCollectionControl().getGoalsFromWeek().size();
		
		if(numGoals != 0){
			pbars = new JProgressBar[numGoals];
			
			for(int i = 0; i < numGoals; i++){
				pbars[i] = new JProgressBar(0, (int)Math.ceil(pbarScalar * goals.get(i).getAmount()));
				double currentValue = 0;
				List<HealthMeasurementControl> tempList = account.getHealthCollectionControl().getMeasurementsAfterDate(goals.get(i).getType(), goals.get(i).getModel().getTimestamp());
				if(tempList.size() != 0)
				{
					if(goals.get(i).getType().equals(new MeasurementType("weight")))
					{
			
						currentValue = tempList.get(0).getAmount() -
								account.getHealthCollectionControl().getCurrentWeight();
					}
					else
					{
						for(HealthMeasurementControl tempControl : tempList)
						{
							currentValue +=  tempControl.getAmount();
						}
					}
				}
				else //no entries since goal creation
				{
					currentValue = 0;
				}
				
				String label = currentValue + "/" + goals.get(i).getAmount() + " " + goals.get(i).getType().getUnits();
				pbars[i].setStringPainted(true);
				pbars[i].setString(label);
				pbars[i].setValue((int)(pbarScalar * currentValue));
			}
		}
		
	}
	
	public JPanel getProgressBarsPanel(){
		JPanel panel = null;
		
		//if there are some goals return a panel with the goals
		if(numGoals != 0){
			panel = new JPanel(new GridLayout(2*goals.size(), 1));
			for(int i = 0; i < 2*goals.size(); i++){
				if(i % 2 == 0){
					JLabel label = new JLabel(progressBarLabel(goals.get(i/2)));
					label.setHorizontalAlignment(SwingConstants.CENTER);
					panel.add(label);
				}
				else
					panel.add(pbars[i/2]);
					
			}
			
			//there are no goals
		}else{
			panel = new JPanel();
			panel.add(new JLabel("No active Goals!"));
		}
		return panel;
	}
	
	public JProgressBar[] getProgressBars(){
		return pbars;
	}
	
	private String progressBarLabel(GoalControl goal){
		double goalEndAmount = goal.getAmount();
		String category = goal.getType().getName();
		String result = "";
		if(category.toLowerCase().equals("weight")){
			result = "Lose " + goalEndAmount + " lbs";
		}else if(category.toLowerCase().equals("calories")){
			result = "Eat < " + goalEndAmount + " calories";
		}else
			result = category.substring(0, 1).toUpperCase() + category.substring(1) + " " + goalEndAmount + " hours";
		
		return result;
	}
	
	
}
