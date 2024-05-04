package in.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.spring.documents.RegUser;
import in.spring.repo.RegUserRepository;

@Service
public class RegUserServiceImpl implements RegUserService {
	//Inject the RegUserRepository reference
	@Autowired
	private RegUserRepository regRepo;
	
	//This method will register user in mongodb database
	@Override
	public RegUser addNewUser(RegUser ru) {
		//Save the ru object in MongoDB, and return the added object
		return regRepo.save(ru);
	}
	
	//This method will find all List of RegUsers
	@Override
	public List<RegUser> getAllUser() {
		//Retrieve all the RegUser from collection
		return regRepo.findAll();
	}
}
