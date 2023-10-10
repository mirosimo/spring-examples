package mirosimo.examples.propertieex;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
 * Into this bean are injected vlaues from propeerties file using @Value annotation
 * Property source is: application.properties
 * 
 */
@Component
public class AppSetupProperties {
	
	@Value("${app.source}")
	private String source;
	
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
	 * We can also use constructor for injecting values from property file. 
	 * 
	 * */	
	/*public AppSetupProperties(
	 	@Value("${app.name}") String name, 
	 	@Value("${app.source}") String source,
		@Value("${app.backuptimes}") String[] backupTimes,
		@Value("${app.colorvariant}") String colorVariant) {

	this.name = name;
	this.backupTimes = backupTimes;
	this.colorVariant = colorVariant;
	this.source = source;
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

	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}			
}
