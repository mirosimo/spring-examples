package mirosimo.examples.propertieex;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


/*
 * Into this bean are injected vlaues from propeerties file using @Value annotation
 * Property source is: mirosimo.properties --> @PropertySource("classpath:mirosimo.properties")
 * 
 * Be careful - when would be the same property name defined in application.properties, than the property 
 * from application.properties would have priority 
 * Reason why: Property type order --> properties types with higer order have a priority - look into official documentation.
 * https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#features.external-config
 * - section Externalized Configuration
 * 
 */
@Component
@PropertySource("classpath:mirosimo.properties")
public class AppSetupProperties2 {
	
	@Value("${app.source2}")
	private String source;
	
	@Value("${app.name2}")
	private String name;
	
	@Value("${app.backuptimes2}")
	private String[] backupTimes;
	
	/*
	 * Default value behind colon 
	 * 
	 * */
	@Value("${app.colorvariant2:green}")
	private String colorVariant;

	/*
	 * We can also use constructor for injecting values from property file. 
	 * 
	 * */	
	/*public AppSetupProperties(
	 	@Value("${app.name2}") String name, 
	 	@Value("${app.source2}") String source,
		@Value("${app.backuptimes2}") String[] backupTimes,
		@Value("${app.colorvariant2}") String colorVariant) {

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
