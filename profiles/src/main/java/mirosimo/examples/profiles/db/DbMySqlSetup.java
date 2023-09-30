package mirosimo.examples.profiles.db;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev_mysql")
public class DbMySqlSetup implements DbSetup {
	public String setup() {
		return "Setup for MySql";
	}
}
