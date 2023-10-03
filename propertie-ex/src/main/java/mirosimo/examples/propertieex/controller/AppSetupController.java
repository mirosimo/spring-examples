package mirosimo.examples.propertieex.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mirosimo.examples.propertieex.AppSetupProperties;

@RestController
public class AppSetupController {
	@Autowired
	private ApplicationContext applicationContext;
	
	@GetMapping("/get-app-info")
	public String getAppInfo() {
		
		AppSetupProperties appSetup = applicationContext.getBean(AppSetupProperties.class);
        System.out.println("Application name: "+appSetup.getName());
        System.out.println("Color variant: "+appSetup.getColorVariant());
        new ArrayList<String>(Arrays.asList(appSetup.getBackupTimes())).stream().forEach(p -> System.out.println("Zaloha:" + p));
		return appSetup.getName();
	}
}
