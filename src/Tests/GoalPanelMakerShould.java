package Tests;

import static org.junit.Assert.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import graphGenerators.GoalPanelMaker;

import org.junit.Test;

import Control.AccountControl;

public class GoalPanelMakerShould {

	@Test
	public void test() {
		AccountControl account = new AccountControl();
		account.retrieveFromDataBase("jjrob13");
		
		GoalPanelMaker goalPanelMaker = new GoalPanelMaker(account);
		
		JFrame frame = new JFrame();
		
		frame.getContentPane().add(goalPanelMaker.getProgressBarsPanel());
		frame.setVisible(true);
	}

}
