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
	private AppSetupProperties3 appSetup;
	
	/* 
	 * End point for getting injecting values from application.properties
	 * Using: @Value 
	 * 
	 * */
	@GetMapping("/get-app-info")
	public String getAppInfo() {
		
		AppSetupProperties appSetup = applicationContext.getBean(AppSetupProperties.class);
        System.out.println("Application name: "+appSetup.getName());
        System.out.println("Color variant: "+appSetup.getColorVariant());        
        new ArrayList<String>(Arrays.asList(appSetup.getBackupTimes())).stream().forEach(p -> System.out.println("Zaloha:" + p));        
		return appSetup.getName();
	}
	
	
	/* 
	 * End point for getting injecting values from mirosimo.properties
	 * Using: @Value 
	 * 
	 * */
	@GetMapping("/get-app-info2")
	public String getAppInfo2() {
		
		AppSetupProperties2 appSetup = applicationContext.getBean(AppSetupProperties2.class);
		
		System.out.println("Properties source: "+appSetup.getSource());
        System.out.println("Application name: "+appSetup.getName());
        System.out.println("Color variant: "+appSetup.getColorVariant());
        new ArrayList<String>(Arrays.asList(appSetup.getBackupTimes())).stream().forEach(p -> System.out.println("Zaloha:" + p));
		return appSetup.getName();
	}
	
	
	/* 
	 * End point for getting injecting values from application.properties
	 * Using: @ConfigurationProperties
	 * 
	 * */
	@GetMapping("/get-app-info3")
	public String getAppInfo3() {		
		
		System.out.println("Properties source: "+appSetup.getSource());
        System.out.println("Application name: "+appSetup.getName());
        System.out.println("Color variant: "+appSetup.getColorVariant());
        new ArrayList<String>(Arrays.asList(appSetup.getBackupTimes())).stream().forEach(p -> System.out.println("Zaloha:" + p));
        System.out.println("Bottom part background: "+appSetup.getBottomPart().getBackgroundColor());
        System.out.println("Bottom part design: "+appSetup.getBottomPart().getDesign());
        System.out.println("Bottom part orientation: "+appSetup.getBottomPart().getOrientation());
        
		return appSetup.getName();
	}
}
