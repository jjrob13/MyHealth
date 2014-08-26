package Tests;

import javax.swing.JPanel;

import org.junit.Test;

import Model.Report;

public class ReportShould {
	
	@Test
	public void createNewReport() {
		Report report = new Report("jjrob13", "All Time Calorie Graph", new JPanel());
		System.out.println(report);
	}

}
