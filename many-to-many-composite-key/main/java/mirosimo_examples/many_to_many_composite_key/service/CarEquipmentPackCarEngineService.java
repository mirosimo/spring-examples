package mirosimo_examples.many_to_many_composite_key.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mirosimo_examples.many_to_many_composite_key.model.CarEquipmentPackCarEngine;
import mirosimo_examples.many_to_many_composite_key.repository.CarEquipmentPackCarEngineRepository;



@Service
public class CarEquipmentPackCarEngineService {
	@Autowired 
	CarEquipmentPackCarEngineRepository repository; 
	
	public CarEquipmentPackCarEngine saveEntity(CarEquipmentPackCarEngine entity) {
		return repository.save(entity);
	}
}
