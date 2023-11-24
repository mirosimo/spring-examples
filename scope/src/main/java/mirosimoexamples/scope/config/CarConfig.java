package mirosimoexamples.scope.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import mirosimoexamples.scope.car.Car;

@Configuration
public class CarConfig {
	
	/* 
	 * This bean is created with default scope - Singelton
	 * 
	 *  */
	@Bean
	@Qualifier("mercedes")
	public Car carMercedes() {
		return new Car("Mercedes", "black", 250);
	}
	
	/*
	 * This bean has setup scope on value prototype
	 * 
	 * */
	@Bean
	@Qualifier("renault")
	@Scope("prototype")
	public Car carRenault() {
		return new Car("Renault", "black", 190);
	}
}
