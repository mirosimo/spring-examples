package mirosimo.examples.propertieex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
//@EnableConfigurationProperties(AppSetupProperties3.class)
public class PropertieExApplication {		
	
	public static void main(String[] args) {
		SpringApplication.run(PropertieExApplication.class, args);
	}	
}
