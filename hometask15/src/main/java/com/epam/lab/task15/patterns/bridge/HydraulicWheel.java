package com.epam.lab.task15.patterns.bridge;

public class HydraulicWheel extends BasicHelm {

	public HydraulicWheel(Vehicle vehicle) {
		super.vehicle = vehicle;
	}

	public void reinforce() {
		System.out.println("The helm is reinforced");
	}

	@Override
	public void turnLeft() {
		reinforce();
		System.out.println("The HELM is turned to left");
		vehicle.moveRight();

	}

	@Override
	public void turnRight() {
		reinforce();
		System.out.println("The HELM is turned to right");
		vehicle.moveRight();

	}

	@Override
	public void keepPosition() {
		reinforce();
		System.out.println("The HELM is keeping its position");
		vehicle.moveStraight();

	}
}
