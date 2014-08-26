package GUI;

import graphGenerators.MyHealthGraphs;

import javax.swing.*;

import Control.AccountControl;
import Model.Report;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;

public class ComparisonsTab extends JPanel implements ActionListener {
	private JPanel graphPanel;
	private MyHealthGraphs graphs, reportGraphHelper;
	private JComboBox comboBox;
	private JButton printButton;
	private Report report;
	private String choice;
	
	
	public ComparisonsTab(final AccountControl control)
	{
		setBorder(new LineBorder(new Color(255, 200, 0), 5, true));
		setBackground(Color.DARK_GRAY);	
		this.setSize(600, 510);
		
		JLabel StatsLabel = new JLabel("See how your recent stats match up!");
		StatsLabel.setFont(new Font("PT Sans", Font.BOLD, 15));
		String list [] = {"----------","Weight","Sleep","Caloric Intake", "Weekly Exercise", "BMI"};
		
		comboBox = new JComboBox(list);
		comboBox.setFont(new Font("PT Sans", Font.PLAIN, 15));
		comboBox.addActionListener(this);
		reportGraphHelper = new MyHealthGraphs(control);
		
		
		printButton = new JButton("Print");
		printButton.setFont(new Font("PT Sans", Font.PLAIN, 15));
		printButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				//change graphPanel to getCorrectGraph()
				report = new Report(control.getUserName(), choice, correctGraph());
				report.printReport();
			}
		});
		
		graphPanel = new JPanel(new BorderLayout());
		graphPanel.setForeground(Color.DARK_GRAY);
		graphPanel.setBorder(new LineBorder(Color.DARK_GRAY, 0));
		graphPanel.setBackground(Color.DARK_GRAY);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(186)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(StatsLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(comboBox, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(printButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(16)
							.addComponent(graphPanel, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(StatsLabel)
					.addGap(18)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(printButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(graphPanel, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		//Created the 3 panels, will probably need more	
		graphs = new MyHealthGraphs(control);
		
		//graphPanel.add(graphs.getWeightBarGraph(), BorderLayout.CENTER);
		this.add(graphPanel);
	
		
	}
	
	
	public void actionPerformed(ActionEvent event) //This is the action listener for the combobox which should change the text depending on their choice
	{
		
		JComboBox callBack = (JComboBox)event.getSource();
		choice = (String)callBack.getSelectedItem();
		
			if(choice.equals("Weight"))
			{	
				graphPanel.removeAll();
				graphPanel.add(graphs.getWeightBarGraph());
				graphPanel.updateUI();
			}
			if(choice.equals("Sleep"))
			{	
				graphPanel.removeAll();
				graphPanel.add(graphs.getSleepBarGraph());
				graphPanel.updateUI();
			}
			if(choice.equals("Caloric Intake"))
			{	graphPanel.removeAll();
				graphPanel.add(graphs.getCalorieBarGraph());
				graphPanel.updateUI();
			}
			if(choice.equals("Weekly Exercise"))
			{	graphPanel.removeAll();
				graphPanel.add(graphs.getExerciseBarGraph());
				graphPanel.updateUI();
			}
			if(choice.equals("BMI")) 
			{
				graphPanel.removeAll();
				graphPanel.add(graphs.getBMIBarGraph());
				graphPanel.updateUI();
			}
		
			
		}
		
	
	public JPanel correctGraph()
	
	{
		JPanel correctGraph = new JPanel();
		
		if(choice.equals("Weight"))
		{	
			correctGraph = reportGraphHelper.getWeightBarGraph();
		}
		if(choice.equals("Sleep"))
		{	correctGraph = reportGraphHelper.getSleepBarGraph();
		}
		if(choice.equals("Caloric Intake"))
		{	correctGraph = reportGraphHelper.getCalorieBarGraph();
		}
		if(choice.equals("Weekly Exercise"))
		{	correctGraph = reportGraphHelper.getExerciseBarGraph();
		}
		if(choice.equals("BMI"))
		{
			correctGraph = reportGraphHelper.getBMIBarGraph();
		}
		
		
		
		return correctGraph;
		
		
	}
	
	
	
	
	
	
}
