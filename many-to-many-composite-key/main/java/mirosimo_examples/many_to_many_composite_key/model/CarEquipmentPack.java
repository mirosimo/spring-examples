package mirosimo_examples.many_to_many_composite_key.model;



import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/* 
 * Relation between CarEngine and CarEquipmentPack is M : N
 *   
 * Each equipmentPack (Style, Ambition, Sports pack, etc...)  
 * could offer multiple types of engines (1.4 MPI, 1.8 TSI, etc...).
 * And Each Engine can appear in 1 or more equipments packs.
 * 
 */
@Entity
@Table
public class CarEquipmentPack {
	@Id
	@SequenceGenerator(
			name = "car_equipment_pack_sequence",
			sequenceName = "car_equipment_pack_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "car_equipment_pack_sequence"
	)
	@Column(name = "ID")
	private long id;
	
	private String name;
	
	// name used in url (without diacritic)	
	private String urlName;
		
	private String descShort;
		
	private String descLong;	
	
	@Column(nullable = true)
	private boolean active;
	
	
	@OneToMany(mappedBy = "primaryKey.carEquipmentPack",
            cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<CarEquipmentPackCarEngine> carEquipmentPackCarEngines = new HashSet<>();
	
	public List<CarEquipmentPackCarEngine> getEnginesOrderedByEngineGroupAndName() {
						
		Comparator<CarEquipmentPackCarEngine> comparator = 
				Comparator.comparing((CarEquipmentPackCarEngine eqEngine) -> eqEngine.getCarEngine().getEngineGroup())
					.thenComparing((CarEquipmentPackCarEngine eqEngine) -> eqEngine.getCarEngine().getName());
											
		List<CarEquipmentPackCarEngine> ls = carEquipmentPackCarEngines.stream().collect(Collectors.toList());
		Collections.sort(ls, comparator);		
		return ls;		
	}
	
	
	/* getters and setters */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrlName() {
		return urlName;
	}

	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}

	public String getDescShort() {
		return descShort;
	}

	public void setDescShort(String descShort) {
		this.descShort = descShort;
	}

	public String getDescLong() {
		return descLong;
	}

	public void setDescLong(String descLong) {
		this.descLong = descLong;
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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarEquipmentPack entity = (CarEquipmentPack) obj;
		return id != 0L && id == entity.getId();		
	}
	
	/* Is used one number for all entities - one bucket for all entities 
	 * Reason why - ID is generated in database and therefore could 
	 * exist entities in transient state which don't have assigned ID yet */
	@Override
	public int hashCode() {
		return 23;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
