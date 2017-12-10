package com.epam.lab.task15.patterns.strategy;

import java.util.concurrent.ThreadLocalRandom;

import com.epam.lab.task15.patterns.strategy.models.*;

public class RandomDroidChooser implements DroidChooser {
	private Team<?> team;

	public RandomDroidChooser(Team<?> team) {
		setTeam(team);
	}

	public SimpleDroid choose() {
		int max = team.getTeam().size();
		int index = ThreadLocalRandom.current().nextInt(0, max);
		return (SimpleDroid) team.getTeam().get(index);
	}

	public Team<?> getTeam() {
		return team;
	}

	public void setTeam(Team<?> team) {
		this.team = team;
	}

}
