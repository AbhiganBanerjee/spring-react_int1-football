package in.spring.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.spring.documents.FootballTeams;
import java.util.List;


public interface FootballRepository extends MongoRepository<FootballTeams, String> {
	//It is a findBy method which will only return the
	//Teams which are from the specified nation passed as the argument
	List<FootballTeams> findByNation(String nation);
	
}
