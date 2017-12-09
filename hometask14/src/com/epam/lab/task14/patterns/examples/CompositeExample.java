package com.epam.lab.task14.patterns.examples;

import com.epam.lab.task14.patterns.composite.CompoundTravelTour;
import com.epam.lab.task14.patterns.composite.Tour;
import com.epam.lab.task14.patterns.composite.TravelTour;

public class CompositeExample {

	public void runTourExample() {
		Tour myTour = createTourWithTwoLevels();
		myTour.showAllInfo();		
		Tour yourTour=createTourWithThreeLevels();
		yourTour.showAllInfo();
	}

	private Tour createTourWithTwoLevels() {
		CompoundTravelTour basicTour = new CompoundTravelTour();
		basicTour.setName("Europe");
		basicTour.add(new TravelTour("London", "walk in London", 200));
		basicTour.add(new TravelTour("Paris", "to Elfel tower", 300));
				return basicTour;
	}
	private Tour createTourWithThreeLevels() {
		CompoundTravelTour basicTour = new CompoundTravelTour();
		basicTour.setName("Europe");
				
		CompoundTravelTour subTourEngland=new CompoundTravelTour();
		subTourEngland.setName("England");
		subTourEngland.add((new TravelTour("London", "Walk in London", 200)));
		subTourEngland.add((new TravelTour("Manchester", "Go to football match", 300)));
		subTourEngland.add((new TravelTour("Themsa", "Swim in themsa", 100)));
		basicTour.add(subTourEngland);
		
		CompoundTravelTour subTourFrance=new CompoundTravelTour();
		subTourFrance.setName("France");
		subTourFrance.add((new TravelTour("Provance", "Wisit restaurants", 400)));
		subTourFrance.add((new TravelTour("Paris", "Climb up Eufels tower", 500)));	
		basicTour.add(subTourFrance);
		
		TravelTour tourOpera=new TravelTour();
		tourOpera.setName("Widenska opera");
		tourOpera.setDescription("Wisit opera house");
		tourOpera.setPrice(55);
		basicTour.add(tourOpera);
		return basicTour;
	}
	
}
