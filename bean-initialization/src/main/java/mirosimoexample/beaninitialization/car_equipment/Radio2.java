package mirosimoexample.beaninitialization.car_equipment;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
 * 
 * Initialization Bean using interface InitializingBean
 *		must be implemented method afterPropertiesSet()   
 * */

@Component
@Scope("prototype")
public class Radio2 implements InitializingBean {
	public String power;
	public float  frequency;
	public String stationName;
	
	public Radio2 () {}

	public Radio2(String power, float frequency, String stationName) {
		super();
		System.err.println("Radio - Constructor");
		this.power = power;
		this.frequency = frequency;
		this.stationName = stationName;
	}
		
	@Override
	public void afterPropertiesSet() {
		System.out.println("Initializiton using interface InitializingBean - Bean of type **Radio2**.");
		
		this.setPower("on");
		this.setFrequency(99.5F);		
		this.setStationName("Hits from 80s !!!");
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

