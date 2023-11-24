package mirosimoexamples.scope.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mirosimoexamples.scope.car.Car;

@RestController
public class CarController {
	
	private Car carMercedes;
	
	private Car carMercedes2;
	
	private Car carRenault;
	
	private Car carRenault2;
	
	@Autowired
	@Qualifier("mercedes")
	public void setCarMercedes(Car carMercedes) {
		this.carMercedes = carMercedes;
	}
	
	@Autowired
	@Qualifier("mercedes")
	public void setCarMercedes2(Car carMercedes2) {
		this.carMercedes2 = carMercedes2;
	}
	
	@Autowired
	@Qualifier("renault")
	public void setCarRenault(Car carRenault) {
		this.carRenault = carRenault;
	}
	
	@Autowired
	@Qualifier("renault")
	public void setCarRenault2(Car carRenault2) {
		this.carRenault2 = carRenault2;
	}
	
	
	
	@GetMapping("/change-color")
	public void changeColor() {
		/* 
		 * Mercedes - Singelton
		 * 
		 * In Spring Container One instance of bean with name mercedes.
		 * Both of properties carMercedes and carMercedes2 are linked to this instance. 
		 * 
		 * */
		System.out.println("Original Color Mercedes: "+carMercedes.getColor());
		carMercedes.setColor("Green");
		System.out.println("New Color Mercedes: "+carMercedes.getColor());
				
		System.out.println("Color Mercedes 2: "+carMercedes2.getColor());
		
		/* 
		 * Renault - Prototype 
		 * 
		 * In Spring Container Two instance of bean with name renault.
		 * Each of property carRenault and carRenault2 is linked to its own instance. 
		 * 
		 * */
		System.out.println("Original Color Renault: "+carRenault.getColor());
		carRenault.setColor("Red");
		System.out.println("New Color Renault: "+carRenault.getColor());
				
		System.out.println("Color Renault 2: "+carRenault2.getColor());
	}
		
}
