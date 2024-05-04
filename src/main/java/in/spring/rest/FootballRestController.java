package in.spring.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import in.spring.documents.FootballTeams;
import in.spring.service.FootballService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class FootballRestController {
	//Inject the Service Reference
	@Autowired
	private FootballService service;
	
	//Create a POST Mapped method to insert football team
	@PostMapping("/addTeam")
	public ResponseEntity<String> insertTeam(@RequestBody FootballTeams ft) {
		System.out.println(ft);
		
		//Call service method to add ft in MongoDB
		service.addTeam(ft);
		
		//return a 201 code with success msg
		return new ResponseEntity<>("Team Saved...",HttpStatus.CREATED);
	}
	
	//Create a GET method, to get the teams from a nation passed as query-param
	@GetMapping("/getTeams")
	public List<FootballTeams> getTeamsByNation(@RequestParam("nation") String nation) {
		//Call the service method
		return service.getTeams(nation);
	}
	
	//Create a GET method, to return only the list of nations as String[]
	@GetMapping("/getNations")
	public List<String> getNations(){
		//Create a String[] of nations
		String[] nations = {"india","england","spain","germany","italy","france","dutch","turkey"};
	
		//Create this String[] as a list and return it
		return Arrays.asList(nations);
	}
	
	//Create a GET method, te retrive List of trophies based on nation
	@GetMapping("/getTrophies")
	public List<List<String>> getTrophies(@RequestParam("nation") String nation){
		//First get the FootballTeams object by nation
		List<FootballTeams> teams = service.getTeams(nation);
		
		//Create an ArrayList to store the trophies array
		List<List<String>> trophyList = new ArrayList<List<String>>();
		
		//For each of the teams add the trophies array in an arrayList
		for(FootballTeams team : teams) {
			//Get and add the trophy using getter
			trophyList.add(Arrays.asList(team.getTrophies()));
		}
		
		//return the trophyList
		return trophyList;
	}
	
	//Similarly create another method to get the Legends array 
	@GetMapping("/getLegends")
	public List<List<String>> getLegends(@RequestParam("nation") String nation){
		//First get the FootballTeams object by nation
		List<FootballTeams> teams = service.getTeams(nation);
		
		//Create an ArrayList to store the legends array
		List<List<String>> legendsList = new ArrayList<List<String>>();
		
		//For each of the teams add the legends array in an arrayList
		for(FootballTeams team : teams) {
			//Get and add the legends using getter
			legendsList.add(Arrays.asList(team.getLegends()));
		}
		
		//return the legendsList
		return legendsList;
	}
}

/*
{
    "name" : "Mohun Bagan AC",
    "estd" : "15 August 1889",
    "trophies" : ["14 Federation Cups","6 NFL/I-League/ISL","1 ISL Shield"],
    "legends" : ["Goshta Pal", "Sony Norde", "Prabir Das", "Dimi Petratos"],
    "nation" : "india",
    "image" : "https://i.pinimg.com/originals/63/08/60/6308606694cdecd847971a6fb2b3234c.jpg"
}
*/