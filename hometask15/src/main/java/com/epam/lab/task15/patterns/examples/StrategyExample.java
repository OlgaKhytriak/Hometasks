package com.epam.lab.task15.patterns.examples;

import com.epam.lab.task15.patterns.strategy.*;
import com.epam.lab.task15.patterns.strategy.models.*;


public class StrategyExample {
	private static final int COUNT_DROIDS=10;
	Team<SimpleDroid> team;
	private  DroidChooser droidChooser;
	
	
	public void useStrategy() {
		createTeam();
		printTeamInfo();
		System.out.println("--- Use RANDOM strategy: -----");
		chooseStrategy(StrategyType.RANDOM);
		for (int i=0;i<COUNT_DROIDS;i++) {
		SimpleDroid simpleDroid = droidChooser.choose();
		System.out.println(simpleDroid.getName());
		}
		System.out.println("--- Use ALTERNATELY strategy: -----");
		chooseStrategy(StrategyType.ALTERNATELY);
		for (int i=0;i<COUNT_DROIDS;i++) {
			SimpleDroid simpleDroid = droidChooser.choose();
			System.out.println(simpleDroid.getName());
			}
	}
	
		
	private void chooseStrategy(StrategyType strategyType) {
		Team<SimpleDroid> team = createTeam();	
		if (strategyType.equals(StrategyType.RANDOM)) {
			setDroidChooser(new RandomDroidChooser(team));
		} else if (strategyType.equals(StrategyType.ALTERNATELY)) {
			setDroidChooser(new AlternatelyDroidChooser(team));
		} else {
			System.out.println("You have chosen incorrect strategy");
			return;
		}

	}
	
	private Team<SimpleDroid> createTeam() {
		team=new Team<SimpleDroid>();
		team.put(new SimpleBattleDroid("Ivan-battle droid",10, 30));
		team.put(new SimpleBattleDroid("Oleg-battle droid",20, 30));
		team.put(new SimpleRepairDroid("Nazar-repair droid",11, 33));
		team.put(new SimpleRepairDroid("Taras-repair droid",33, 55));
		team.put(new SimpleChargeEnergyDroid("Pavlo-charge droid",66, 44));
		team.put(new SimpleChargeEnergyDroid("Petro-charge droid",22, 44));
		return team;
	}
	
	private void printTeamInfo() {
		System.out.println("TEAM LIST:");
		for (SimpleDroid droid:team.getTeam()) {
			System.out.println(droid.getName());
		}
	}

	public DroidChooser getDroidChooser() {
		return droidChooser;
	}

	public void setDroidChooser(DroidChooser droidChooser) {
		this.droidChooser = droidChooser;
	}
}
