package mirosimo.examples.propertieex;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//https://devwithus.com/spring-boot-configuration-properties/

//@Configuration
@Component
@ConfigurationProperties(prefix = "colors")
public class AppSetupProperties2 {
	private String background;
	private String title;
	private String text;
	
	public String getBackground() {
		return background;
	}
	public void setBackground(String background) {
		this.background = background;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}
