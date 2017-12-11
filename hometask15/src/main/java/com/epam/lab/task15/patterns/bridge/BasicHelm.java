package com.epam.lab.task15.patterns.bridge;

public class BasicHelm implements Helm{
	protected Vehicle vehicle;
	
	public BasicHelm() {}
	public BasicHelm(Vehicle vehicle) {
		this.vehicle=vehicle;
	}

	public void turnLeft() {
		System.out.println("The HELM is turned to left");
		vehicle.moveRight();
		
	}

	public void turnRight() {
		System.out.println("The HELM is turned to right");
		vehicle.moveRight();
		
	}

	public void keepPosition() {
		System.out.println("The HELM is keeping its position");
		vehicle.moveStraight();
		
	}

}
