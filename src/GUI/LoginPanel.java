package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import Control.AccountControl;
import Control.VerificationController;
import java.awt.Component;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;

public class LoginPanel extends JPanel implements ActionListener{
	
	private JPanel TopPanelofFour; //Top Panel of 4. Holds JText
	private JPanel SecondPanelofFour; //Second Panel of 4. Holds 2 TLabels & 2 JFields
	private JPanel ThirdPanelofFour; //Third Panel that holds button
	private JPanel BottomPanelofFour; //Bottom Panel that holds two linked texts	
	private JLabel LoginOrCreate; // Text that prompts users
	private JLabel UsernameLabel; //Label that reads "Username"
	private JLabel PasswordLabel; //Label that reads "Password"
	private JLabel errorLabel;
	private JButton ForgotPasswordLabel; //Label that reads "Forgot your Password?"
	private JButton NewUserButton; //Label that reads "New User? Create and account."
	private JTextField UsernameField; //TextField for username
	private JPasswordField PasswordField; //PasswordField for password
	private JButton LoginButton;

	public LoginPanel()
	{
		setBorder(new LineBorder(new Color(255, 0, 0), 4));
		setBackground(Color.DARK_GRAY);
		this.setSize(615,570);
		TopPanelofFour = new JPanel();//the panel that holds the LoginOrCreate JLabel
		TopPanelofFour.setBorder(new LineBorder(Color.DARK_GRAY, 0));
		TopPanelofFour.setBackground(Color.DARK_GRAY);
		LoginOrCreate = new JLabel("Please login or create an account");
		LoginOrCreate.setForeground(Color.BLACK);
		LoginOrCreate.setFont(new Font("PT Sans", Font.BOLD, 30));
		LoginOrCreate.setVerticalAlignment(SwingConstants.CENTER);
		
		SecondPanelofFour = new JPanel();
		SecondPanelofFour.setBorder(new LineBorder(Color.DARK_GRAY, 0));
		SecondPanelofFour.setBackground(Color.DARK_GRAY);
		UsernameLabel = new JLabel("Username"); //creating label username
		UsernameLabel.setForeground(Color.BLACK);
		UsernameLabel.setFont(new Font("PT Sans Caption", Font.BOLD, 20));
		UsernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PasswordLabel = new JLabel("Password"); //creating password label
		PasswordLabel.setForeground(Color.BLACK);
		PasswordLabel.setFont(new Font("PT Sans Caption", Font.BOLD, 20));
		PasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		UsernameField = new JTextField(15); //creating text field for username
		UsernameField.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		UsernameField.setHorizontalAlignment(SwingConstants.LEFT);
		PasswordField = new JPasswordField(15); //creating password field for password
		PasswordField.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		PasswordField.setHorizontalAlignment(SwingConstants.LEFT);
		
		ThirdPanelofFour = new JPanel();
		ThirdPanelofFour.setBorder(new LineBorder(Color.DARK_GRAY, 0));
		ThirdPanelofFour.setBackground(Color.DARK_GRAY);
		LoginButton = new JButton("Login");
		LoginButton.setForeground(new Color(0, 0, 0));
		LoginButton.setBackground(UIManager.getColor("Button.background"));
		LoginButton.setFont(new Font("PT Sans Caption", Font.BOLD, 25));
		LoginButton.addActionListener(this);
		
		BottomPanelofFour = new JPanel();
		BottomPanelofFour.setBorder(new LineBorder(Color.DARK_GRAY, 0));
		BottomPanelofFour.setBackground(Color.DARK_GRAY);
		ForgotPasswordLabel = new JButton("Forgot your password?");
		ForgotPasswordLabel.setForeground(new Color(0, 0, 0));
		ForgotPasswordLabel.setBackground(UIManager.getColor("Button.background"));
		ForgotPasswordLabel.setFont(new Font("PT Sans Caption", Font.BOLD, 20));
		ForgotPasswordLabel.addActionListener(this);
		ForgotPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		NewUserButton = new JButton("New User? Create an account");
		NewUserButton.setForeground(new Color(0, 0, 0));
		NewUserButton.setBackground(UIManager.getColor("Button.background"));
		NewUserButton.setFont(new Font("PT Sans Caption", Font.BOLD, 20));
		NewUserButton.addActionListener(this);
		NewUserButton.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		this.setLayout(new GridLayout(4,1,0,7));
		this.add(TopPanelofFour);
		
		errorLabel = new JLabel("");
		errorLabel.setFont(new Font("PT Serif Caption", Font.ITALIC, 13));
		errorLabel.setForeground(Color.RED);
		GroupLayout gl_TopPanelofFour = new GroupLayout(TopPanelofFour);
		gl_TopPanelofFour.setHorizontalGroup(
			gl_TopPanelofFour.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_TopPanelofFour.createSequentialGroup()
					.addGap(95)
					.addComponent(LoginOrCreate)
					.addContainerGap(87, Short.MAX_VALUE))
				.addGroup(gl_TopPanelofFour.createSequentialGroup()
					.addContainerGap(330, Short.MAX_VALUE)
					.addComponent(errorLabel)
					.addGap(210))
		);
		gl_TopPanelofFour.setVerticalGroup(
			gl_TopPanelofFour.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_TopPanelofFour.createSequentialGroup()
					.addGap(43)
					.addComponent(LoginOrCreate)
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addComponent(errorLabel))
		);
		TopPanelofFour.setLayout(gl_TopPanelofFour);
		this.add(SecondPanelofFour);
		GroupLayout gl_SecondPanelofFour = new GroupLayout(SecondPanelofFour);
		gl_SecondPanelofFour.setHorizontalGroup(
			gl_SecondPanelofFour.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_SecondPanelofFour.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_SecondPanelofFour.createParallelGroup(Alignment.LEADING)
						.addComponent(UsernameLabel, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
						.addComponent(PasswordLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_SecondPanelofFour.createParallelGroup(Alignment.LEADING, false)
						.addComponent(UsernameField, 0, 0, Short.MAX_VALUE)
						.addComponent(PasswordField, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
					.addContainerGap(116, Short.MAX_VALUE))
		);
		gl_SecondPanelofFour.setVerticalGroup(
			gl_SecondPanelofFour.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_SecondPanelofFour.createSequentialGroup()
					.addContainerGap(7, Short.MAX_VALUE)
					.addGroup(gl_SecondPanelofFour.createParallelGroup(Alignment.BASELINE)
						.addComponent(UsernameLabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(UsernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_SecondPanelofFour.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_SecondPanelofFour.createSequentialGroup()
							.addComponent(PasswordLabel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
							.addGap(10))
						.addGroup(gl_SecondPanelofFour.createSequentialGroup()
							.addComponent(PasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_SecondPanelofFour.linkSize(SwingConstants.VERTICAL, new Component[] {UsernameField, PasswordField});
		gl_SecondPanelofFour.linkSize(SwingConstants.HORIZONTAL, new Component[] {UsernameLabel, PasswordLabel});
		SecondPanelofFour.setLayout(gl_SecondPanelofFour);
		this.add(ThirdPanelofFour);
		GroupLayout gl_ThirdPanelofFour = new GroupLayout(ThirdPanelofFour);
		gl_ThirdPanelofFour.setHorizontalGroup(
			gl_ThirdPanelofFour.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ThirdPanelofFour.createSequentialGroup()
					.addGap(161)
					.addComponent(LoginButton, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(171, Short.MAX_VALUE))
		);
		gl_ThirdPanelofFour.setVerticalGroup(
			gl_ThirdPanelofFour.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_ThirdPanelofFour.createSequentialGroup()
					.addContainerGap(37, Short.MAX_VALUE)
					.addComponent(LoginButton, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(29))
		);
		ThirdPanelofFour.setLayout(gl_ThirdPanelofFour);
		this.add(BottomPanelofFour);	
		GroupLayout gl_BottomPanelofFour = new GroupLayout(BottomPanelofFour);
		gl_BottomPanelofFour.setHorizontalGroup(
			gl_BottomPanelofFour.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_BottomPanelofFour.createSequentialGroup()
					.addGap(91)
					.addGroup(gl_BottomPanelofFour.createParallelGroup(Alignment.LEADING)
						.addComponent(NewUserButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
						.addComponent(ForgotPasswordLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))
					.addGap(105))
		);
		gl_BottomPanelofFour.setVerticalGroup(
			gl_BottomPanelofFour.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_BottomPanelofFour.createSequentialGroup()
					.addContainerGap()
					.addComponent(ForgotPasswordLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(NewUserButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		gl_BottomPanelofFour.linkSize(SwingConstants.VERTICAL, new Component[] {ForgotPasswordLabel, NewUserButton});
		BottomPanelofFour.setLayout(gl_BottomPanelofFour);
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource() == LoginButton)
		{
			//put password into variable
			String password = "";
			for(char character : PasswordField.getPassword())
			{
				password += character;
			}
			
			
			if(VerificationController.correctPassword(UsernameField.getText().toLowerCase(), password))
			{
				((MainGUI)this.getParent()).loginSuccess(UsernameField.getText().toLowerCase());
			}
			
			
			//clear fields and display error
			else
			{
				
				errorLabel.setText("Incorrect Username or Password");


				PasswordField.setText("");
				
			}
		
		}
		if(e.getSource() == NewUserButton)
		{
			((MainGUI)this.getParent()).newUser();
		}
		if(e.getSource() == ForgotPasswordLabel)
		{
			((MainGUI)this.getParent()).forgotPassword();
		}
	}
}
