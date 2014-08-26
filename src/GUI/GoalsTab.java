package GUI;

import graphGenerators.MyHealthGraphs;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Control.AccountControl;
import Control.AuthenticationControl;
import Model.Report;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;

import java.awt.Color;

import javax.swing.border.LineBorder;

import java.awt.Font;
import java.awt.FlowLayout;

public class GoalsTab extends JPanel{
	
	private JPanel RightPanel, MainPanel;
	private JLabel CurrentGoals, NewGoal, Exercise, Calories, Pounds, tooManyGoals, wrongFormat;
	private JButton AddGoal;
	private JTextField inputGoal;
	private JComboBox selectGoal;
	private MyHealthGraphs progressBars;
	private JPanel graphPanel;
	
	
	private int numberOfGoals;
	private int exerciseGoal;
	private int caloriesGoal;
	private int weightGoal;
	private String[] goalList = {"Weight", "Sleep", "Calories", "Exercise"};
	private AccountControl account;
	
	public GoalsTab(final AccountControl account)
	{
		setBackground(Color.DARK_GRAY);
		this.account = account;
		setBorder(new LineBorder(new Color(32, 178, 170), 5, true));
		this.setSize(615,570);
		MainPanel = new JPanel(new GridLayout(1,2));
		
		graphPanel = new JPanel(new BorderLayout());
		graphPanel.setBackground(Color.DARK_GRAY);
		graphPanel.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		
		progressBars = new MyHealthGraphs(account);
		
		CurrentGoals = new JLabel("Current Goals This Week");
		CurrentGoals.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		NewGoal = new JLabel("New Weekly Goal");
		NewGoal.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		
		graphPanel.add(progressBars.getGoalPanels(), BorderLayout.CENTER);
		
		AddGoal = new JButton("Add New Goal");
		AddGoal.setFont(new Font("PT Sans", Font.PLAIN, 13));
		AddGoal.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try{
					String inputValue = inputGoal.getText();
					double testValue = Double.parseDouble(inputValue);
					wrongFormat.setVisible(false);
				if(account.getGoalCollectionControl().getNumGoalsFromWeek() < 3){
				account.getGoalCollectionControl().addNewGoal(AuthenticationControl.getUserID(), goalList[selectGoal.getSelectedIndex()].toLowerCase(), Double.parseDouble(inputGoal.getText()));
				
				//updateTab
				updateTab();
				
				//go back to dashboard
				((MyHealthRemake)(getParent().getParent())).backToDash();
				}
				else{
					tooManyGoals.setVisible(true);
				}
			}
				catch(NumberFormatException ev) {
					wrongFormat.setVisible(true);;
					}
			}
		});
		
		
		selectGoal = new JComboBox(goalList);
		selectGoal.setFont(new Font("PT Sans", Font.PLAIN, 13));
		selectGoal.setForeground(new Color(0, 0, 0));
		selectGoal.setModel(new DefaultComboBoxModel(new String[] {"Weight", "Sleep", "Caloric Intake", "Exercise"}));
		
		
		inputGoal = new JTextField(20);
		wrongFormat = new JLabel("You must enter a number.");
		wrongFormat.setFont(new Font("PT Sans", Font.PLAIN, 13));
		wrongFormat.setForeground(Color.RED);
		wrongFormat.setVisible(false);
		tooManyGoals = new JLabel("You cannot add more than 3 goals per week");
		tooManyGoals.setFont(new Font("PT Sans", Font.PLAIN, 13));
		tooManyGoals.setForeground(Color.RED);
		tooManyGoals.setVisible(false);
		
		JLabel lblPersonalGoals = new JLabel("Personal Goals");
		lblPersonalGoals.setFont(new Font("PT Sans", Font.BOLD, 25));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(graphPanel, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(selectGoal, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(inputGoal, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
								.addComponent(AddGoal, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
							.addGap(33))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(wrongFormat, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
							.addContainerGap())))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(296)
					.addComponent(tooManyGoals, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(229)
					.addComponent(lblPersonalGoals)
					.addContainerGap(315, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addComponent(lblPersonalGoals)
					.addGap(57)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(graphPanel, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(selectGoal, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(95)
							.addComponent(inputGoal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(AddGoal)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(wrongFormat)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tooManyGoals)
					.addContainerGap(196, Short.MAX_VALUE))
		);
		
		setLayout(groupLayout);
		
		
	}
	
	private void updateTab()
	{
		graphPanel.removeAll();
		graphPanel.add(new MyHealthGraphs(account).getGoalPanels());
		inputGoal.setText("");
	}
}