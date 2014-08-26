package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import Control.AccountControl;
import Control.VerificationController;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;

public class ForgotPassPanel extends JPanel implements ActionListener
{
	
	
	
	private CardLayout c;
	
	private JPanel confirmationPanel;
	
	private JLabel SuccessLabel;
	private JButton toLoginPage;

	
	public ForgotPassPanel()
	{
		this.setLayout(new CardLayout());
		this.setSize(615, 570);
		
		
	/*
		JLabel IncorrectLabel = new JLabel("(Incorrect)");
		IncorrectLabel.setForeground(Color.RED);
		IncorrectLabel.setBackground(Color.WHITE);
		IncorrectLabel.setBounds(290, 113, 72, 16);
		securityQuestionPanel.add(IncorrectLabel);
		

		
		JLabel NoMatchLabel = new JLabel("Passwords do not match");
		NoMatchLabel.setForeground(Color.RED);
		NoMatchLabel.setBounds(290, 191, 154, 16);
		securityQuestionPanel.add(NoMatchLabel);
		
		*/
	/////////////////////////////////////////////////////////////////////////////
		
		confirmationPanel = new JPanel(null);
		confirmationPanel.setBorder(new LineBorder(new Color(220, 20, 60), 4, true));
		confirmationPanel.setBackground(Color.DARK_GRAY);
		
		SuccessLabel = new JLabel("Password Successfully Changed!");
		SuccessLabel.setFont(new Font("PT Sans", Font.PLAIN, 30));
		
		toLoginPage = new JButton("To Login Page");
		toLoginPage.setFont(new Font("PT Sans", Font.PLAIN, 25));
		toLoginPage.addActionListener(this);
		
		this.add(new SecurityQuestionPanel(), "securityQuestionPanel");
		this.add(confirmationPanel, "confirmationPanel");
		GroupLayout gl_confirmationPanel = new GroupLayout(confirmationPanel);
		gl_confirmationPanel.setHorizontalGroup(
			gl_confirmationPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_confirmationPanel.createSequentialGroup()
					.addGap(156)
					.addComponent(toLoginPage, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(149, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_confirmationPanel.createSequentialGroup()
					.addContainerGap(99, Short.MAX_VALUE)
					.addComponent(SuccessLabel)
					.addGap(91))
		);
		gl_confirmationPanel.setVerticalGroup(
			gl_confirmationPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_confirmationPanel.createSequentialGroup()
					.addGap(65)
					.addComponent(SuccessLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(131)
					.addComponent(toLoginPage, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addGap(222))
		);
		confirmationPanel.setLayout(gl_confirmationPanel);
	}
	
	
	public void securityAnswerCorrect(String username)
	{
		this.add(new NewPasswordPanel(username), "chooseNewPasswordPanel");
		c = (CardLayout)(this.getLayout());
		c.show(this, "chooseNewPasswordPanel");
	}
	
	public void newPasswordSet()
	{
		c = (CardLayout)(this.getLayout());
		c.show(this, "confirmationPanel");
	}
	
	public void actionPerformed(ActionEvent event) 
	{
		
		if(event.getSource() == toLoginPage)
		{
			//c = (CardLayout)(this.getLayout());
			((MainGUI)this.getParent()).toLogin();
			
		}
		
	}
}
