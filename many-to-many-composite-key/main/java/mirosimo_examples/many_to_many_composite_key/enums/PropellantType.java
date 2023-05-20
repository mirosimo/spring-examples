package mirosimo_examples.many_to_many_composite_key.enums;

public enum PropellantType {
	PETROL("Petrol"), DIESEL("Diesel"), ELECTRIC("Electric"), LPG("LPG");
	
	private final String niceValue;
	
	private PropellantType(String fuel) {
		this.niceValue = fuel;
	}
	
	public String getNiceValue() {
		return this.niceValue;
	}
}
