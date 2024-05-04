package in.spring.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//This document class will be used to register users
@Document(collection = "RegUser")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegUser {
	@Id
	private String _id;
	
	private String userName;
    private String password;
    private Integer age;
    private String nation;
    private Boolean subscribed;
}
