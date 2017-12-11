package com.epam.lab.task15.patterns.bridge;

public class Ship implements Vehicle{

	public void moveRight() {
		System.out.println("Ship is turning to right");		
	}

	public void moveLeft() {
		System.out.println("Ship is turning to left");		
	}

	public void moveStraight() {
		System.out.println("Ship is moving straight");		
	}
}
