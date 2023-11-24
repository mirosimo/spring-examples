package mirosimoexamples.scope.car;

public class Car {
	private String name;
	private String color;
	private int maxSpeed;
	
	public Car() {}
	
	public Car(String name, String color, int maxSpeed) {
		this.name = name;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
}
