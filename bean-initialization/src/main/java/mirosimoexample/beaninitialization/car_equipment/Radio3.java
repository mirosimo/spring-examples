package mirosimoexample.beaninitialization.car_equipment;

/*
 * 
 * For initialization is using **initMethod** - look at Bean definitions in Config.java...
 * 
 * */


public class Radio3 {
	public String power;
	public float  frequency;
	public String stationName;
	
	public Radio3 () {}

	public Radio3(String power, float frequency, String stationName) {
		super();
		System.err.println("Radio 3 - Constructor");
		this.power = power;
		this.frequency = frequency;
		this.stationName = stationName;
	}
		
	
	public void init() {
		System.out.println("Initializiton using init-method.");
		System.out.println("Bean of type **Radio3**");
		
		this.setPower("on");
		this.setFrequency(86.5F);		
		this.setStationName("Hits from 90s !!!");
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
