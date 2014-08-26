package graphGenerators;

import java.awt.Color;
import java.util.Date;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import Communicators.GeneralDataCommunicator;
import Control.AccountControl;
import Model.MeasurementType;

import javax.swing.JLabel;;

public class LineGraphMaker{
	private AccountControl control;
	private static final long DAY_IN_MS = 1000 * 60 * 60 * 24;

	public LineGraphMaker(AccountControl control) {
		super();
		this.control = control;
	}
	
	//Create line graph with a given category, timeframe, and userID (from SQL database)
	public JPanel makeLineGraph(MeasurementType type, String timeframe, Color lineColor){
		
		String query = "Select timestamp,amount from Measurements where user_id = " + control.getUserID() + " and type_id = " + type.getTypeID();
		JFreeChart chart = null;
		JPanel result = null;
		if(!timeframe.toLowerCase().equals("all time")){
			query += " and timestamp >= NOW() - INTERVAL 1 " + timeframe.toUpperCase();
		}
		query  += " order by timestamp asc";

		try {
			JDBCCategoryDataset dataset = new JDBCCategoryDataset(GeneralDataCommunicator.getConnection(), query);
			
			//create the chart
			chart = ChartFactory.createLineChart(timeframe.toUpperCase() + " " + type.getName().toUpperCase(), "Date", fixSQLCategory(type.getName()), dataset);
			
			CategoryPlot plot = (CategoryPlot) chart.getPlot();
			plot.getRenderer().setSeriesPaint(0, lineColor);
			//change chart properties based on category
			if(type.equals(new MeasurementType("weight")))
			{
				chart.getCategoryPlot().getRangeAxis().setRange(
						control.getHealthMeasurements().getMinValueAfterDate(
								type, getCorrectDate(timeframe))-10,
								control.getHealthMeasurements().getMaxValueAfterDate(type, getCorrectDate(timeframe))+20);

			}
			result = new ChartPanel(chart);
			
			
			//If the dataset is empty, then the graph was not generated properly and the badDataPanel should be returned
			if(dataset.getRowKeys().isEmpty())
				result = badDataPanel();
		} catch (Exception e) {
			//if there is not enough data or something is wrong, return JPanel with label
			result = badDataPanel();
		}
		
		return result;
	}
	
	
	//Allows user to set range of y-value
	public JPanel makeLineGraph(String category, String timeframe, double min, double max, Color lineColor){
		//Create SQL query
		String query = "Select entered," + category + " from " + fixSQLCategory(category) + " where user_id = " + control.getUserID();
		
		//result variables
		JFreeChart chart = null;
		JPanel result = null;
		
		//append timeframe to sql query
		if(!timeframe.toLowerCase().equals("all time")){
			query += " and entered >= NOW() - INTERVAL 1 " + timeframe.toUpperCase();
		}
		query  += " order by entered asc";
		
		try {
			JDBCCategoryDataset dataset = new JDBCCategoryDataset(GeneralDataCommunicator.getConnection(), query);
			
			//create the chart
			chart = ChartFactory.createLineChart(timeframe.toUpperCase() + " " + category.toUpperCase(), "Date", fixSQLCategory(category), dataset);
			
			
			//change chart properties based on category
			CategoryPlot plot = (CategoryPlot) chart.getPlot();
			plot.getRenderer().setSeriesPaint(0, lineColor);

			result = new ChartPanel(chart);
			
			//If the dataset is empty, then the graph was not generated properly and the badDataPanel should be returned
			if(dataset.getRowKeys().isEmpty())
				result = badDataPanel();
		} catch (Exception e) {
			//else return error panel
			result = badDataPanel();
		}
		
		return result;
	}
	
	private static String fixSQLCategory(String category){
		return (category.substring(0, 1).toUpperCase() + category.substring(1).toLowerCase());
	}
	
	private JPanel badDataPanel(){
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Not enough data to generate graph!");
		label.setForeground(Color.RED);
		panel.add(label);
		return panel;
	}
	
	private Date getCorrectDate(String timeframe)
	{
		Date result;
		if(timeframe.toLowerCase().equals("week"))
		{
			result = new Date(System.currentTimeMillis() - (7 * DAY_IN_MS));
		} else 
			if(timeframe.toLowerCase().equals("month"))
			{
				result = new Date(System.currentTimeMillis() - (30 * DAY_IN_MS));
			}else 
				if(timeframe.toLowerCase().equals("year"))
				{
					result = new Date(System.currentTimeMillis() - (365 * DAY_IN_MS));
				}
				else{
					result = new Date(0);
				}
		
		return result;
	}
	
}

	
