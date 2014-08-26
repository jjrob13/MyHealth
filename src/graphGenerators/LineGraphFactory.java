package graphGenerators;

import java.awt.Color;

import javax.swing.JPanel;

import Control.AccountControl;
import Model.MeasurementType;


public class LineGraphFactory{

	LineGraphMaker lgMaker;
	AccountControl control;
	
	
	public LineGraphFactory(AccountControl control){
		lgMaker = new LineGraphMaker(control);
		this.control = control;
	}
	
	
	
	public JPanel getWeekCalorieGraph(){
		return lgMaker.makeLineGraph(new MeasurementType("calories"), "week", Color.MAGENTA);
	}
	
	public JPanel getMonthCalorieGraph(){
		return lgMaker.makeLineGraph(new MeasurementType("calories"), "month", Color.BLUE);
	}
	
	public JPanel getYearCalorieGraph(){
		return lgMaker.makeLineGraph(new MeasurementType("calories"), "year", Color.DARK_GRAY);
	}
	
	public JPanel getAllTimeCalorieGraph(){
		return lgMaker.makeLineGraph(new MeasurementType("calories"), "all time", Color.RED);
	}
	
	public JPanel getWeekExerciseGraph(){
		return lgMaker.makeLineGraph(new MeasurementType("exercise"), "week", Color.YELLOW);
	}
	
	public JPanel getMonthExerciseGraph(){
		return lgMaker.makeLineGraph(new MeasurementType("exercise"), "month", Color.MAGENTA);
	}
	
	public JPanel getYearExerciseGraph(){
		return lgMaker.makeLineGraph(new MeasurementType("exercise"), "year", Color.BLUE);
	}
	
	public JPanel getAllTimeExerciseGraph(){
		return lgMaker.makeLineGraph(new MeasurementType("exercise"), "all time", Color.BLACK);
	}
	
	public JPanel getWeekSleepGraph(){
		return lgMaker.makeLineGraph(new MeasurementType("sleep"), "week", Color.RED);
	}
	
	public JPanel getMonthSleepGraph(){
		return lgMaker.makeLineGraph(new MeasurementType("sleep"), "month", Color.ORANGE);
	}
	
	public JPanel getYearSleepGraph(){
		return lgMaker.makeLineGraph(new MeasurementType("sleep"), "year", Color.GREEN);
	}
	
	public JPanel getAllTimeSleepGraph(){
		return lgMaker.makeLineGraph(new MeasurementType("sleep"), "all time", Color.DARK_GRAY);
	}
	
	
	public JPanel getWeekWeightGraph(){

		return lgMaker.makeLineGraph(new MeasurementType("weight"), "week", Color.RED);
	}
	
	public JPanel getMonthWeightGraph(){
		
		return lgMaker.makeLineGraph(new MeasurementType("weight"), "month", Color.BLACK);	
		}
	
	public JPanel getYearWeightGraph(){
		
		return lgMaker.makeLineGraph(new MeasurementType("weight"), "year", Color.BLUE);	
		
	}
	
	public JPanel getAllTimeWeightGraph(){
	
		return lgMaker.makeLineGraph(new MeasurementType("weight"), "all time", Color.BLACK);	
		
	}
}

