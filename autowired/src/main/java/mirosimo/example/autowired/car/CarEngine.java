package mirosimo.example.autowired.car;

public class CarEngine {
	public String type;
	public String name;
	public int power;
	public int torque;
	
	public CarEngine() {}
		
	public CarEngine(String type, String name, int power, int torque) {
		super();
		this.type = type;
		this.name = name;
		this.power = power;
		this.torque = torque;
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
	
	public int getTorque() {
		return torque;
	}
	public void setTorque(int torque) {
		this.torque = torque;
	}
}
