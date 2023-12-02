package mirosimoexample.beaninitialization.car_equipment;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

/*
 * Here is used PostConstruct initialization
 * 
 * */

@Component
@Scope("prototype")
public class Radio {
	public String power;
	public float  frequency;
	public String stationName;
	
	public Radio () {}

	public Radio(String power, float frequency, String stationName) {
		super();
		System.err.println("Radio - Constructor");
		this.power = power;
		this.frequency = frequency;
		this.stationName = stationName;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Initializiton using @PostConstruct - Bean type **Radio**");
		this.setPower("on");
		this.setFrequency(105.6F);		
		this.setStationName("Let's go dance !!!");
	}
	
	
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	
	public float getFrequency() {
		return frequency;
	}
	public void setFrequency(float frequency) {
		this.frequency = frequency;
	}
	
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}		
	
}
