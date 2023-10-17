package mirosimoexample.componentbean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mirosimoexample.componentbean.car.CarPrototypeA;
import mirosimoexample.componentbean.car.CarPrototypeB;

@Configuration
public class CarConfig {
	
	
	/*
	 *
	 * Here are created two beans with explicit name
	 * prototypeA, prototypeB 
	 * Default name would be same as functionName 
	 * carPrototypeA, carPrototypeB 
	 * 
	 * */
	
	@Bean("prototypeA")
	public CarPrototypeA carPrototypeA() {
		return new CarPrototypeA("PROTOTYPE A", "SUPER HERO", 300);
	}
	
	@Bean("prototypeB")
	public CarPrototypeB carPrototypeB() {
		return new CarPrototypeB("PROTOTYPE B", "MEGA HERO", 1000);
	}
}
