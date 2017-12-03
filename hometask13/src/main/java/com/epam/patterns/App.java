package com.epam.patterns;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.patterns.factory.FutureEraUnitsFactory;
import com.epam.patterns.factory.IndustrialEraUnitsFactory;
import com.epam.patterns.factory.ModernEraUnitsFactory;
import com.epam.patterns.factory.SquadCreator;
import com.epam.patterns.factorymethod.WeaponCreator;
import com.epam.patterns.models.units.interfaces.Unit;
import com.epam.patterns.models.units.landunits.Infantryman;
import com.epam.patterns.models.units.landunits.Robot;
import com.epam.patterns.models.units.landunits.SampleLandUnit;
import com.epam.patterns.models.units.landunits.Tank;
import com.epam.patterns.singleton.Game;

public class App {
	private static final Logger LOG = Logger.getLogger(App.class);

	public static void main(String[] args) throws Exception {
		System.out.println("--- singletonExample ---");
		singletonExample();
		System.out.println("--- abstarctFactoryExample ---");
		abstarctFactoryExample();
		System.out.println("--- factoryMathodExample ---");
		factoryMathodExample();
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

	public static void factoryMathodExample() throws Exception {
		useFactoryMethod(Infantryman.class);
		useFactoryMethod(Tank.class);
		useFactoryMethod(Robot.class);
	}

	private static void useFactoryMethod(Class<? extends SampleLandUnit> clazz) throws Exception {
		Unit unit = (Unit) clazz.newInstance();
		WeaponCreator weaponCreator = new WeaponCreator();
		unit.setWeapon(weaponCreator.create(unit));
		unit.useWeapon();
	}

	public static void abstarctFactoryExample() {
		SquadCreator squadCreator = new SquadCreator();
		List<Unit> industrialSquad = squadCreator.create(new IndustrialEraUnitsFactory());
		squadFight(industrialSquad);
		List<Unit> modernSquad = squadCreator.create(new ModernEraUnitsFactory());
		squadFight(modernSquad);
		List<Unit> futureSquad = squadCreator.create(new FutureEraUnitsFactory());
		squadFight(futureSquad);
	}

	private static void squadFight(List<Unit> squadList) {
		for (Unit unit : squadList) {
			unit.fight(unit);
		}

	}
}
