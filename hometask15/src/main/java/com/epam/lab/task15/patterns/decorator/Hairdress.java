package com.epam.lab.task15.patterns.decorator;

public class Hairdress extends GirlDecorator {

	public Hairdress(Girl girl) {
		super(girl);
	}

	@Override
	public void decorate() {
		super.decorate();
		System.out.println("Girl has got a beautifull HAIRDRESS");

	}

}
