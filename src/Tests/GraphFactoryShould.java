package Tests;

import graphGenerators.BarGraphMaker;
import graphGenerators.LineGraphFactory;

import java.awt.GridLayout;

import javax.swing.JFrame;

import org.junit.Test;

import Control.AccountControl;
import Tests.TestDoubles.AccountControlStub;

public class GraphFactoryShould {

	@Test
	public void getCharts() {
		
		//fix factories
		JFrame frame = new JFrame();
		
		final long startTime = System.currentTimeMillis();
		
		AccountControl control = new AccountControlStub();
		
		LineGraphFactory factory = new LineGraphFactory(control);
		BarGraphMaker factory1 = new BarGraphMaker(control);

		frame.setLayout(new GridLayout(6, 4));
		
		frame.add(factory.getWeekWeightGraph());
		frame.add(factory.getMonthWeightGraph());
		frame.add(factory.getYearWeightGraph());
		frame.add(factory.getAllTimeWeightGraph());
		frame.add(factory.getWeekCalorieGraph());
		frame.add(factory.getMonthCalorieGraph());
		frame.add(factory.getYearCalorieGraph());
		frame.add(factory.getAllTimeCalorieGraph());
		frame.add(factory.getWeekSleepGraph());
		frame.add(factory.getMonthSleepGraph());
		frame.add(factory.getYearSleepGraph());
		frame.add(factory.getAllTimeSleepGraph());
		frame.add(factory.getWeekExerciseGraph());
		frame.add(factory.getMonthExerciseGraph());
		frame.add(factory.getYearExerciseGraph());
		frame.add(factory.getAllTimeExerciseGraph());
		
		frame.add(factory1.makeBMIBarGraph());
		frame.add(factory1.makeWeightBarGraph());
		frame.add(factory1.makeSleepBarGraph());
		frame.add(factory1.makeCalorieBarGraph());
		frame.add(factory1.makeExerciseBarGraph());
		
		frame.setVisible(true);
		frame.setSize(900, 400);
		final long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}	
}



