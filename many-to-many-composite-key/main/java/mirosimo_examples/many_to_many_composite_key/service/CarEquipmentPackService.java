package mirosimo_examples.many_to_many_composite_key.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mirosimo_examples.many_to_many_composite_key.model.CarEquipmentPack;
import mirosimo_examples.many_to_many_composite_key.repository.CarEquipmentPackRepository;


@Service
public class CarEquipmentPackService {
	@Autowired
	CarEquipmentPackRepository carEquipmentPackRepository;
	
	public List<CarEquipmentPack> getAllEntities() {
		return carEquipmentPackRepository.findAll();
	}
			

	
	
	public CarEquipmentPack getEntityById(long id) {
		Optional<CarEquipmentPack> optional = this.carEquipmentPackRepository.findById(id);
		CarEquipmentPack entity = null;
		if (optional.isPresent()) {
			entity = optional.get();
		} else {
			throw new RuntimeException("CarEquipmentPack Not found" + id);
		}
		return entity;
	}
	
	public CarEquipmentPack saveEntity(CarEquipmentPack entity) {
		 return this.carEquipmentPackRepository.save(entity);
	}
			
	public void deleteEntityById(long id) {
		this.carEquipmentPackRepository.deleteById(id);
	}
}
