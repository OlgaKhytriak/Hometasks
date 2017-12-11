package com.epam.lab.task15.patterns.examples;

import com.epam.lab.task15.patterns.decorator.*;

public class DecoratorExample {

	public void useDecorator() {
		Girl superGirl=new Manicure(new Hairdress(new Makeup(new SimpleGirl())));
		superGirl.decorate();
	}
}
