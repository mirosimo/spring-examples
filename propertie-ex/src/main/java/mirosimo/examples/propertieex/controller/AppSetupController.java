package mirosimo.examples.propertieex.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mirosimo.examples.propertieex.AppSetupProperties;
import mirosimo.examples.propertieex.AppSetupProperties2;
import mirosimo.examples.propertieex.AppSetupProperties3;

@RestController
public class AppSetupController {
	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private AppSetupProperties appSetupProperties;
	
	@Autowired
	private AppSetupProperties2 appSetupProperties2;
	
	@Autowired
	private AppSetupProperties3 appSetupProperties3;
	
	/* 
	 * End point for getting injecting values from application.properties
	 * Using: @Value 
	 * 
	 * */
	@GetMapping("/get-app-info")
	public String getAppInfo() {		
		//AppSetupProperties appSetup = applicationContext.getBean(AppSetupProperties.class);
		
		System.out.println("Properties source: "+appSetupProperties.getSource());
        System.out.println("Application name: "+appSetupProperties.getName());
        System.out.println("Color variant: "+appSetupProperties.getColorVariant());        
        new ArrayList<String>(Arrays.asList(appSetupProperties.getBackupTimes())).stream().forEach(p -> System.out.println("Zaloha:" + p));        
		return appSetupProperties.getName();
	}
	
	
	/* 
	 * End point for getting injecting values from mirosimo.properties
	 * Using: @Value 
	 * 
	 * */
	@GetMapping("/get-app-info2")
	public String getAppInfo2() {				
		System.out.println("Properties source: "+appSetupProperties2.getSource());
        System.out.println("Application name: "+appSetupProperties2.getName());
        System.out.println("Color variant: "+appSetupProperties2.getColorVariant());
        new ArrayList<String>(Arrays.asList(appSetupProperties2.getBackupTimes())).stream().forEach(p -> System.out.println("Zaloha:" + p));
		return appSetupProperties2.getName();
	}
	
	
	/* 
	 * End point for getting injecting values from application.properties
	 * Using: @ConfigurationProperties
	 * 
	 * */
	@GetMapping("/get-app-info3")
	public String getAppInfo3() {		
		
		System.out.println("Properties source: "+appSetupProperties3.getSource());
        System.out.println("Application name: "+appSetupProperties3.getName());
        System.out.println("Color variant: "+appSetupProperties3.getColorVariant());
        new ArrayList<String>(Arrays.asList(appSetupProperties3.getBackupTimes())).stream().forEach(p -> System.out.println("Zaloha:" + p));
        System.out.println("Bottom part background: "+appSetupProperties3.getBottomPart().getBackgroundColor());
        System.out.println("Bottom part design: "+appSetupProperties3.getBottomPart().getDesign());
        System.out.println("Bottom part orientation: "+appSetupProperties3.getBottomPart().getOrientation());
        
		return appSetupProperties3.getName();
	}
}
