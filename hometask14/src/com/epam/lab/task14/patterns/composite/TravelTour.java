package com.epam.lab.task14.patterns.composite;

public class TravelTour implements Tour{
private String name;
private String description;
private int price;

public TravelTour(){}

public TravelTour(String name,String description,int price){	
	this.name=name;
	this.description=description;
	this.price=price;
}

	@Override
	public String getName() {		
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public int getPrice() {
		return price;
	}

	
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPrice(int price) {
	this.price = price;
}

	@Override
	public void showAllInfo() {
		System.out.println(	String.format("TOUR NAME: %s",this.getName()));
		System.out.println(	String.format("TOUR DESCRIPTION: %s",this.getDescription()));
		System.out.println(String.format("TOUR FULL PRICE: %s",this.getPrice()));
}

}
