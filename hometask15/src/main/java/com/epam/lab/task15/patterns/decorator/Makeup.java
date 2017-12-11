package com.epam.lab.task15.patterns.decorator;

public class Makeup extends GirlDecorator{

	public Makeup(Girl girl) {
		super(girl);
	}
	@Override
	public void decorate() {
		super.decorate();
		System.out.println("Girl has got a charming MAKE UP");

	}

}
