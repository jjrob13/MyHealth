package graphGenerators;

import java.awt.GridLayout;

import javax.swing.JPanel;

import Control.AccountControl;

//Designed to make generation of graphs very straightforward

public class MyHealthGraphs {
	private LineGraphFactory lgFactory;
	private BarGraphMaker bgMaker;
	private GoalPanelMaker goalMaker;
	
	public MyHealthGraphs(AccountControl control){
		lgFactory = new LineGraphFactory(control);
		bgMaker = new BarGraphMaker(control);
		goalMaker = new GoalPanelMaker(control);
	}
	
	
	
	public JPanel getWeekCalorieLineGraph(){
		return lgFactory.getWeekCalorieGraph();
	}
	
	public JPanel getMonthCalorieLineGraph(){
		return lgFactory.getMonthCalorieGraph();
	}
	
	public JPanel getYearCalorieLineGraph(){
		return lgFactory.getYearCalorieGraph();
	}
	
	public JPanel getAllTimeCalorieLineGraph(){
		return lgFactory.getAllTimeCalorieGraph();
	}
	
	public JPanel getWeekExerciseLineGraph(){
		return lgFactory.getWeekExerciseGraph();
	}
	
	public JPanel getMonthExerciseLineGraph(){
		return lgFactory.getMonthExerciseGraph();
	}
	
	public JPanel getYearExerciseLineGraph(){
		return lgFactory.getYearExerciseGraph();
	}
	
	public JPanel getAllTimeExerciseLineGraph(){
		return lgFactory.getAllTimeExerciseGraph();
	}
	
	public JPanel getWeekSleepLineGraph(){
		return lgFactory.getWeekSleepGraph();
	}
	
	public JPanel getMonthSleepLineGraph(){
		return lgFactory.getMonthSleepGraph();
	}
	
	public JPanel getYearSleepLineGraph(){
		return lgFactory.getYearSleepGraph();
	}
	
	public JPanel getAllTimeSleepLineGraph(){
		return lgFactory.getAllTimeSleepGraph();
	}
	
	public JPanel getWeekWeightLineGraph(){
		return lgFactory.getWeekWeightGraph();

	}
	
	public JPanel getMonthWeightLineGraph(){
		return lgFactory.getMonthWeightGraph();

	}
	
	public JPanel getYearWeightLineGraph(){
		return lgFactory.getYearWeightGraph();

		
	}
	
	public JPanel getAllTimeWeightLineGraph(){
	
		return lgFactory.getAllTimeWeightGraph();

	}
	
	
	public JPanel getWeightBarGraph(){
		return bgMaker.makeWeightBarGraph();
	}
	
	public JPanel getBMIBarGraph(){
		return bgMaker.makeBMIBarGraph();
	}
	
	public JPanel getExerciseBarGraph(){
		return bgMaker.makeExerciseBarGraph();
	}
	
	public JPanel getSleepBarGraph(){
		return bgMaker.makeSleepBarGraph();

	}
	
	public JPanel getCalorieBarGraph(){
		return bgMaker.makeCalorieBarGraph();

	}
	
	public JPanel getGoalPanels()
	{
		return goalMaker.getProgressBarsPanel();
	}
	
	public JPanel getAllGraphs(){
		JPanel result = new JPanel();
		result.setLayout(new GridLayout(6,4));
		result.add(getWeekCalorieLineGraph());
		result.add(getMonthCalorieLineGraph());
		result.add(getYearCalorieLineGraph());
		result.add(getAllTimeCalorieLineGraph());
		result.add(getWeekSleepLineGraph());
		result.add(getMonthSleepLineGraph());
		result.add(getYearSleepLineGraph());
		result.add(getAllTimeSleepLineGraph());
		result.add(getWeekExerciseLineGraph());
		result.add(getMonthExerciseLineGraph());
		result.add(getYearExerciseLineGraph());
		result.add(getAllTimeExerciseLineGraph());
		result.add(getWeekWeightLineGraph());
		result.add(getMonthWeightLineGraph());
		result.add(getYearWeightLineGraph());
		result.add(getAllTimeWeightLineGraph());
		result.add(getWeightBarGraph());
		result.add(getSleepBarGraph());
		result.add(getExerciseBarGraph());
		result.add(getBMIBarGraph());
		result.add(getCalorieBarGraph());

		return result;

	}
	
}
