package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Communicators.GeneralDataCommunicator;
import Communicators.HealthMeasurementsDataCommunicator;
import Control.AccountControl;
import Control.HealthMeasurementControl;
import Control.VerificationController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Component;
import javax.swing.border.LineBorder;

//Needs input verification label added and gender field

public class NewAccountPanel extends JPanel implements ActionListener
{
	//new Account being made
	private AccountControl newAccount;
	
	private JPanel SuperPanel;
	private JPanel SuperPanel2;	
	private JPanel FirstPanel;
	private	JPanel SecondPanel;
	private JPanel ThirdPanel;
	private JPanel FourthPanel;
	private JPanel FifthPanel;
	private JPanel SixthPanel;
	private JPanel SeventhPanel;
	private JPanel FirstInputPanel;
	private JPanel FinalPanel;
	
	private JLabel UserPassPromt;
	private JLabel UsernameLabel;
	private JLabel PasswordLabel;
	private JLabel PasswordVerifyLabel;
	private JLabel SecurityLabel;
	private JLabel RecoveryQuestionLabel;
	private JLabel FillInfoLabel;
	private JLabel FirstNameLabel;
	private JLabel LastNameLabel;
	private JLabel EmailLabel;
	private JLabel BirthdayLabel;
	private JLabel GoalWeightLabel;
	private JLabel HeightLabel;
	private JLabel superPanel2ErrorLabel;
	private JLabel invalidInputLabel;
	private JLabel ErrorLabel2;
	
	private JTextField UsernameField;
	private JTextField RecoveryQuestionField;
	private JTextField FirstNameField;
	private JTextField LastNameField;
	private JTextField EmailField;
	private JTextField GoalWeightField;
	private JTextField HeightField;
	
	private JComboBox YearBox;
	private JComboBox MonthBox;
	private JComboBox DayBox;
	private JComboBox sexComboBox;
	
	private JPasswordField PasswordField;
	private JPasswordField VerifyField;

	private JButton NextButton;
	private JButton NextButton2;
	
	private CardLayout c;
	
	private Calendar cal;
	private JTextField firstWeightField;
	private JTextField firstCalorieField;
	private JTextField firstExerciseField;
	private JButton finishButton;
	
	//Account Variables
	private String username, password, securityQuestion, firstName, lastName, email;
	private int birthdayMonth, birthdayYear, birthdayDay;
	private double goalWeight, heightInches;
	private char sex;
	private JLabel invalidFirstInputLabel;
	private JLabel lblYourCurrentWeight;
	private JLabel lblCaloriesConsumedToday;
	private JLabel lblHoursOfExercise;
	private JTextField firstSleepField;
	private JLabel matchingPasswordsErrorLabel;
	private JLabel ErrorLabel1;
	public NewAccountPanel() //Constructor
	{
		this.setLayout(new CardLayout());
		this.setSize(615,570);
		
		
		
		SuperPanel = new JPanel();
		SuperPanel.setBorder(new LineBorder(new Color(102, 0, 0), 4, true));
		SuperPanel.setBackground(Color.DARK_GRAY);
		
	///////////////////////////////////////////////////////////////////
		SuperPanel2 = new JPanel(new GridLayout(7,1));
		SuperPanel2.setBorder(new LineBorder(new Color(153, 0, 102), 4, true));
		SuperPanel2.setBackground(Color.DARK_GRAY);
		
		FirstPanel = new JPanel();
		FirstPanel.setBorder(new LineBorder(Color.DARK_GRAY, 0));
		FirstPanel.setBackground(Color.DARK_GRAY);
		SecondPanel = new JPanel();
		SecondPanel.setBorder(new LineBorder(Color.DARK_GRAY, 0));
		SecondPanel.setBackground(Color.DARK_GRAY);
		ThirdPanel = new JPanel();
		ThirdPanel.setBorder(new LineBorder(Color.DARK_GRAY, 0));
		ThirdPanel.setBackground(Color.DARK_GRAY);
		FourthPanel = new JPanel();
		FourthPanel.setBorder(new LineBorder(Color.DARK_GRAY, 0));
		FourthPanel.setBackground(Color.DARK_GRAY);
		FifthPanel = new JPanel();
		FifthPanel.setBorder(new LineBorder(Color.DARK_GRAY, 0));
		FifthPanel.setBackground(Color.DARK_GRAY);
		SixthPanel = new JPanel();
		SixthPanel.setBorder(new LineBorder(Color.DARK_GRAY, 0));
		SixthPanel.setBackground(Color.DARK_GRAY);
		SeventhPanel = new JPanel();
		SeventhPanel.setBorder(new LineBorder(Color.DARK_GRAY, 0));
		SeventhPanel.setBackground(Color.DARK_GRAY);
		
		FillInfoLabel = new JLabel("Please fill out all required information");
		FillInfoLabel.setBackground(Color.DARK_GRAY);
		FillInfoLabel.setFont(new Font("PT Sans", Font.BOLD, 30));
		FillInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		FirstNameLabel = new JLabel("First name");
		FirstNameLabel.setFont(new Font("PT Sans", Font.PLAIN, 20));
		FirstNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		LastNameLabel = new JLabel("Last name");
		LastNameLabel.setFont(new Font("PT Sans", Font.PLAIN, 20));
		LastNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		FirstNameField = new JTextField();
		FirstNameField.setFont(new Font("PT Sans", Font.PLAIN, 15));
		LastNameField = new JTextField();
		LastNameField.setFont(new Font("PT Sans", Font.PLAIN, 15));
		EmailLabel = new JLabel("Email");
		EmailLabel.setFont(new Font("PT Sans", Font.PLAIN, 20));
		EmailField = new JTextField(20);
		EmailField.setFont(new Font("PT Sans", Font.PLAIN, 15));
		BirthdayLabel = new JLabel("Birthday");
		BirthdayLabel.setFont(new Font("PT Sans", Font.PLAIN, 20));
		DayBox = new JComboBox();
		DayBox.setFont(new Font("PT Sans", Font.PLAIN, 15));
		MonthBox = new JComboBox();
		MonthBox.setFont(new Font("PT Sans", Font.PLAIN, 15));
		YearBox = new JComboBox();
		YearBox.setFont(new Font("PT Sans", Font.PLAIN, 15));
		
		YearBox.addItem("Year");

		for(int i = Calendar.getInstance().get(Calendar.YEAR); i >= 1900; i--)
		{
			YearBox.addItem(i);
		}
		
		
		MonthBox.addItem("Month");

		for(int i = 1; i <= 12; i++)
		{
			MonthBox.addItem(i);
		}
		
		DayBox.addItem("Day");

		for(int i = 1; i <= 31; i++)
		{
			DayBox.addItem(i);
		}
		
		GoalWeightLabel = new JLabel("Goal Weight");
		GoalWeightLabel.setFont(new Font("PT Sans", Font.PLAIN, 20));
		GoalWeightField = new JTextField("lbs", 3);
		GoalWeightField.setFont(new Font("PT Sans", Font.PLAIN, 15));
		HeightLabel = new JLabel("Height");
		HeightLabel.setFont(new Font("PT Sans", Font.PLAIN, 20));
		HeightField = new JTextField("in", 3);
		HeightField.setFont(new Font("PT Sans", Font.PLAIN, 15));
		NextButton2 = new JButton("Next");
		NextButton2.setFont(new Font("PT Sans", Font.PLAIN, 15));
		NextButton2.addActionListener(this);


		
		SuperPanel2.add(FirstPanel);
		GroupLayout gl_FirstPanel = new GroupLayout(FirstPanel);
		gl_FirstPanel.setHorizontalGroup(
			gl_FirstPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_FirstPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(FillInfoLabel, GroupLayout.PREFERRED_SIZE, 615, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(10, Short.MAX_VALUE))
		);
		gl_FirstPanel.setVerticalGroup(
			gl_FirstPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_FirstPanel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(FillInfoLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		FirstPanel.setLayout(gl_FirstPanel);
		SuperPanel2.add(SecondPanel);
		GroupLayout gl_SecondPanel = new GroupLayout(SecondPanel);
		gl_SecondPanel.setHorizontalGroup(
			gl_SecondPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_SecondPanel.createSequentialGroup()
					.addComponent(FirstNameLabel, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(FirstNameField, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(LastNameLabel, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(LastNameField, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addGap(13))
		);
		gl_SecondPanel.setVerticalGroup(
			gl_SecondPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_SecondPanel.createSequentialGroup()
					.addGroup(gl_SecondPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(FirstNameLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(FirstNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(LastNameLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(LastNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		SecondPanel.setLayout(gl_SecondPanel);
		SuperPanel2.add(ThirdPanel);
		GroupLayout gl_ThirdPanel = new GroupLayout(ThirdPanel);
		gl_ThirdPanel.setHorizontalGroup(
			gl_ThirdPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ThirdPanel.createSequentialGroup()
					.addGap(145)
					.addComponent(EmailLabel)
					.addGap(18)
					.addComponent(EmailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(145, Short.MAX_VALUE))
		);
		gl_ThirdPanel.setVerticalGroup(
			gl_ThirdPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_ThirdPanel.createSequentialGroup()
					.addContainerGap(30, Short.MAX_VALUE)
					.addGroup(gl_ThirdPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(EmailLabel)
						.addComponent(EmailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22))
		);
		ThirdPanel.setLayout(gl_ThirdPanel);
		SuperPanel2.add(FourthPanel);
		GroupLayout gl_FourthPanel = new GroupLayout(FourthPanel);
		gl_FourthPanel.setHorizontalGroup(
			gl_FourthPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_FourthPanel.createSequentialGroup()
					.addGap(93)
					.addComponent(BirthdayLabel)
					.addGap(18)
					.addComponent(DayBox, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(MonthBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(YearBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(93, Short.MAX_VALUE))
		);
		gl_FourthPanel.setVerticalGroup(
			gl_FourthPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_FourthPanel.createSequentialGroup()
					.addContainerGap(27, Short.MAX_VALUE)
					.addGroup(gl_FourthPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(BirthdayLabel)
						.addComponent(DayBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(MonthBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(YearBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(23))
		);
		gl_FourthPanel.linkSize(SwingConstants.HORIZONTAL, new Component[] {DayBox, MonthBox, YearBox});
		FourthPanel.setLayout(gl_FourthPanel);
		SuperPanel2.add(FifthPanel);
		GroupLayout gl_FifthPanel = new GroupLayout(FifthPanel);
		gl_FifthPanel.setHorizontalGroup(
			gl_FifthPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_FifthPanel.createSequentialGroup()
					.addGap(202)
					.addComponent(GoalWeightLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(GoalWeightField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(237, Short.MAX_VALUE))
		);
		gl_FifthPanel.setVerticalGroup(
			gl_FifthPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_FifthPanel.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_FifthPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(GoalWeightLabel)
						.addComponent(GoalWeightField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		FifthPanel.setLayout(gl_FifthPanel);
		SuperPanel2.add(SixthPanel);
		
		sexComboBox = new JComboBox();
		sexComboBox.setFont(new Font("PT Sans", Font.PLAIN, 15));
		sexComboBox.addItem('m');
		sexComboBox.addItem('f');
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setFont(new Font("PT Sans", Font.PLAIN, 20));
		GroupLayout gl_SixthPanel = new GroupLayout(SixthPanel);
		gl_SixthPanel.setHorizontalGroup(
			gl_SixthPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_SixthPanel.createSequentialGroup()
					.addGap(155)
					.addComponent(lblSex)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(sexComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(HeightLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(HeightField, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(155, Short.MAX_VALUE))
		);
		gl_SixthPanel.setVerticalGroup(
			gl_SixthPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_SixthPanel.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_SixthPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSex)
						.addComponent(sexComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(HeightLabel)
						.addComponent(HeightField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		SixthPanel.setLayout(gl_SixthPanel);
		SuperPanel2.add(SeventhPanel);
		
		invalidInputLabel = new JLabel();
		GroupLayout gl_SeventhPanel = new GroupLayout(SeventhPanel);
		gl_SeventhPanel.setHorizontalGroup(
			gl_SeventhPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_SeventhPanel.createSequentialGroup()
					.addGap(247)
					.addComponent(NextButton2, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(invalidInputLabel)
					.addContainerGap(193, Short.MAX_VALUE))
		);
		gl_SeventhPanel.setVerticalGroup(
			gl_SeventhPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_SeventhPanel.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_SeventhPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(NextButton2)
						.addComponent(invalidInputLabel))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		SeventhPanel.setLayout(gl_SeventhPanel);
		
		
	//////////////////////////////////////////////////////////////////	
		FirstInputPanel = new JPanel();
		FirstInputPanel.setBorder(new LineBorder(new Color(102, 204, 102), 4, true));
		FirstInputPanel.setBackground(Color.DARK_GRAY);
	
	/////////////////////////////////////////////////////////////////
		FinalPanel = new JPanel();
	/////////////////////////////////////////////////////////////////
		
		this.add(SuperPanel, "1"); 
		UserPassPromt = new JLabel();
		UserPassPromt.setFont(new Font("PT Sans", Font.BOLD, 30));
		UserPassPromt.setText("Please enter username and password");
		
		
		UsernameLabel = new JLabel("Username");
		UsernameLabel.setFont(new Font("PT Sans", Font.PLAIN, 20));
		UsernameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		PasswordLabel = new JLabel("Password");
		PasswordLabel.setFont(new Font("PT Sans", Font.PLAIN, 20));
		PasswordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		PasswordVerifyLabel = new JLabel("Verify Password");
		PasswordVerifyLabel.setFont(new Font("PT Sans", Font.PLAIN, 20));
		PasswordVerifyLabel.setHorizontalAlignment(SwingConstants.LEFT);
		UsernameField = new JTextField();
		UsernameField.setFont(new Font("PT Sans", Font.PLAIN, 15));
		PasswordField = new JPasswordField();
		PasswordField.setFont(new Font("PT Sans", Font.PLAIN, 15));
		VerifyField = new JPasswordField();
		VerifyField.setFont(new Font("PT Sans", Font.PLAIN, 15));
		SecurityLabel = new JLabel("Account Recovery Security Question");
		SecurityLabel.setFont(new Font("PT Sans", Font.BOLD, 30));
		RecoveryQuestionField = new JTextField();
		RecoveryQuestionField.setFont(new Font("PT Sans", Font.PLAIN, 15));
		NextButton = new JButton("Next");
		NextButton.setForeground(Color.BLACK);
		NextButton.setFont(new Font("PT Sans", Font.PLAIN, 20));
		NextButton.addActionListener(this);
		RecoveryQuestionLabel = new JLabel("Name of first pet");
		RecoveryQuestionLabel.setFont(new Font("PT Sans", Font.PLAIN, 20));
		RecoveryQuestionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		ErrorLabel1 = new JLabel();
		
		matchingPasswordsErrorLabel = new JLabel();
		GroupLayout gl_SuperPanel = new GroupLayout(SuperPanel);
		gl_SuperPanel.setHorizontalGroup(
			gl_SuperPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_SuperPanel.createSequentialGroup()
					.addGroup(gl_SuperPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_SuperPanel.createSequentialGroup()
							.addGap(214)
							.addComponent(NextButton, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_SuperPanel.createSequentialGroup()
							.addGap(37)
							.addGroup(gl_SuperPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_SuperPanel.createSequentialGroup()
									.addComponent(RecoveryQuestionLabel, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(RecoveryQuestionField, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_SuperPanel.createSequentialGroup()
									.addGroup(gl_SuperPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(UsernameLabel)
										.addComponent(PasswordLabel)
										.addComponent(PasswordVerifyLabel))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_SuperPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_SuperPanel.createSequentialGroup()
											.addComponent(VerifyField, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
											.addComponent(matchingPasswordsErrorLabel))
										.addComponent(PasswordField, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_SuperPanel.createSequentialGroup()
											.addComponent(UsernameField, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(ErrorLabel1))))))
						.addGroup(gl_SuperPanel.createSequentialGroup()
							.addGap(90)
							.addComponent(SecurityLabel)))
					.addContainerGap(29, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_SuperPanel.createSequentialGroup()
					.addContainerGap(70, Short.MAX_VALUE)
					.addComponent(UserPassPromt)
					.addGap(63))
		);
		gl_SuperPanel.setVerticalGroup(
			gl_SuperPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_SuperPanel.createSequentialGroup()
					.addGap(31)
					.addComponent(UserPassPromt)
					.addGap(47)
					.addGroup(gl_SuperPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(UsernameLabel)
						.addComponent(UsernameField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(ErrorLabel1))
					.addGap(18)
					.addGroup(gl_SuperPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(PasswordLabel)
						.addComponent(PasswordField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_SuperPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(PasswordVerifyLabel)
						.addComponent(VerifyField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(matchingPasswordsErrorLabel))
					.addGap(66)
					.addComponent(SecurityLabel)
					.addGap(18)
					.addGroup(gl_SuperPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(RecoveryQuestionLabel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addComponent(RecoveryQuestionField, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addComponent(NextButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addGap(62))
		);
		gl_SuperPanel.linkSize(SwingConstants.VERTICAL, new Component[] {UsernameField, PasswordField, VerifyField, RecoveryQuestionField});
		gl_SuperPanel.linkSize(SwingConstants.HORIZONTAL, new Component[] {UsernameField, PasswordField, VerifyField});
		SuperPanel.setLayout(gl_SuperPanel);
		this.add(SuperPanel2, "2");
		this.add(FirstInputPanel, "FirstInputPanel");
		firstWeightField = new JTextField();
		firstWeightField.setHorizontalAlignment(SwingConstants.CENTER);
		firstWeightField.setFont(new Font("PT Sans", Font.ITALIC, 15));
		firstWeightField.setText("lbs");
		firstWeightField.setColumns(10);
		
		firstCalorieField = new JTextField();
		firstCalorieField.setHorizontalAlignment(SwingConstants.CENTER);
		firstCalorieField.setFont(new Font("PT Sans", Font.ITALIC, 15));
		firstCalorieField.setText("Cals");
		firstCalorieField.setColumns(10);
		
		firstExerciseField = new JTextField();
		firstExerciseField.setHorizontalAlignment(SwingConstants.CENTER);
		firstExerciseField.setFont(new Font("PT Sans", Font.ITALIC, 15));
		firstExerciseField.setText("hrs");
		firstExerciseField.setColumns(10);
		
		finishButton = new JButton("Finish");
		finishButton.setFont(new Font("PT Sans", Font.PLAIN, 17));
		finishButton.setOpaque(true);
		finishButton.setBackground(Color.DARK_GRAY);
		finishButton.addActionListener(this);
		
		JLabel lblNewLabel = new JLabel("Please Input First Health Log.");
		lblNewLabel.setFont(new Font("PT Sans", Font.BOLD, 30));
		
		invalidFirstInputLabel = new JLabel("");
		invalidFirstInputLabel.setForeground(Color.RED);
		
		lblYourCurrentWeight = new JLabel("Your Current Weight");
		lblYourCurrentWeight.setFont(new Font("PT Sans", Font.PLAIN, 25));
		
		lblCaloriesConsumedToday = new JLabel("Calories Consumed Today");
		lblCaloriesConsumedToday.setFont(new Font("PT Sans", Font.PLAIN, 25));
		
		lblHoursOfExercise = new JLabel("Hours of Exercise Today");
		lblHoursOfExercise.setFont(new Font("PT Sans", Font.PLAIN, 25));
		
		firstSleepField = new JTextField();
		firstSleepField.setHorizontalAlignment(SwingConstants.CENTER);
		firstSleepField.setFont(new Font("PT Sans", Font.ITALIC, 15));
		firstSleepField.setText("hrs");
		firstSleepField.setColumns(10);
		
		JLabel lblHoursOfSleep = new JLabel("Hours of Sleep Last Night");
		lblHoursOfSleep.setFont(new Font("PT Sans", Font.PLAIN, 25));
		GroupLayout gl_FirstInputPanel = new GroupLayout(FirstInputPanel);
		gl_FirstInputPanel.setHorizontalGroup(
			gl_FirstInputPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_FirstInputPanel.createSequentialGroup()
					.addGap(56)
					.addComponent(finishButton, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(48, Short.MAX_VALUE))
				.addGroup(gl_FirstInputPanel.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_FirstInputPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_FirstInputPanel.createSequentialGroup()
							.addComponent(invalidFirstInputLabel, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
							.addGap(305))
						.addGroup(gl_FirstInputPanel.createSequentialGroup()
							.addGroup(gl_FirstInputPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_FirstInputPanel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_FirstInputPanel.createSequentialGroup()
										.addGroup(gl_FirstInputPanel.createParallelGroup(Alignment.LEADING)
											.addComponent(lblYourCurrentWeight)
											.addComponent(lblCaloriesConsumedToday))
										.addGap(138))
									.addGroup(gl_FirstInputPanel.createSequentialGroup()
										.addComponent(lblHoursOfSleep, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)))
								.addGroup(gl_FirstInputPanel.createSequentialGroup()
									.addComponent(lblHoursOfExercise)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_FirstInputPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_FirstInputPanel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(firstCalorieField, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
								.addComponent(firstSleepField, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
								.addComponent(firstExerciseField, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(firstWeightField, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
							.addGap(130))))
				.addGroup(gl_FirstInputPanel.createSequentialGroup()
					.addGap(118)
					.addComponent(lblNewLabel)
					.addContainerGap(161, Short.MAX_VALUE))
		);
		gl_FirstInputPanel.setVerticalGroup(
			gl_FirstInputPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_FirstInputPanel.createSequentialGroup()
					.addGap(41)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_FirstInputPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_FirstInputPanel.createSequentialGroup()
							.addGap(64)
							.addGroup(gl_FirstInputPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_FirstInputPanel.createSequentialGroup()
									.addComponent(firstWeightField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(firstCalorieField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(29)
									.addGroup(gl_FirstInputPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(firstExerciseField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblHoursOfExercise))
									.addGap(28)
									.addGroup(gl_FirstInputPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(firstSleepField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblHoursOfSleep)))
								.addGroup(gl_FirstInputPanel.createSequentialGroup()
									.addComponent(lblYourCurrentWeight)
									.addGap(18)
									.addComponent(lblCaloriesConsumedToday)))
							.addGap(70)
							.addComponent(finishButton)
							.addContainerGap(113, Short.MAX_VALUE))
						.addGroup(gl_FirstInputPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
							.addComponent(invalidFirstInputLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(168))))
		);
		FirstInputPanel.setLayout(gl_FirstInputPanel);
		this.add(FinalPanel, "4");
		
		//this.setLayout(new BorderLayout());
		//add(SuperPanel,BorderLayout.CENTER);
		
	}
	
	public void actionPerformed(ActionEvent event)
	{
		
		//first page for username and passwords
		boolean usernameAvailable = VerificationController.usernameAvailable(UsernameField.getText());
		boolean passwordsEqual = false;
		
		String password = "", verifyPassword = "";
		for(int i = 0; i < PasswordField.getPassword().length; i++)
		{
			password += PasswordField.getPassword()[i];
		}
		
		for(int i = 0; i < VerifyField.getPassword().length; i++)
		{
			verifyPassword += VerifyField.getPassword()[i];
		}
		
		if(password.equals(verifyPassword))
		{
			passwordsEqual = true;
		}
		
		
		if (event.getSource() == NextButton)
		{
			if(!usernameAvailable)
			{
				ErrorLabel1.setForeground(Color.red);
				ErrorLabel1.setText("Username not available");
			}
			else
			{
				ErrorLabel1.setText("");
			}
			
			if(!passwordsEqual || PasswordField.getPassword().length == 0)
			{
				passwordsEqual = false;
				matchingPasswordsErrorLabel.setForeground(Color.red);
				matchingPasswordsErrorLabel.setText("Passwords do not match");
			}
			else
			{
				matchingPasswordsErrorLabel.setText("");
			}
			
			if(usernameAvailable && passwordsEqual && !RecoveryQuestionField.getText().isEmpty())
			{
				username = UsernameField.getText().toLowerCase();
				this.password = password;
				securityQuestion = RecoveryQuestionField.getText().toLowerCase();
				
				c = (CardLayout)(this.getLayout());
				c.show(this, "2");
			}

		}
		
		//second page input verification, (first name, last name, email, birthday, current weight, goal weight, height)

		boolean validInput = false;
		if (event.getSource() == NextButton2)
		{
			if(!FirstNameField.getText().isEmpty() && !LastNameField.getText().isEmpty() && !EmailField.getText().isEmpty()
					&& isDouble(GoalWeightField.getText()) && 
					isDouble(HeightField.getText()) && isDouble(DayBox.getSelectedItem().toString()) && isDouble(YearBox.getSelectedItem().toString())
					&& isDouble(MonthBox.getSelectedItem().toString()))
			{
				validInput = true;
			}
			else
			{
				invalidInputLabel.setText("Invalid Input");
				invalidInputLabel.setForeground(Color.red);
				validInput = false;
			}
			
			if(validInput)
			{
				firstName = FirstNameField.getText();
				lastName = LastNameField.getText();
				email = EmailField.getText();
				goalWeight = Double.parseDouble(GoalWeightField.getText());
				heightInches = Double.parseDouble(HeightField.getText());
				birthdayMonth = (int)Double.parseDouble(MonthBox.getSelectedItem().toString());
				birthdayDay = (int)Double.parseDouble(DayBox.getSelectedItem().toString());
				birthdayYear = (int)Double.parseDouble(YearBox.getSelectedItem().toString());
				sex = sexComboBox.getSelectedItem().toString().charAt(0);
				newAccount = new AccountControl();
				newAccount.addNewAccount(username, firstName, lastName, email, birthdayYear, birthdayMonth, birthdayDay,
						sex, securityQuestion, this.password, heightInches, goalWeight);
				
				
				c.show(this, "FirstInputPanel");
			}
			
		}
		if(event.getSource() == finishButton)
		{
			boolean validFirstInput = false;
			
			//Verify input
			if(isDouble(firstWeightField.getText()) && isDouble(firstCalorieField.getText()) 
					&& isDouble(firstSleepField.getText()) && isDouble(firstExerciseField.getText())
					&& Double.parseDouble(firstWeightField.getText()) >= 50
					&& Double.parseDouble(firstCalorieField.getText()) >= 0
					&& Double.parseDouble(firstSleepField.getText()) >= 0
					&& Double.parseDouble(firstExerciseField.getText()) >= 0)
			{
				validFirstInput = true;
			}
			else
			{
				invalidFirstInputLabel.setText("Invalid Input");
				validFirstInput = false;
			}
			
			if(validFirstInput)
			{
				//Adds new inputs to database
				newAccount.setUserID(GeneralDataCommunicator.getUserID(newAccount.getUserName()));
				int userID = newAccount.getUserID();
				newAccount.getHealthCollectionControl().addNewMeasurement(userID, "weight", Double.parseDouble(firstWeightField.getText()));
				newAccount.getHealthCollectionControl().addNewMeasurement(userID, "calories", Double.parseDouble(firstCalorieField.getText()));
				newAccount.getHealthCollectionControl().addNewMeasurement(userID, "exercise", Double.parseDouble(firstExerciseField.getText()));
				newAccount.getHealthCollectionControl().addNewMeasurement(userID, "sleep", Double.parseDouble(firstSleepField.getText()));

				
				((MainGUI)this.getParent()).newUserSuccess(username);
			}
			
		}
	}
	
	
	//input validation
    private boolean isDouble(Object input) {
        try {
        	String str = (String) input;
            Double.parseDouble(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
