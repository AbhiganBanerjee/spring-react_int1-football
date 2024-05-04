package in.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.spring.documents.RegUser;
import in.spring.service.RegUserService;

@RestController
public class RegUserRestController {
	//Inject the RegUserService reference
	@Autowired
	private RegUserService service;
	
	//Create a POST Map Method to Insert the User object from RequestBody
	@PostMapping("/addUser")
	public ResponseEntity<String> registerUser(@RequestBody RegUser ru){
		System.out.println(ru);
		
		//call the service class method to insert ru and get the inserted user
		RegUser user = service.addNewUser(ru);
		
		//Validate the Registered user and based on that return message
		if(user.get_id()!=null) {
			return new ResponseEntity<String>("User Registered Successfully...", HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String>("Registratiin Failed!!", HttpStatus.UNAUTHORIZED);
		}
	}
	
	//Create a GET method to get all registered users as JSON
	@GetMapping("/getUsers")
	public List<RegUser> getUsers(){
		//call the service method 
		return service.getAllUser();
	}
}
