package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Control.VerificationController;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class SecurityQuestionPanel extends JPanel implements ActionListener{
	private JTextField usernameField;
	private JTextField securityQuestionField;
	private JButton nextButton;
	String username;
	private JLabel PassowordResetLabel;
	
	public SecurityQuestionPanel()
	{
		setBorder(new LineBorder(new Color(51, 153, 0), 5, true));
		setBackground(Color.DARK_GRAY);	
		this.setSize(615,570);
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("PT Sans", Font.PLAIN, 25));
		
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("PT Sans", Font.PLAIN, 15));
		
		
		JLabel securityQuestionLabel = new JLabel("Name of first pet");
		securityQuestionLabel.setFont(new Font("PT Sans", Font.PLAIN, 25));
				
		securityQuestionField = new JTextField();
		securityQuestionField.setFont(new Font("PT Sans", Font.PLAIN, 15));
		
		nextButton = new JButton("Next");
		nextButton.setFont(new Font("PT Sans", Font.PLAIN, 25));
		nextButton.addActionListener(this);
		
		PassowordResetLabel = new JLabel("Password Reset");
		PassowordResetLabel.setFont(new Font("PT Sans", Font.BOLD, 30));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(19)
							.addComponent(securityQuestionLabel, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
							.addGap(61)
							.addComponent(securityQuestionField, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(52)
							.addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(95, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(54)
					.addComponent(nextButton, GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
					.addGap(55))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(206, Short.MAX_VALUE)
					.addComponent(PassowordResetLabel)
					.addGap(199))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(54)
					.addComponent(PassowordResetLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(57))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(64)))
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(securityQuestionField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(securityQuestionLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(80)
					.addComponent(nextButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(66))
		);
		groupLayout.linkSize(SwingConstants.VERTICAL, new Component[] {usernameField, securityQuestionField});
		setLayout(groupLayout);
		
		
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == nextButton)
		{
			if(VerificationController.correctSecretAnswer(usernameField.getText().toLowerCase(), securityQuestionField.getText().toLowerCase()))
			{
				if(usernameField.getText().isEmpty())
					username = "jjrob13";
				else{
					username = usernameField.getText().toLowerCase();
				}
				
				((ForgotPassPanel)this.getParent()).securityAnswerCorrect(username);

			}
			
			//else incorrect username and security answer
			else
			{
				usernameField.setText("Incorrect security answer");
			}
			
			
		}
		
	}
}
