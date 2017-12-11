package com.epam.lab.task15.patterns.bridge;

public class Bicycle implements Vehicle{

	public void moveRight() {
		System.out.println("Bicycle is turning to right");		
	}

	public void moveLeft() {
		System.out.println("Bicycle is turning to left");		
	}

	public void moveStraight() {
		System.out.println("Bicycle is moving straight");		
	}

}
