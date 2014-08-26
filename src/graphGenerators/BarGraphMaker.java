package graphGenerators;
import java.awt.Color;
import java.awt.GridLayout;
import java.sql.SQLException;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;

import Control.AccountControl;
import Model.MeasurementType;

public class BarGraphMaker {
	
	private AccountControl account;

	public BarGraphMaker(AccountControl account) {
		super();
		this.account = account;
		
	}

	public ChartPanel makeWeightBarGraph(){
		
		JFreeChart barChart = null;
		DefaultCategoryDataset dataset;
		try {
			
			dataset = new DefaultCategoryDataset();
			dataset.setValue(account.getHealthMeasurements().getCurrentWeight(), "Weight", "Your Current Weight");
			
			if(account.getProfile().getSex() == 'm')
				dataset.setValue(195.5, "Weight", "U.S. Male Avg");
			else
				dataset.setValue(166.2, "Weight", "U.S. Female Avg");
			double height = account.getAccountProfileControl().getModel().getHeightInches();
			dataset.setValue(robinsonIdealWeight(height), "Weight", "Ideal Weight");
			barChart = ChartFactory.createBarChart3D("Weight Comparison","Person", "Weight (lbs)", dataset);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return (new ChartPanel(barChart));

		
	}
	
	public ChartPanel makeBMIBarGraph(){
		JFreeChart barChart = null;
		DefaultCategoryDataset dataset;
		
		try {
			
			dataset = new DefaultCategoryDataset();
			double height = account.getAccountProfileControl().getModel().getHeightInches();
			double weight = account.getHealthMeasurements().getCurrentWeight();
			dataset.setValue(userBMI(height, weight), "BMI", "Your BMI");
			
			if(account.getProfile().getSex() == 'm')
				dataset.setValue(28.6, "BMI", "U.S. Male Avg");
			else
				dataset.setValue(28.7, "BMI", "U.S. Female Avg");
				
			dataset.setValue(18.5, "BMI", "Healthy Lower Bound");
			dataset.setValue(24.9, "BMI", "Healthy Upper Bound");
			barChart = ChartFactory.createBarChart3D("BMI Comparison","Person", "BMI", dataset);
			
			//change bar color
			CategoryPlot plot = (CategoryPlot) barChart.getPlot();
			plot.getRenderer().setSeriesPaint(0, Color.CYAN);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return (new ChartPanel(barChart));
	}
	
	
	public ChartPanel makeCalorieBarGraph(){
			
			
			JFreeChart barChart = null;
			DefaultCategoryDataset dataset;
			try {
				
				dataset = new DefaultCategoryDataset();
				dataset.setValue(account.getHealthMeasurements().getAverageOfLastWeek(new MeasurementType("calories")), "Calories", "Last Week's Avg Caloric Intake");
				
				if(account.getProfile().getSex() == 'm')
					dataset.setValue(2618, "Calories", "U.S. Male Avg");
				else
					dataset.setValue(1800, "Calories", "U.S. Female Avg");
					
				dataset.setValue(2000, "Calories", "Ideal Diet");
				barChart = ChartFactory.createBarChart3D("Daily Calorie Intake Comparison","Person", "Calories", dataset);
				//change bar color
				CategoryPlot plot = (CategoryPlot) barChart.getPlot();
				plot.getRenderer().setSeriesPaint(0, Color.GREEN);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			return (new ChartPanel(barChart));
	
			
		}
	
	public ChartPanel makeSleepBarGraph(){
		
		
		JFreeChart barChart = null;
		DefaultCategoryDataset dataset;
		try {
			
			dataset = new DefaultCategoryDataset();
			dataset.setValue(account.getHealthMeasurements().getAverageOfLastWeek(new MeasurementType("sleep")), "Sleep", "Your Avg Sleep Last Week");
			
			//US Average
			dataset.setValue(6.7, "Sleep", "U.S. Avg (Weekday)");
				
			dataset.setValue(8, "Sleep", "Min Ideal Nightly Sleep");
			
			barChart = ChartFactory.createBarChart3D("Nightly Sleep Comparison","Person", "Sleep (hours)", dataset);
			//change bar color
			CategoryPlot plot = (CategoryPlot) barChart.getPlot();
			plot.getRenderer().setSeriesPaint(0, Color.ORANGE);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return (new ChartPanel(barChart));

		
	}
	
	public ChartPanel makeExerciseBarGraph(){
		
		
		JFreeChart barChart = null;
		DefaultCategoryDataset dataset;
		try {
			
			dataset = new DefaultCategoryDataset();
			dataset.setValue(account.getHealthMeasurements().getSumFromLastWeek(new MeasurementType("exercise")), "Exercise", "Last Week's Exercise");
			
			//US Average
			dataset.setValue(2, "Exercise", "U.S. Avg");
				
			dataset.setValue(5, "Exercise", "Min Weekly Exercise");
			
			barChart = ChartFactory.createBarChart3D("Weekly Exercise Comparison","Person", "Exercise (hours)", dataset);
			//change bar color
			CategoryPlot plot = (CategoryPlot) barChart.getPlot();
			plot.getRenderer().setSeriesPaint(0, Color.PINK);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		return (new ChartPanel(barChart));

		
	}
	//helper methods
	
	private double userBMI(double height, double weight){
		return (double)Math.round(((weight / (height*height)) * 703)*100)/100;
	}
	
	private double robinsonIdealWeight(double height){
		double result = 0;
		if(account.getProfile().getSex() == 'm'){
			if(height >= 60){
				result += (height - 60)*4.18878;
			}
			
			result += 114.64;
		}else{
			if(height >= 5 * 12){
				result += (height-60) * 3.74786;
			}
			
			result += 108.027;
		}
		return result;
	}
	
	public JPanel getAllGraphs()
	{
		JPanel result = new JPanel();
		result.setLayout(new GridLayout(3,2));
		result.add(makeWeightBarGraph());
		result.add(makeCalorieBarGraph());
		result.add(makeExerciseBarGraph());
		result.add(makeSleepBarGraph());
		result.add(makeBMIBarGraph());
		
		return result;
	}
}