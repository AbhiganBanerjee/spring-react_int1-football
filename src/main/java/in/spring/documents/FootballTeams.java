package in.spring.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "FootballTeams")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FootballTeams {
	@Id
	private String _id;
	
	private String name;
	private String estd;
	private String[] trophies;
	private String[] legends;
	private String nation;
	private String legLogo;
	private String image;
}	
