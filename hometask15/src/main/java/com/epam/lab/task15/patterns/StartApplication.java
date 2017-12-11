package com.epam.lab.task15.patterns;

import com.epam.lab.task15.patterns.facade.ExamplesFacade;

public class StartApplication {
	public static void main(String[] args) throws Exception {
		ExamplesFacade examplesFacade = new ExamplesFacade();
		examplesFacade.useBridgePattern();
		examplesFacade.useDecoratorPattern();
		examplesFacade.useStrategyPattern();
	}

}
