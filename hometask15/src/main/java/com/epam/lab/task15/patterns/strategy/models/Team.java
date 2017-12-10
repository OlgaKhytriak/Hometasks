package com.epam.lab.task15.patterns.strategy.models;

import java.util.ArrayList;
import java.util.List;

public class Team<T extends Droid> {
	private List<T> team;

	public List<T> getTeam() {
		return team;
	}

	public void setTeam(List<T> team) {
		this.team = team;
	}

	public Team() {
		team=new ArrayList<T>();
	}

	public void put(T droid) {
		team.add(droid);
	}

	public void get(T droid) {
		team.remove(droid);
	}



}
