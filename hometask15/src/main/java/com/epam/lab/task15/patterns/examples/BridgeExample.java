package com.epam.lab.task15.patterns.examples;

import com.epam.lab.task15.patterns.bridge.*;

public class BridgeExample {

	public void useBridge() {
		System.out.println("---- Use car with basic helm ----");
		testBasicHelm(new Car());
		System.out.println("---- Use ship with hydraulic wheel ----");
		testHydraulicHelm(new Ship());
	}
	
	private void testBasicHelm(Vehicle vehicle) {
		BasicHelm basicHelm= new BasicHelm(vehicle);
		basicHelm.turnLeft();
		basicHelm.keepPosition();
		basicHelm.turnRight();
	}
	private void testHydraulicHelm(Vehicle vehicle) {
		HydraulicWheel hydraulicWheel= new HydraulicWheel(vehicle);
		hydraulicWheel.turnRight();
		hydraulicWheel.keepPosition();
		hydraulicWheel.turnLeft();
	}
}
