package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Control.MeasurementTypeControl;

public class MeasurementTypeControlShould {

	@Test
	public void test() {
		MeasurementTypeControl control = new MeasurementTypeControl("sleep");
		
		assertTrue(control.getUnits().equals("hours"));
	}

}
