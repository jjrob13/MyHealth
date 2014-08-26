package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import Control.AccountControl;
import Model.Report;
import graphGenerators.MyHealthGraphs;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class AnalysisTab  extends JPanel implements ActionListener
{
	private JPanel GraphicsPanel;
	private MyHealthGraphs graphHolder, reportGraphHelper;
	private String timeFrameChoice;
	private String attributeChoice;
	private Report activityReport;
	private JLabel lblSelectCategory;
	
	public AnalysisTab(final AccountControl account) 
	{
		setForeground(Color.DARK_GRAY);
		setBorder(new LineBorder(new Color(34, 139, 34), 5, true));
		setBackground(Color.DARK_GRAY);
		this.setSize(615, 570);

		timeFrameChoice = "Weekly";
		attributeChoice = "Weight Loss";
		

		lblSelectCategory = new JLabel("Select Category");
		lblSelectCategory.setFont(new Font("PT Sans", Font.BOLD, 15));
		
		JLabel lblSelectTime = new JLabel("Select Timeframe");
		lblSelectTime.setFont(new Font("PT Sans", Font.BOLD, 15));
		
		String categoryList[] = {"Weight Loss", "Sleep", "Caloric Intake", "Exercise"};
		String timeFrameList[] = {"Weekly", "Monthly","Yearly", "All time"};
		
		JComboBox categoryBox = new JComboBox(categoryList);
		categoryBox.setFont(new Font("PT Sans", Font.PLAIN, 15));
		categoryBox.addActionListener(this);
		
		JComboBox timeFrameBox = new JComboBox(timeFrameList);
		timeFrameBox.setFont(new Font("PT Sans", Font.PLAIN, 15));
		timeFrameBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				JComboBox timeCallBack = (JComboBox)event.getSource();
				timeFrameChoice = (String)timeCallBack.getSelectedItem();
				updateGraph(attributeChoice, timeFrameChoice);
				
			}
			
		});

		graphHolder = new MyHealthGraphs(account);
		reportGraphHelper = new MyHealthGraphs(account);
		GraphicsPanel = new JPanel(new BorderLayout());
		GraphicsPanel.setBackground(Color.DARK_GRAY);
		GraphicsPanel.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		
		
		JButton printReportButton = new JButton("Print Report");
		printReportButton.setFont(new Font("PT Sans", Font.PLAIN, 15));
		printReportButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				activityReport = new Report(account.getUserName(), attributeChoice, getCorrectGraph(attributeChoice, timeFrameChoice));
				activityReport.printReport();														
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(161)
					.addComponent(printReportButton, GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
					.addGap(171))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(71)
							.addComponent(lblSelectCategory)
							.addPreferredGap(ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
							.addComponent(lblSelectTime))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(51)
							.addComponent(categoryBox, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
							.addComponent(timeFrameBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(82))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(66)
					.addComponent(GraphicsPanel, GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
					.addGap(66))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(17)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSelectCategory)
						.addComponent(lblSelectTime))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(categoryBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(timeFrameBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(52)
					.addComponent(GraphicsPanel, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(printReportButton)
					.addGap(31))
		);
		
		setLayout(groupLayout);
	}

	public void actionPerformed(ActionEvent event) 
	{	
		JComboBox callBack = (JComboBox)event.getSource();
		attributeChoice = (String)callBack.getSelectedItem();
		updateGraph(attributeChoice, timeFrameChoice);		
	}
	
	
	void updateGraph(String attribute, String timeFrame)
	{
		if(attribute.equals("!") || timeFrame.equals("!"))
		{
			return;
			
		}
		
		
		if(attribute.equals("Weight Loss"))
		{	
			
			if(timeFrameChoice.equals("Weekly"))
			{
				GraphicsPanel.removeAll();
				GraphicsPanel.add(graphHolder.getWeekWeightLineGraph(), BorderLayout.CENTER);
				GraphicsPanel.updateUI();
			}
			if(timeFrameChoice.equals("All time"))
			{
				GraphicsPanel.removeAll();
				GraphicsPanel.add(graphHolder.getAllTimeWeightLineGraph(), BorderLayout.CENTER);
				GraphicsPanel.updateUI();
			}
			
			if(timeFrameChoice.equals("Monthly"))
			{
				GraphicsPanel.removeAll();
				GraphicsPanel.add(graphHolder.getMonthWeightLineGraph(), BorderLayout.CENTER);
				GraphicsPanel.updateUI();	
			}
			
			if(timeFrameChoice.equals("Yearly"))
			{
				GraphicsPanel.removeAll();
				GraphicsPanel.add(graphHolder.getYearWeightLineGraph(), BorderLayout.CENTER);
				GraphicsPanel.updateUI();
			}	
			
		}
			
		if(attribute.equals("Sleep"))
		{	
			
			if(timeFrameChoice.equals("Weekly"))
			{
				GraphicsPanel.removeAll();
				GraphicsPanel.add(graphHolder.getWeekSleepLineGraph(), BorderLayout.CENTER);
				GraphicsPanel.updateUI();
			}
			if(timeFrameChoice.equals("All time"))
			{
				GraphicsPanel.removeAll();
				GraphicsPanel.add(graphHolder.getAllTimeSleepLineGraph(), BorderLayout.CENTER);
				GraphicsPanel.updateUI();
			}
			
			if(timeFrameChoice.equals("Monthly"))
			{
				GraphicsPanel.removeAll();
				GraphicsPanel.add(graphHolder.getMonthSleepLineGraph(), BorderLayout.CENTER);
				GraphicsPanel.updateUI();	
			}
			
			if(timeFrameChoice.equals("Yearly"))
			{
				GraphicsPanel.removeAll();
				GraphicsPanel.add(graphHolder.getYearSleepLineGraph(), BorderLayout.CENTER);
				GraphicsPanel.updateUI();
			}	
			
		}
		
		
		if(attribute.equals("Caloric Intake"))
		{	
			
			if(timeFrameChoice.equals("Weekly"))
			{
				GraphicsPanel.removeAll();
				GraphicsPanel.add(graphHolder.getWeekCalorieLineGraph(), BorderLayout.CENTER);
				GraphicsPanel.updateUI();
			}
			if(timeFrameChoice.equals("All time"))
			{
				GraphicsPanel.removeAll();
				GraphicsPanel.add(graphHolder.getAllTimeCalorieLineGraph(), BorderLayout.CENTER);
				GraphicsPanel.updateUI();
			}
			
			if(timeFrameChoice.equals("Monthly"))
			{
				GraphicsPanel.removeAll();
				GraphicsPanel.add(graphHolder.getMonthCalorieLineGraph(), BorderLayout.CENTER);
				GraphicsPanel.updateUI();	
			}
			
			if(timeFrameChoice.equals("Yearly"))
			{
				GraphicsPanel.removeAll();
				GraphicsPanel.add(graphHolder.getYearCalorieLineGraph(), BorderLayout.CENTER);
				GraphicsPanel.updateUI();
			}	
			
		}
		
		if(attribute.equals("Exercise"))
		{	
			if(timeFrameChoice.equals("Weekly"))
			{
				GraphicsPanel.removeAll();
				GraphicsPanel.add(graphHolder.getWeekExerciseLineGraph(), BorderLayout.CENTER);
				GraphicsPanel.updateUI();
			}
			if(timeFrameChoice.equals("All time"))
			{
				GraphicsPanel.removeAll();
				GraphicsPanel.add(graphHolder.getAllTimeExerciseLineGraph(), BorderLayout.CENTER);
				GraphicsPanel.updateUI();
			}
			
			if(timeFrameChoice.equals("Monthly"))
			{
				GraphicsPanel.removeAll();
				GraphicsPanel.add(graphHolder.getMonthExerciseLineGraph(), BorderLayout.CENTER);
				GraphicsPanel.updateUI();	
			}
			
			if(timeFrameChoice.equals("Yearly"))
			{
				GraphicsPanel.removeAll();
				GraphicsPanel.add(graphHolder.getYearExerciseLineGraph(), BorderLayout.CENTER);
				GraphicsPanel.updateUI();
			}	
			
		}
		
		
	}
	
	public JPanel getCorrectGraph(String attribute, String timeFrame)
	{
		
		JPanel result = new JPanel(); //reportGraphHelper.getWeekWeightLineGraph();
		if(attribute.equals("!") || timeFrame.equals("!"))
		{
			//result = null;
			
		}
		
		
		if(attribute.equals("Weight Loss"))
		{	
			
			if(timeFrameChoice.equals("Weekly"))
			{
				result = reportGraphHelper.getWeekWeightLineGraph();
			}
			if(timeFrameChoice.equals("All time"))
			{
				result = reportGraphHelper.getAllTimeWeightLineGraph();
			}
			
			if(timeFrameChoice.equals("Monthly"))
			{
				result = reportGraphHelper.getMonthWeightLineGraph();	
			}
			
			if(timeFrameChoice.equals("Yearly"))
			{
				result = reportGraphHelper.getYearWeightLineGraph();
			}	
			
		}
			
		if(attribute.equals("Sleep"))
		{	
			
			if(timeFrameChoice.equals("Weekly"))
			{
				result = reportGraphHelper.getWeekSleepLineGraph();
			}
			if(timeFrameChoice.equals("All time"))
			{
				result = reportGraphHelper.getAllTimeSleepLineGraph();
			}
			
			if(timeFrameChoice.equals("Monthly"))
			{
				result = reportGraphHelper.getMonthSleepLineGraph();
			}
			
			if(timeFrameChoice.equals("Yearly"))
			{
				result = reportGraphHelper.getYearSleepLineGraph();
			}	
			
		}
		
		
		if(attribute.equals("Caloric Intake"))
		{	
			
			if(timeFrameChoice.equals("Weekly"))
			{
				result = reportGraphHelper.getWeekCalorieLineGraph();
			}
			if(timeFrameChoice.equals("All time"))
			{
				result = reportGraphHelper.getAllTimeCalorieLineGraph();
			}
			
			if(timeFrameChoice.equals("Monthly"))
			{
				result = reportGraphHelper.getMonthCalorieLineGraph();	
			}
			
			if(timeFrameChoice.equals("Yearly"))
			{
				result = reportGraphHelper.getYearCalorieLineGraph();
			}	
			
		}
		
		if(attribute.equals("Exercise"))
		{	
			if(timeFrameChoice.equals("Weekly"))
			{
				result = reportGraphHelper.getWeekExerciseLineGraph();
			}
			if(timeFrameChoice.equals("All time"))
			{
				result = reportGraphHelper.getAllTimeExerciseLineGraph();
			}
			
			if(timeFrameChoice.equals("Monthly"))
			{
				result = reportGraphHelper.getMonthExerciseLineGraph();
			}
			
			if(timeFrameChoice.equals("Yearly"))
			{
				result = reportGraphHelper.getYearExerciseLineGraph();
			}	
			
		}
		
		return result;
	}
	
	
}
