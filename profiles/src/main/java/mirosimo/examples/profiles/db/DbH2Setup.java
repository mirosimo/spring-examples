package mirosimo.examples.profiles.db;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev_h2")
public class DbH2Setup implements DbSetup {
	public String setup() {
		return "Setup for H2";
	}
}
