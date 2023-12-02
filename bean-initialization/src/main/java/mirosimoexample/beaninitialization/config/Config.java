package mirosimoexample.beaninitialization.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mirosimoexample.beaninitialization.car_equipment.Radio3;

@Configuration
public class Config {
	
	@Bean(initMethod="init")	
	public Radio3 getRadio3() {
		return new Radio3();
	}
}
