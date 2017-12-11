package com.epam.lab.task15.patterns.decorator;

public class GirlDecorator implements Girl{

	protected Girl girl;
	
	public GirlDecorator(Girl girl) {
		this.girl=girl;
	}

	public void decorate() {
		this.girl.decorate();		
	}
	
}
