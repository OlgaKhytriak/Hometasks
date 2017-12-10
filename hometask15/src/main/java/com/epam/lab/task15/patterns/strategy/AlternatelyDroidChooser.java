package com.epam.lab.task15.patterns.strategy;

import com.epam.lab.task15.patterns.strategy.models.*;

public class AlternatelyDroidChooser implements DroidChooser {
	private Team<SimpleDroid> team;
	int current;
	int next;

	public AlternatelyDroidChooser(Team<SimpleDroid> team) {
		setTeam(team);
		current=-1;
	}

	public SimpleDroid choose() {
		SimpleDroid droid = null;
		if (current<(team.getTeam().size()-1)) {
		next = current+1;}
		else next=0;
		droid = (SimpleDroid) team.getTeam().get(next);
		current=next;
		return droid;
	}

	public Team<SimpleDroid> getTeam() {
		return team;
	}

	public void setTeam(Team<SimpleDroid> team) {
		this.team = team;
	}

}