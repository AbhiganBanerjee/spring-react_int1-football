package in.spring.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
	
	//Create a method to generate documentation
	//This will generate documentation for the in.spring.rest package classes
	public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
            .group("spring-public")
            .packagesToScan("in.spring.rest")
            .build();
    }
}