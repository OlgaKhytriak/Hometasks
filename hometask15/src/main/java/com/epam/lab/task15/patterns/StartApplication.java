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
		BridgeExample builderExamples = new BridgeExample();
		System.out.println("---------- Bridge Example ------------------------------------");
		
	}
	private static void useDecoratorPatterns() {
		DecoratorExample decoratorExample = new DecoratorExample();
		System.out.println("---------- Decorator Example ------------------------------------");
		
	}
	private static void useFacadePatterns() {
		FacadeExample facadeExample = new FacadeExample();
		System.out.println("---------- Facade Example ------------------------------------");
		
	}
	private static void useStrategyPatterns() {
		StrategyExample strategyExample = new StrategyExample();
		System.out.println("---------- Strategy Example ------------------------------------");
		strategyExample.useStrategy();
	}



}
