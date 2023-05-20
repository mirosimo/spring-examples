package mirosimo_examples.many_to_many_composite_key.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/* This class represent composite primary key */

@Embeddable
public class CarEquipmentPackCarEngineId implements Serializable {

	/**
	 * 
	 */

	
	private CarEquipmentPack carEquipmentPack;
	private CarEngine carEngine;
	
	@ManyToOne(cascade = CascadeType.ALL)
	public CarEquipmentPack getCarEquipmentPack() {
		return carEquipmentPack;
	}
	public void setCarEquipmentPack(CarEquipmentPack carEquipmentPack) {
		this.carEquipmentPack = carEquipmentPack;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	public CarEngine getCarEngine() {
		return carEngine;
	}
	public void setCarEngine(CarEngine carEngine) {
		this.carEngine = carEngine;
	}
}
