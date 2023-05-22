package mirosimo_examples.many_to_many_composite_key.model;

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;

@Entity
@AssociationOverrides({
    @AssociationOverride(name = "primaryKey.carEquipmentPack",
        joinColumns = @JoinColumn(name = "EQUIPMENT_PACK_ID")),
    @AssociationOverride(name = "primaryKey.carEngine",
        joinColumns = @JoinColumn(name = "ENGINE_ID")) })
public class CarEquipmentPackCarEngine {
	
	/* Composite Primary Key
	 * - consist of CarEngine entity and CarEquipmentPack entity
	 */
	
	private CarEquipmentPackCarEngineId primaryKey = new CarEquipmentPackCarEngineId();
	
	/*
	 *  Extra fields in connection table
	 */
	
	/*
	 * Some combinations of Engine and Equipment pack could have some
	 * special name used in advertiesing materials or for promotion purposes.
	 * 
	 */
	private String marketingName;

	/*
	 *  Date, when was the new engine variant added to particular equipment pack.
	 */
	private Date  added;
	
	/*
	 * Default is the added variant Active
	 * Could be changed - the Engine can become obsolete and
	 * removed from the offer.
	 * 
	 */
	private boolean active;
	

	
	@EmbeddedId
	public CarEquipmentPackCarEngineId getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(CarEquipmentPackCarEngineId primaryKey) {
		this.primaryKey = primaryKey;
	}
	
	@Transient
	public CarEngine getCarEngine() {
		return this.getPrimaryKey().getCarEngine();
	}
	
	public void setCarEngine(CarEngine carEngine) {
		this.primaryKey.setCarEngine(carEngine);
	}
	
	@Transient
	public CarEquipmentPack getCarEquipmentPack() {
		return this.getPrimaryKey().getCarEquipmentPack();
	}
	
	public void setCarEquipmentPack(CarEquipmentPack carEquipmentPack) {
		this.primaryKey.setCarEquipmentPack(carEquipmentPack);
	}
	

	/* Geters and Setters */
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public Date getAdded() {
		return added;
	}
	public void setAdded(Date added) {
		this.added = added;
	}
	public String getMarketingName() {
		return marketingName;
	}
	public void setMarketingName(String marketingName) {
		this.marketingName = marketingName;
	}		
}
