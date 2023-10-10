package mirosimo.examples.propertieex;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix="app")
public class AppSetupProperties3 {	

	private String source;
	private String name;
	private String[] backupTimes;
	private String colorVariant;
	private final BottomPart bottomPart = new BottomPart();
	
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

	public BottomPart getBottomPart() {
		return bottomPart;
	}
	
	public static class BottomPart {
		private String backgroundColor;
		private String orientation;
		private String design;
		
		public String getBackgroundColor() {
			return backgroundColor;
		}
		public void setBackgroundColor(String backgroundColor) {
			this.backgroundColor = backgroundColor;
		}
		
		public String getOrientation() {
			return orientation;
		}
		public void setOrientation(String orientation) {
			this.orientation = orientation;
		}
		
		public String getDesign() {
			return design;
		}
		public void setDesign(String design) {
			this.design = design;
		}				
	}


}
