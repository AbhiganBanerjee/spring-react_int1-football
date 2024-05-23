package in.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import in.spring.filter.RefreshHeaderFilter;
import jakarta.servlet.FilterRegistration;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

	//Inject the Refresh Filter class object
	@Autowired
    private RefreshHeaderFilter refreshHeaderFilter;
	
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // Allow requests from React app
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }
    
    public void onStartup(ServletContext servletContext) throws ServletException {
        FilterRegistration.Dynamic filterRegistration = servletContext.addFilter("refreshHeaderFilter", refreshHeaderFilter);
        filterRegistration.addMappingForUrlPatterns(null, false, "/*");
    }
}

