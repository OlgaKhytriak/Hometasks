package com.epam.lab.task15.patterns;

import java.io.IOException;

import com.epam.lab.task15.patterns.examples.*;

public class StartApplication {
	public static void main(String[] args) throws Exception {
		useBridgePatterns();
		useDecoratorPatterns();
		useFacadePatterns();
		useStrategyPatterns();
		
	}

	private static void useBridgePatterns() {
		System.out.println("---------- Bridge Example ------------------------------------");
		BridgeExample bridgeExamples = new BridgeExample();
		bridgeExamples.useBridge();
		
	}
	private static void useDecoratorPatterns() {
		System.out.println("---------- Decorator Example ------------------------------------");
		DecoratorExample decoratorExample = new DecoratorExample();
		decoratorExample.useDecorator();
		
	}
	private static void useFacadePatterns() {
		FacadeExample facadeExample = new FacadeExample();
		System.out.println("---------- Facade Example ------------------------------------");
		
	}
	private static void useStrategyPatterns() {
		System.out.println("---------- Strategy Example ------------------------------------");
		StrategyExample strategyExample = new StrategyExample();
		strategyExample.useStrategy();
	}



}
