package GUI;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import Control.AccountControl;

public class MyHealthRemake extends JPanel
{
	JPanel LoginPage;
	JPanel DashboardTab;
	JTabbedPane MainApp;
	CardLayout c1;
	HelpTab helpTab;
	ActionListener l;
	AccountTab accountTab;
	GoalsTab goalsTab;
	AccountControl account;
	
	
	public MyHealthRemake(AccountControl account)
	{
		helpTab = new HelpTab(account);
		accountTab = new AccountTab(account);
		goalsTab = new GoalsTab(account);
		this.setLayout(new CardLayout());
		this.setSize(1000, 1000);
		
		
		//////////////////////////////////////////////////////////
		
		
		MainApp = new JTabbedPane();
		MainApp.setFont(new Font("PT Sans", Font.PLAIN, 15));
		
		MainApp.addTab("Dashboard", (new DashboardTab(account)));//Matt
		MainApp.addTab("Input", new InputTab(account).getView());
		MainApp.addTab("Analysis", new AnalysisTab(account));//Dan
		MainApp.addTab("Comparisons", new ComparisonsTab(account));//Dan
		MainApp.addTab("Goals", goalsTab);//Matt
		MainApp.addTab("Account", accountTab);//Matt
		MainApp.addTab("Help", helpTab);//Matt
		
		///////////////////////////////////////////////////////////
		
		
		this.add(MainApp,"2");

		
	}
	


	public MyHealthRemake() {
		
	}

	

	public void backToDash()
	{
		c1 = (CardLayout)(this.getLayout());
		c1.show(this, "2");
		((DashboardTab)MainApp.getComponentAt(0)).refresh();
		MainApp.setSelectedIndex(0);

	}
}
