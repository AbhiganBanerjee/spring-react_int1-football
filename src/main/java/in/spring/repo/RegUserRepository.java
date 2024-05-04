package in.spring.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.spring.documents.RegUser;

public interface RegUserRepository extends MongoRepository<RegUser,String>{
	
}
