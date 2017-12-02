package com.epam.patterns.singleton;

import java.util.List;

public class Game {
private static Game game=null;
private Game() {}
private String name;
private List<String> teamList;

public List<String> getTeamList() {
	return teamList;
}

public void setTeamList(List<String> teamList) {
	this.teamList = teamList;
}

public static Game getInstance() {
	if (game==null) {
		game =new Game();
	}
	return game;
	
}

public String toString() {
	StringBuilder rez=new StringBuilder();
	rez.append("Game: ").append(name).append("; Teams: ");
	String teamsNames=teamList.toString();
	rez.append(teamsNames);
	return rez.toString();
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
}
