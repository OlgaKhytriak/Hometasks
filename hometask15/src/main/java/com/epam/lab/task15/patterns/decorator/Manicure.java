package com.epam.lab.task15.patterns.decorator;

public class Manicure extends GirlDecorator{

	public Manicure(Girl girl) {
		super(girl);
	}

	@Override
	public void decorate() {
		super.decorate();
		System.out.println("Girl has got a impressive MANICURE");

	}
}
