package mirosimo.example.autowired.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import mirosimo.example.autowired.car.CarEngine;
import mirosimo.example.autowired.car.CarInfo;
import mirosimo.example.autowired.car.CarPrototypeA;
import mirosimo.example.autowired.car.CarPrototypeB;
import mirosimo.example.autowired.car.Prototype;

@Configuration
public class CarConfig {
	

	@Bean
	@Primary
	@Qualifier("prot_A1")
	public CarInfo carPrototypeA1() {
		return new CarPrototypeA("PROTOTYPE A-1", "SUPER HERO 1 - @Primary Annotation", 300);
	}
	
	@Bean
	@Qualifier("prot_A2")
	public CarInfo carPrototypeA2() {
		return new CarPrototypeA("PROTOTYPE A-2", "SUPER HERO 2", 400);
	}
	
	@Bean
	@Qualifier("prot_A3")
	public CarInfo carPrototypeA3() {
		return new CarPrototypeA("PROTOTYPE A-3", "SUPER HERO 3", 500);
	}
	
	@Bean
	@Qualifier("prot_B1")
	public CarInfo carPrototypeB1() {
		return new CarPrototypeB("PROTOTYPE B-1", "MEGA HERO 1", 1000);
	}
	
	@Bean
	@Prototype("prot_B2")
	public CarInfo carPrototypeB2() {
		return new CarPrototypeB("PROTOTYPE B-2", "MEGA HERO 2 - Custom @Prototype Annotation", 1300);
	}
	
	
	
	//@Bean
	public CarEngine carEngine() {
		return new CarEngine("gas", "2.0 bla bla", 140, 280);
	}
}
