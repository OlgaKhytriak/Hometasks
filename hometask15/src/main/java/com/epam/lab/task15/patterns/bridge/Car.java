package com.epam.lab.task15.patterns.bridge;

public class Car implements Vehicle{

	public void moveRight() {
		System.out.println("Car is turning to right");		
	}

	public void moveLeft() {
		System.out.println("Car is turning to left");		
	}

	public void moveStraight() {
		System.out.println("Car is moving straight");		
	}
}
