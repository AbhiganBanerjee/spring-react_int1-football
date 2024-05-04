package in.spring.service;

import java.util.List;

import in.spring.documents.FootballTeams;

public interface FootballService {
	//Add a method to insert footballTeam 
	void addTeam(FootballTeams ft);
	
	//Add a method to get footballTeam details
	List<FootballTeams> getTeams(String nation);
}
