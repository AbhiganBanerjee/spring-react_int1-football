package in.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.spring.documents.FootballTeams;
import in.spring.repo.FootballRepository;

@Service
public class FootballServiceImpl implements FootballService {

	//Inject the Repository reference 
	@Autowired
	private FootballRepository repo;
	
	@Override
	public void addTeam(FootballTeams ft) {
		//Add the football team in mongodb collection
		repo.save(ft);
	}

	@Override
	public List<FootballTeams> getTeams(String nation) {
		
		//if nation is all then return all the teams
		if(nation.equalsIgnoreCase("all")) {
			return repo.findAll();
		}
		else {
			//It will retrieve clubs from specific nation passed as param
			return repo.findByNation(nation);
		}
	}

}
