package GUI;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.border.EtchedBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import Control.AccountControl;
import Model.MeasurementType;

import javax.swing.SwingConstants;

import java.awt.Component;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.util.Calendar;
import javax.swing.border.LineBorder;
public class AccountTab extends JPanel implements ActionListener
{
	private Calendar cal;
	
	private JTextField heightField;
	private JTextField emailField;
	
	private JButton heightChangeButton;
	private JButton newBirthdayButton;
	private JButton newEmailButton;
	private JButton firstNameButton;
	private JButton lastNameButton;
	private JButton updateButton;
	private JButton goalWeightButton;
	
	private String localFirstName;
	private String localLastName;
	private String localHeight;
	private String localWeight;
	private String localEmail; 
	
	private JLabel heightLabel;
	private JLabel birthdayLabel;
	private JLabel emailLabel;
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel userHeight;
	private JLabel userFirstName;
	private JLabel userLastName;
	private JLabel userBirthday;
	private JLabel userEmail;
	private JLabel topLabel;
	private JLabel goalWeight;
	private JLabel userGoalWeight;
	
	private JTextField lastNameField;
	private JTextField firstNameField;
	private JTextField goalWeightField;
	
	private JComboBox yearBox;
	private JComboBox monthBox;
	private JComboBox dayBox;
	
	private int yearIndex;
	
	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	private AccountControl control;
	AccountTab(final AccountControl control)
	{
		this.control = control;
		setBorder(new LineBorder(new Color(255, 255, 102), 4, true));
		setBackground(Color.DARK_GRAY);
		this.setSize(615,570);
		
		cal = Calendar.getInstance();
		cal.setTime(control.getProfile().getModel().getBirthday());
		
		topLabel = new JLabel(control.getUserName() + "'s Account");
		topLabel.setFont(new Font("PT Sans", Font.BOLD, 20));
		
		heightLabel = new JLabel("Height");
		heightLabel.setFont(new Font("PT Sans", Font.BOLD, 17));
		
		birthdayLabel = new JLabel("Birthday");
		birthdayLabel.setFont(new Font("PT Sans", Font.BOLD, 17));
		
		emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("PT Sans", Font.BOLD, 17));
		
		firstNameLabel = new JLabel("First Name");
		firstNameLabel.setFont(new Font("PT Sans", Font.BOLD, 17));
		
		lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setFont(new Font("PT Sans", Font.BOLD, 17));
		
		userHeight = new JLabel(Double.toString(control.getAccountProfileControl().getModel().getHeightInches()));
		userHeight.setFont(new Font("PT Sans", Font.ITALIC, 15));
		
		userBirthday = new JLabel(dateFormat.format(control.getAccountProfileControl().getModel().getBirthday()));
		userBirthday.setFont(new Font("PT Sans", Font.ITALIC, 15));
		
		userEmail = new JLabel(control.getAccountProfileControl().getEmail());
		userEmail.setFont(new Font("PT Sans", Font.ITALIC, 15));
		
		userLastName = new JLabel(control.getAccountProfileControl().getLastName());
		userLastName.setFont(new Font("PT Sans", Font.ITALIC, 15));
		
		goalWeight = new JLabel("Goal Weight");
		goalWeight.setFont(new Font("PT Sans", Font.BOLD, 17));
		
		userFirstName = new JLabel(control.getAccountProfileControl().getFirstName());
		userFirstName.setFont(new Font("PT Sans", Font.ITALIC, 15));
		
		userGoalWeight = new JLabel(Double.toString(control.getAccountProfileControl().getModel().getGoalWeight()));
		userGoalWeight.setFont(new Font("PT Sans", Font.ITALIC, 15));
		
		lastNameField = new JTextField();
		lastNameField.setFont(new Font("PT Sans", Font.PLAIN, 13));
		lastNameField.setVisible(false);
		lastNameField.setColumns(10);
		
		firstNameField = new JTextField();
		firstNameField.setFont(new Font("PT Sans", Font.PLAIN, 13));
		firstNameField.setVisible(false);
		firstNameField.setColumns(10);
		
		heightField = new JTextField();
		heightField.setFont(new Font("PT Sans", Font.PLAIN, 13));
		heightField.setVisible(false);
		heightField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setFont(new Font("PT Sans", Font.PLAIN, 13));
		emailField.setVisible(false);
		emailField.setColumns(10);
		
		goalWeightField = new JTextField();
		goalWeightField.setFont(new Font("PT Sans", Font.PLAIN, 13));
		goalWeightField.setVisible(false);
		goalWeightField.setColumns(10);
		
		localFirstName = control.getAccountProfileControl().getFirstName();
		localLastName = control.getAccountProfileControl().getLastName();
		localHeight = Double.toString(control.getAccountProfileControl().getModel().getHeightInches());
		localWeight = Double.toString(control.getAccountProfileControl().getModel().getGoalWeight());
		localEmail = control.getAccountProfileControl().getEmail();
		
		firstNameButton = new JButton("Change");
		firstNameButton.setFont(new Font("PT Sans", Font.PLAIN, 13));
		firstNameButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				if(firstNameButton.getText() == "Change")
				{
					firstNameButton.setText("Set");
					firstNameField.setText(control.getAccountProfileControl().getFirstName());
					firstNameField.setVisible(true);
					firstNameField.setEnabled(true);
					//updateButton.setEnabled(false);
				}
				else
				{
					firstNameButton.setText("Change");
					localFirstName = firstNameField.getText();
					if(localFirstName.equals(""))
					{
						localFirstName = control.getAccountProfileControl().getFirstName(); //revert to old name if text entered was null
					}
					firstNameField.setEnabled(false);
				}
			}
		});
		
		lastNameButton = new JButton("Change");
		lastNameButton.setFont(new Font("PT Sans", Font.PLAIN, 13));
		lastNameButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				if(lastNameButton.getText()== "Change")
				{
					lastNameButton.setText("Set");
					lastNameField.setText(control.getAccountProfileControl().getLastName());
					lastNameField.setVisible(true);
					lastNameField.setEnabled(true);
					//updateButton.setEnabled(false);
				}
				else
				{
					lastNameButton.setText("Change");
					localLastName = lastNameField.getText();
					if(localLastName.equals(""))
					{
						localLastName = control.getAccountProfileControl().getLastName(); //revert to old name if text entered was null
					}
					lastNameField.setEnabled(false);
					
				}
			}
		});
		
		
		heightChangeButton = new JButton("Change");
		heightChangeButton.setFont(new Font("PT Sans", Font.PLAIN, 13));
		heightChangeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				if(heightChangeButton.getText() == "Change")
				{
					heightChangeButton.setText("Set");
					heightField.setText(Double.toString(control.getAccountProfileControl().getModel().getHeightInches()));
					heightField.setVisible(true);
				}
				else
				{
					heightChangeButton.setText("Change");
			
					localHeight = heightField.getText();
					if(localHeight.equals(""))
					{
						localHeight = Double.toString(control.getAccountProfileControl().getModel().getHeightInches()); 
					}
					heightField.setEnabled(false);
				}
			}
		});
		
		goalWeightButton = new JButton("Change");
		goalWeightButton.setFont(new Font("PT Sans", Font.PLAIN, 13));
		goalWeightButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				if(goalWeightButton.getText().equals("Change"))
				{
					goalWeightButton.setText("Set");
					goalWeightField.setText(Double.toString(control.getAccountProfileControl().getModel().getGoalWeight()));
					goalWeightField.setVisible(true);
					goalWeightField.setEnabled(true);
					//buttonsSecured();
				}
				else
				{
					goalWeightButton.setText("Change");

					localWeight = goalWeightField.getText();
					if(localWeight.equals(""))
					{
						localHeight = Double.toString(control.getAccountProfileControl().getModel().getGoalWeight()); 
					}
					goalWeightField.setEnabled(false);
				}
			}
		});
		
		monthBox = new JComboBox();
		monthBox.setFont(new Font("PT Sans", Font.PLAIN, 13));
		monthBox.setVisible(false);
		monthBox.addItem("Month");
		
		for(int i = 1; i <= 12; i++)
		{
			monthBox.addItem(i);
		}
		
		dayBox = new JComboBox();
		dayBox.setFont(new Font("PT Sans", Font.PLAIN, 13));
		dayBox.setVisible(false);
		dayBox.addItem("Day");
		for(int i = 1; i <= 31; i++)
		{
			dayBox.addItem(i);
		}
		
		yearBox = new JComboBox();
		yearBox.setFont(new Font("PT Sans", Font.PLAIN, 13));
		yearBox.setVisible(false);
		yearBox.addItem("Year");
		
		for(int i = Calendar.getInstance().get(Calendar.YEAR); i >= 1900; i--)
		{
				yearBox.addItem(i);
		}
		setBirthdayComboBoxIndices();
		
		newBirthdayButton = new JButton("Change");
		newBirthdayButton.setFont(new Font("PT Sans", Font.PLAIN, 13));
		newBirthdayButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) 
			{
				if(newBirthdayButton.getText() == "Change")
				{
					yearIndex = 1;
					for(int i = 0; i < yearBox.getItemCount(); i++)
					{
						if(yearBox.getItemAt(i).equals(cal.get(Calendar.YEAR))){
							yearIndex = i;
							break;
						}
					}
					
					
					newBirthdayButton.setText("Set");
					setBirthdayComboBoxIndices();

					
					monthBox.setVisible(true);
					dayBox.setVisible(true);	
					yearBox.setVisible(true);
					monthBox.setEnabled(true);
					dayBox.setEnabled(true);
					yearBox.setEnabled(true);
					
					
					
				}
				else
				{
					newBirthdayButton.setText("Change");
					monthBox.setEnabled(false);
					dayBox.setEnabled(false);
					yearBox.setEnabled(false);
				}
			}
			
		});
		
		
		newEmailButton = new JButton("Change");
		newEmailButton.setFont(new Font("PT Sans", Font.PLAIN, 13));
		newEmailButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				if(newEmailButton.getText() == "Change")
				{
					newEmailButton.setText("Set");
					emailField.setText(control.getAccountProfileControl().getEmail());
					emailField.setVisible(true);
					emailField.setEnabled(true);
				}
				else
				{
					newEmailButton.setText("Change");
					localEmail = emailField.getText();
					if(localEmail.equals(""))
					{
						localLastName = control.getAccountProfileControl().getLastName(); //revert to old name if text entered was null
					}
					emailField.setEnabled(false);
					
				}
			}
		});
		 
	
		
	
		
	
		
		updateButton = new JButton("Update");
		updateButton.setFont(new Font("PT Sans", Font.PLAIN, 13));
		updateButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				control.updateAccountProfile(localFirstName, localLastName, monthBox.getSelectedIndex(), dayBox.getSelectedIndex(), (2015-yearBox.getSelectedIndex()), localEmail, Double.parseDouble(localHeight), Double.parseDouble(localWeight));
				updateView();
				
			}
		});
		


				
		
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(238, Short.MAX_VALUE)
					.addComponent(topLabel)
					.addGap(214))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(firstNameLabel)
								.addComponent(lastNameLabel)
								.addComponent(goalWeight)
								.addComponent(birthdayLabel)
								.addComponent(emailLabel))
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(17)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
												.addGap(18)
												.addComponent(userFirstName))
											.addGroup(groupLayout.createSequentialGroup()
												.addGap(17)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addComponent(userGoalWeight, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
													.addComponent(userHeight, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))))
										.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
											.addGap(18)
											.addComponent(userLastName))))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(userEmail)
										.addComponent(userBirthday, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))))
						.addComponent(heightLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(firstNameButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lastNameButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(heightChangeButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(goalWeightButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(newBirthdayButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(newEmailButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(dayBox, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
									.addGap(3)
									.addComponent(monthBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(yearBox, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
								.addComponent(firstNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lastNameField, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
							.addGap(59))
						.addComponent(emailField, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(heightField, Alignment.LEADING)
								.addComponent(goalWeightField, Alignment.LEADING))
							.addContainerGap())))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(103)
					.addComponent(updateButton, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
					.addGap(113))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(topLabel)
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(firstNameLabel)
						.addComponent(firstNameButton)
						.addComponent(userFirstName)
						.addComponent(firstNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lastNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lastNameButton)
						.addComponent(userLastName)
						.addComponent(lastNameLabel))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(heightLabel)
						.addComponent(userHeight)
						.addComponent(heightChangeButton)
						.addComponent(heightField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(goalWeight)
						.addComponent(userGoalWeight)
						.addComponent(goalWeightButton)
						.addComponent(goalWeightField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(newBirthdayButton)
						.addComponent(userBirthday)
						.addComponent(birthdayLabel)
						.addComponent(dayBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(monthBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(yearBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(emailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(emailLabel)
							.addComponent(userEmail)
							.addComponent(newEmailButton)))
					.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
					.addComponent(updateButton)
					.addGap(60))
		);
		setLayout(groupLayout);	
	}
	
	public void updateView()
	{

		userFirstName.setText(control.getProfile().getFirstName());
		userLastName.setText(control.getProfile().getLastName());
		userBirthday.setText(dateFormat.format(control.getAccountProfileControl().getModel().getBirthday()));
		userEmail.setText(control.getAccountProfileControl().getEmail());
		userHeight.setText(Double.toString(control.getAccountProfileControl().getModel().getHeightInches()));
		userGoalWeight.setText(Double.toString(control.getAccountProfileControl().getModel().getGoalWeight()));
		
		
	}
	
	private void setBirthdayComboBoxIndices()
	{
		cal.setTime(control.getProfile().getModel().getBirthday());
		monthBox.setSelectedItem(cal.get(Calendar.MONTH) + 1);
		dayBox.setSelectedItem(cal.get(Calendar.DATE));
		yearBox.setSelectedItem(cal.get(Calendar.YEAR));
	}
	@Override
	public void actionPerformed(ActionEvent event)
	{
		
	}	
}
