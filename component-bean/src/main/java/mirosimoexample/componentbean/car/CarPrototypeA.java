package mirosimoexample.componentbean.car;

public class CarPrototypeA implements CarInfo{
	public String type;
	public String name;
	public int power;
	
	public CarPrototypeA() {
		
	}
	
	public CarPrototypeA(String type, String name, int power) {
		this.type = type;
		this.name = name;
		this.power = power;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	@Override
	public String getCarInfo() {		
		return "Car Type: " + this.getType() + " - Car Name: " + this.getName() + " - Power: " + this.getPower();
	}
	
	
}
