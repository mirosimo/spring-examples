package mirosimo_examples.many_to_many_composite_key.model;



import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import mirosimo_examples.many_to_many_composite_key.enums.PropellantType;

/*
 * Car Engine Entity
 * Relation between CarEngine and CarEquipmentPack is M : N
 * Each car model has one or more equipment packs - e.g. Style, Ambition, Sports pack etc...
 * And each equipment pack could have different offer of available Engines
 * 
 * fields:
 * Enum propellantType 	- Petrol, Deisel, Electric, LPG 
 * String engineGroup	- Because of Sorting reasons - some engines could 
 * 						- belong to certain engine family (TSI, MPI, DIESEL etc...)					
 * String name			- 1.8 TSI, 1.4 MPI 
 * 
 * */
@Table
@Entity
public class CarEngine {		
	
	@Id
	@SequenceGenerator(
			name = "car_engine_sequence",
			sequenceName = "car_engine_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "car_engine_sequence"
	)
	@Column(name = "ID")
	private long id;			

	/*
	 * Petrol, Deisel, Electric, LPG
	 */
	@Enumerated(EnumType.STRING)
	private PropellantType propellantType;
	
	/* 
	 * Because of Sorting reasons - some engines could 
	 * belong to certain engine family (TSI, MPI, DIESEL etc...)
	 * 
	 */
	private String engineGroup;				 
	
	/*
	 * Engine code
	 */
	private String code;
		
	/*
	 * Power in Kw
	 */
	private int power; 		
		
	private String name;
	
	private String nameMarketing;
	
	
	
	@OneToMany(mappedBy = "primaryKey.carEngine",
            cascade = CascadeType.ALL)
	private Set<CarEquipmentPackCarEngine> carEquipmentPackCarEngines = new HashSet<>();
	
	/* 
	 * Comparator - order CarEngine by 
	 *  - propellantType (Diesel, Petrol, Electro, etc...)
	 *  - engine group (TSI, MPI, DIESEL, etc...)
	 *  - name (1.4 MPI, 1.8 TSI, etc...)
	 *  
	 */
	public static Comparator<CarEngine> getComparatorByFuelGroupName() {
		Comparator<CarEngine> cc = Comparator
				.comparing((CarEngine carEngine) -> carEngine.getPropellantType().getNiceValue())						
				.thenComparing(Comparator.comparing(CarEngine::getEngineGroup))
				.thenComparing(Comparator.comparing(CarEngine::getName));
		return cc;
	}
	
	/* getters, setters*/
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameMarketing() {
		return nameMarketing;
	}

	public void setNameMarketing(String nameMarketing) {
		this.nameMarketing = nameMarketing;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<CarEquipmentPackCarEngine> getCarEquipmentPackCarEngines() {
		return carEquipmentPackCarEngines;
	}

	public void setCarEquipmentPackCarEngines(Set<CarEquipmentPackCarEngine> carEquipmentPackCarEngines) {
		this.carEquipmentPackCarEngines = carEquipmentPackCarEngines;
	}
	
	public PropellantType getPropellantType() {
		return propellantType;
	}

	public void setPropellantType(PropellantType propellantType) {
		this.propellantType = propellantType;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarEngine entity = (CarEngine) obj;
		return id != 0L && id == entity.getId();		
	}
	
	/* Is used one number for all entities - one bucket for all entities 
	 * Reason why - ID is generated in database and therefore could 
	 * exist entities in transient state which don't have assigned ID yet */
	@Override
	public int hashCode() {
		return 23;
	}

	public String getEngineGroup() {
		return engineGroup;
	}

	public void setEngineGroup(String engineGroup) {
		this.engineGroup = engineGroup;
	}
	
	
	
}
