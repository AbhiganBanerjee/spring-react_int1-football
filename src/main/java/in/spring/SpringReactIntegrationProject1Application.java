package in.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringReactIntegrationProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringReactIntegrationProject1Application.class, args);
	}

}
