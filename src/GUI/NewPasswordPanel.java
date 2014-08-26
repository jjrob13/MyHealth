package GUI;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import Control.VerificationController;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.border.LineBorder;

public class NewPasswordPanel extends JPanel implements ActionListener{

	private JPasswordField newPasswordField;
	private JPasswordField verifyPasswordField;
	private String username;
	private JButton changePasswordButton;
	private JLabel ErrorLabel;
	private JLabel errorLabel;
	
	public NewPasswordPanel(String username)
	{
		setBorder(new LineBorder(new Color(255, 153, 102), 4, true));
		setBackground(Color.DARK_GRAY);
		this.setSize(615,570);
		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.red);
		
		this.username = username;
		
		//fields
		verifyPasswordField = new JPasswordField();
		verifyPasswordField.setFont(new Font("PT Sans", Font.PLAIN, 20));
		newPasswordField = new JPasswordField();
		newPasswordField.setFont(new Font("PT Sans", Font.PLAIN, 20));
		
		//labels
		JLabel newPasswordLabel = new JLabel("New Password");
		newPasswordLabel.setFont(new Font("PT Sans", Font.PLAIN, 25));
		JLabel verifyPasswordLabel = new JLabel("Verify Password");
		verifyPasswordLabel.setFont(new Font("PT Sans", Font.PLAIN, 25));
		
		//buttons
		changePasswordButton = new JButton("Change Password");
		changePasswordButton.setFont(new Font("PT Sans", Font.PLAIN, 30));
		changePasswordButton.addActionListener(this);
		
		ErrorLabel = new JLabel("");
		ErrorLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(55)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(changePasswordButton, GroupLayout.PREFERRED_SIZE, 499, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(errorLabel, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(newPasswordLabel)
										.addGap(18)
										.addComponent(newPasswordField, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(verifyPasswordLabel)
										.addGap(18)
										.addComponent(verifyPasswordField, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(241)
							.addComponent(ErrorLabel)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(64)
					.addComponent(ErrorLabel)
					.addGap(82)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(newPasswordLabel)
						.addComponent(newPasswordField, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addGap(74)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(verifyPasswordLabel)
						.addComponent(verifyPasswordField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(88)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(errorLabel, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
						.addComponent(changePasswordButton, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.linkSize(SwingConstants.VERTICAL, new Component[] {verifyPasswordField, newPasswordField});
		setLayout(groupLayout);

		

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String password1 = "", password2 = "";
		for(char charInPassword : newPasswordField.getPassword())
		{
			password1 += charInPassword;
		}
		
		for(char charInPassword : verifyPasswordField.getPassword())
		{
			password2 += charInPassword;
		}
		
		if(password1.equals(password2))
		{
			VerificationController.updatePassword(username, password1);
			((ForgotPassPanel)this.getParent()).newPasswordSet();
		}
		else{
			ErrorLabel.setForeground(Color.red);
			ErrorLabel.setText("Passwords do not match");
		}
		
	}
}
