package com.epam.lab.task15.patterns.facade;

import com.epam.lab.task15.patterns.examples.BridgeExample;
import com.epam.lab.task15.patterns.examples.DecoratorExample;
import com.epam.lab.task15.patterns.examples.StrategyExample;

public class ExamplesFacade implements Examples{
	public ExamplesFacade(){
		System.out.println("----------!!! To run all examples Facade is uses--------");
	}

	public  void useBridgePattern() {
		System.out.println("---------- Bridge Example ------------------------------------");
		BridgeExample bridgeExamples = new BridgeExample();
		bridgeExamples.useBridge();		
	}
	public  void useDecoratorPattern() {
		System.out.println("---------- Decorator Example ------------------------------------");
		DecoratorExample decoratorExample = new DecoratorExample();
		decoratorExample.useDecorator();
		
	}	
	public void useStrategyPattern() {
		System.out.println("---------- Strategy Example ------------------------------------");
		StrategyExample strategyExample = new StrategyExample();
		strategyExample.useStrategy();
	}
}
