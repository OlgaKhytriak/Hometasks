package com.epam.lab.task14.patterns.composite;

import java.util.ArrayList;
import java.util.List;

public class CompoundTravelTour implements Tour {
	private String name;
	private String description;
	private int price;
	private List<Tour> internalTours;

	public CompoundTravelTour() {
		internalTours = new ArrayList<Tour>();
	}

	public void add(Tour tour) {
		internalTours.add(tour);
	}

	public void remove(Tour tour) {
		internalTours.remove(tour);
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		String rez = String.format("");
		for (Tour tour : internalTours) {
			rez = String.format("%s \n%s: %s - %s $;", rez, tour.getName(),tour.getDescription(),tour.getPrice());
		}
		setDescription(rez);
		return rez;
	}

	@Override
	public int getPrice() {
		int sumPrice = 0;
		for (Tour tour : internalTours) {
			sumPrice = sumPrice + tour.getPrice();
		}
		setPrice(sumPrice);
		return sumPrice;
	}

	@Override
	public void showAllInfo() {
		System.out.println();
		System.out.println(String.format("TOUR NAME: %s", this.getName()));
		System.out.println(String.format("TOUR DESCRIPTION: %s", this.getDescription()));
		System.out.println(String.format("TOUR FULL PRICE: %s", this.getPrice()));
	}

	private void setPrice(int price) {
		this.price = price;
	}

	public List<Tour> getInternalTours() {
		return internalTours;
	}

	public void setInternalTours(List<Tour> internalTours) {
		this.internalTours = internalTours;
	}

	private void setDescription(String description) {
		this.description = description;
	}

}
