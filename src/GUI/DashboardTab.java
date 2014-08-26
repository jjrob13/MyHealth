package GUI;

import graphGenerators.MyHealthGraphs;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Control.AccountControl;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Color;

import javax.swing.border.LineBorder;
import java.awt.Font;

public class DashboardTab extends JPanel
	{
		private JPanel WeeklyGoalPanel, extraPanel;
		private JLabel FriendlyReminderLabel;
		private JLabel LoginEntryLabel;
		private JLabel CurrentWeightLabel;
		private JLabel GoalWeightLabel;
		private JLabel LastWeeksGoalLabel;
		private JLabel WeeklyGoalOverviewLabel;
		private MyHealthGraphs progressBars;
		
		private int Xdays;
		private int Ylbs;
		private int	Xlbs;
		private double Xacheived;
		private AccountControl account;
		private JPanel progressBarPanel;
		
		public DashboardTab(AccountControl account)
		{
			progressBars = new MyHealthGraphs(account);
			setBorder(new LineBorder(new Color(204, 255, 0), 4, true));
			setBackground(Color.DARK_GRAY);
			this.setSize(615, 570);
			this.account = account;
			FriendlyReminderLabel = new JLabel("Hello, " + account.getAccountProfileControl().getFirstName() + ", Don't forget to do your daily log!");
			FriendlyReminderLabel.setFont(new Font("PT Sans", Font.BOLD, 17));
			LoginEntryLabel = new JLabel("Your last log entry was " + account.getHealthCollectionControl().getLastEntryDate());
			LoginEntryLabel.setFont(new Font("PT Sans", Font.PLAIN, 16));
			CurrentWeightLabel = new JLabel ("Current Weight: " + account.getHealthCollectionControl().getCurrentWeight());
			CurrentWeightLabel.setFont(new Font("PT Sans", Font.PLAIN, 16));
			GoalWeightLabel = new JLabel("Goal Weight: " + account.getAccountProfileControl().getModel().getGoalWeight());
			GoalWeightLabel.setFont(new Font("PT Sans", Font.PLAIN, 16));
			LastWeeksGoalLabel = new JLabel("This week's goal summary: " + account.getGoalCollectionControl().getNumGoalsFromWeek() + " Active Goals");
			LastWeeksGoalLabel.setFont(new Font("PT Sans", Font.PLAIN, 16));
			
			progressBarPanel = new JPanel(new BorderLayout());
			progressBarPanel.setBorder(new LineBorder(new Color(204, 255, 0), 2, true));
			progressBarPanel.setBackground(Color.DARK_GRAY);
			progressBarPanel.add(progressBars.getGoalPanels(), BorderLayout.CENTER);
			
			GroupLayout groupLayout = new GroupLayout(this);
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
					.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
						.addGap(123)
						.addComponent(FriendlyReminderLabel)
						.addContainerGap(116, Short.MAX_VALUE))
					.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
						.addGap(164)
						.addComponent(LastWeeksGoalLabel)
						.addContainerGap(158, Short.MAX_VALUE))
					.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
						.addGap(71)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(LoginEntryLabel, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(CurrentWeightLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
									.addGap(87)
									.addComponent(GoalWeightLabel, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)))
							.addComponent(progressBarPanel, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(108, Short.MAX_VALUE))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(31)
						.addComponent(FriendlyReminderLabel)
						.addGap(80)
						.addComponent(LoginEntryLabel)
						.addGap(45)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(CurrentWeightLabel)
							.addComponent(GoalWeightLabel))
						.addGap(53)
						.addComponent(LastWeeksGoalLabel)
						.addGap(18)
						.addComponent(progressBarPanel, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(59, Short.MAX_VALUE))
			);
			setLayout(groupLayout);
			
			/*
			progressBars = new MyHealthGraphs(account);
			extraPanel = new JPanel(new GridLayout(6,1));
			extraPanel.add(FriendlyReminderLabel);
			extraPanel.add(LoginEntryLabel);
			extraPanel.add(CurrentWeightLabel);
			extraPanel.add(GoalWeightLabel);
			extraPanel.add(LastWeeksGoalLabel);
			extraPanel.add(progressBars.getGoalPanels());
			*/
			
		}

		public void refresh() {
			LoginEntryLabel.setText("Your last log entry was " + account.getHealthCollectionControl().getLastEntryDate());
			CurrentWeightLabel.setText("Current Weight: " + account.getHealthCollectionControl().getCurrentWeight());
			GoalWeightLabel.setText("Goal Weight: " + account.getAccountProfileControl().getModel().getGoalWeight());
			LastWeeksGoalLabel.setText("This week's goal summary: " + account.getGoalCollectionControl().getNumGoalsFromWeek() + " Active Goals");
			
			//Update Progress Bars
			progressBarPanel.removeAll();
			progressBarPanel.add(new MyHealthGraphs(account).getGoalPanels());
		}
	}