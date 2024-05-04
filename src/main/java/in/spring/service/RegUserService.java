package in.spring.service;

import java.util.List;

import in.spring.documents.RegUser;

public interface RegUserService {
	//method to insert RegUser object in mongodb collection
	RegUser addNewUser(RegUser ru);
	
	//method to return all the RegUser from collection
	List<RegUser> getAllUser();
}
