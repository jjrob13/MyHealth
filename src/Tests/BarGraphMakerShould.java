package Tests;

import static org.junit.Assert.*;


import javax.swing.JFrame;

import graphGenerators.BarGraphMaker;

import org.junit.Test;

import Control.AccountControl;
import Tests.TestDoubles.AccountControlStub;

public class BarGraphMakerShould {

	@Test
	public void generateGraphs() {
		AccountControl account = new AccountControlStub();
		account.retrieveFromDataBase(1);
		BarGraphMaker bgMaker = new BarGraphMaker(account);
		
		JFrame frame = new JFrame();
		
		
		frame.getContentPane().add(bgMaker.getAllGraphs());
		frame.setVisible(true);
		
		System.out.println("done");
		assertTrue(true);
	}

}
