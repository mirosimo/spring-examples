package mirosimo.examples.profiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProfilesApplication {

	public static void main(String[] args) {		 
		 //SpringApplication.run(ProfilesApplication.class, args);
		SpringApplication app= new SpringApplication(ProfilesApplication.class);
		app.setAdditionalProfiles("dev_ora");
		app.run(args);		 
	}

}
