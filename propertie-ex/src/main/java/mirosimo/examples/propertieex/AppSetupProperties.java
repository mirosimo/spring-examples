package mirosimo.examples.propertieex;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/*
 * Example for injecting vlaues from propeerties file using @Value annotation
 * 
 */
@Component
@PropertySource("classpath:mirosimo.properties")
public class AppSetupProperties {
	@Value("${app.name}")
	private String name;
	
	@Value("${app.backuptimes}")
	private String[] backupTimes;
	
	/*
	 * Default value behind colon 
	 * 
	 * */
	@Value("${app.colorvariant:green}")
	private String colorVariant;

	/*
	 * We can also use constructor for injecting the values from property file. 
	 * 
	 * */	
	/*public AppSetupProperties(@Value("${app.name}") String name, 
	@Value("${app.backuptimes}") String[] backupTimes,
	@Value("${app.colorvariant}") String colorVariant) {

	this.name = name;
	this.backupTimes = backupTimes;
	this.colorVariant = colorVariant;
	}*/
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getColorVariant() {
		return colorVariant;
	}

	public void setColorVariant(String colorVariant) {
		this.colorVariant = colorVariant;
	}

	public String[] getBackupTimes() {
		return backupTimes;
	}

	public void setBackupTimes(String[] backupTimes) {
		this.backupTimes = backupTimes;
	}			
}
