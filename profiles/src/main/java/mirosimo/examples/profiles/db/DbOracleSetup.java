package mirosimo.examples.profiles.db;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev_ora")
public class DbOracleSetup implements DbSetup {
	public String setup() {
		return "Setup for Oracle";
	}
}
