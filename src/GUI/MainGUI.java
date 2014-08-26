package GUI;

import java.awt.CardLayout;

import javax.swing.JPanel;

import Control.AccountControl;

public class MainGUI extends JPanel{

	private MyHealthRemake applicationPanel;
	private LoginPanel loginPanel;
	private CardLayout cardLayout;
	public MainGUI()
	{
		this.setLayout(new CardLayout());
		this.setSize(615, 570);
		
		loginPanel = new LoginPanel();
		this.add(loginPanel, "login");
		
	}
	
	
	public void loginSuccess(String username)
	{
		AccountControl account = new AccountControl();
		account.retrieveFromDataBase(username);
		applicationPanel = new MyHealthRemake(account);
		this.add(applicationPanel, "applicationPanel");
		cardLayout = (CardLayout)this.getLayout();
		cardLayout.show(this, "applicationPanel");
		
		
	}
	
	
	public void toLogin()
	{
		cardLayout = (CardLayout)(this.getLayout());
		cardLayout.show(this, "login");
	}
	
	
	public void newUser()
	{
		this.add(new NewAccountPanel(), "newAccount");
		cardLayout = (CardLayout)(this.getLayout());
		cardLayout.show(this, "newAccount");
	}
	
	public void newUserSuccess(String username)
	{
		AccountControl account = new AccountControl();
		account.retrieveFromDataBase(username);
		applicationPanel = new MyHealthRemake(account);
		this.add(applicationPanel, "applicationPanel");
		cardLayout = (CardLayout)this.getLayout();
		cardLayout.show(this, "applicationPanel");
		
	}
	
	public void forgotPassword()
	{
		this.add(new ForgotPassPanel(), "forgotPassword");

		cardLayout = (CardLayout)(this.getLayout());
		cardLayout.show(this, "forgotPassword");
	}
	
}
