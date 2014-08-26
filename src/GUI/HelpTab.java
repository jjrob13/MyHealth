package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.Border;

import Control.AccountControl;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.DropMode;
import javax.swing.UIManager;

public class HelpTab extends JPanel implements ActionListener
{
	private JPanel MiddlePanelofThree;
	private JLabel NeedInfo;
	private JTextArea InfoDescription;
	private JComboBox InfoListBox;
	private JButton doneButton;
	private static String[] InfoList = {"User Dashboard","Input Tab", "Analysis Tab", "Comparisons Tab","Goals","Account Tab"};
	
	
	
	private static String[] descriptionList = {"The User Dashboard displays your current weight as well as your goal weight.  " +
			"Additionally, your active goals and date of last log input will also be displayed", 
			"The Input Tab allows you to input your health measurements for the day.  For best results submit a log daily.",
			"The Analysis Tab allows you to view graphs of your progress in all categories over different timeframes.  All personalized graphs" +
			" can be printed.",
			"The Comparison Tab allows you to view graphs that compare your health with others in your demographic.  Feel free to print" +
			" any of the personalized graphs.",
			"The Goals Tab allows you to view and input new goals.  Goals are displayed by a " +
			"progress bar and expire one week from creation.  You are only allowed three goals per week.",
			"The Account Tab allows you to change your user information if anything needs to be updated."};
	
	public HelpTab(AccountControl account)
	{
		this.setSize(615, 570);
		setBorder(new LineBorder(new Color(153, 102, 204), 4, true));
		setBackground(Color.DARK_GRAY);
		
		MiddlePanelofThree = new JPanel(); //middle panel holds the text area and the combo box
		MiddlePanelofThree.setForeground(Color.DARK_GRAY);
		MiddlePanelofThree.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));
		MiddlePanelofThree.setBackground(Color.DARK_GRAY);
		MiddlePanelofThree.setSize(500, 500); //set the size of the panel
		InfoDescription = new JTextArea(); // instantiating the new text area
		InfoDescription.setDropMode(DropMode.INSERT);
		InfoDescription.setFont(new Font("PT Sans Caption", Font.ITALIC, 20));
		InfoDescription.setBackground(Color.DARK_GRAY);
		InfoDescription.setLineWrap(true);;
		InfoDescription.setWrapStyleWord(true);
		
		InfoDescription.setSize(100,100); //setting the size of the text area
		InfoDescription.setEditable(false);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		InfoDescription.setBorder(new LineBorder(new Color(153, 102, 204), 2, true));
		NeedInfo = new JLabel("On which topic do you need more information?");
		NeedInfo.setFont(new Font("PT Sans", Font.BOLD, 20));
		InfoListBox = new JComboBox(InfoList);
		InfoListBox.setFont(new Font("PT Sans", Font.PLAIN, 15));
		InfoListBox.setBackground(UIManager.getColor("ComboBox.background"));
		
		
		
		InfoListBox.addActionListener(this);
		doneButton = new JButton("I'm Done!");
		doneButton.setFont(new Font("PT Sans", Font.PLAIN, 20));
		doneButton.setBackground(new Color(153, 102, 204));
		doneButton.addActionListener(this);
		doneButton.setSize(100, 100);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(doneButton, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
							.addGap(171))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(InfoListBox, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
							.addComponent(MiddlePanelofThree, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
							.addGap(15))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(NeedInfo)
							.addGap(99))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addComponent(NeedInfo)
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(InfoListBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(MiddlePanelofThree, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
					.addComponent(doneButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(72))
		);
		GroupLayout gl_MiddlePanelofThree = new GroupLayout(MiddlePanelofThree);
		gl_MiddlePanelofThree.setHorizontalGroup(
			gl_MiddlePanelofThree.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_MiddlePanelofThree.createSequentialGroup()
					.addContainerGap()
					.addComponent(InfoDescription, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		gl_MiddlePanelofThree.setVerticalGroup(
			gl_MiddlePanelofThree.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_MiddlePanelofThree.createSequentialGroup()
					.addComponent(InfoDescription, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		MiddlePanelofThree.setLayout(gl_MiddlePanelofThree);
		setLayout(groupLayout);
		
		updateText();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		//check if the action is from the info list box
		if(event.getSource().equals(InfoListBox))
		{
			
			updateText();
		}
		
		//else source is the i'm done button
		else
		{
			//Redirect users to dashboard
			
			((MyHealthRemake)(this.getParent().getParent())).backToDash();
		}
		
		
	}
	
	
	public void updateText()
	{
		InfoDescription.setText(descriptionList[InfoListBox.getSelectedIndex()]);

			
	}
	
	
	
}
