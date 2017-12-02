package com.epam.patterns;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.patterns.factory.FutureEraUnitsFactory;
import com.epam.patterns.factory.IndustrialEraUnitsFactory;
import com.epam.patterns.factory.ModernEraUnitsFactory;
import com.epam.patterns.factory.SquadCreator;
import com.epam.patterns.singleton.Game;
import com.epam.patterns.units.interfaces.Unit;

public class App {
	private static final Logger LOG = Logger.getLogger(App.class);

	public static void main(String[] args) throws Exception {
		singletonExample();
		abstarctFactoryExample();
	}

	public static void singletonExample() {
		Game newGame = Game.getInstance();
		newGame.setName("BIG BATTLE");
		List<String> teams = new ArrayList<String>();
		teams.add("Earth");
		teams.add("Mars");
		newGame.setTeamList(teams);
		LOG.info(newGame.toString());
	}

	public static void abstarctFactoryExample() {
		SquadCreator squadCreator = new SquadCreator();		
		List<Unit> industrialSquad=squadCreator.create(new IndustrialEraUnitsFactory());
		squadFight(industrialSquad);
		List<Unit> modernSquad=squadCreator.create(new ModernEraUnitsFactory());
		squadFight(modernSquad);
		List<Unit> futureSquad=squadCreator.create(new FutureEraUnitsFactory());
		squadFight(futureSquad);
	}
	
	private static void squadFight(List<Unit> squadList) {
		for(Unit unit:squadList) {
			unit.fight(unit);
		}
		
	}
}
