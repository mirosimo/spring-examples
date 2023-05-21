package mirosimo_examples.many_to_many_composite_key.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mirosimo_examples.many_to_many_composite_key.model.CarEngine;
import mirosimo_examples.many_to_many_composite_key.repository.CarEngineRepository;



@Service
public class CarEngineService {
	@Autowired
	CarEngineRepository carEngineRepository;
	
	public List<CarEngine> getAllEntities() {
		return carEngineRepository.findAll();
	}
	
	public void saveEntity(CarEngine entity) {
		this.carEngineRepository.save(entity);
	}
	
	public void deleteEntityById(long id) {
		this.carEngineRepository.deleteById(id);
	}
	
	public CarEngine getEntityById(long id) {
		Optional<CarEngine> optional = this.carEngineRepository.findById(id);
		CarEngine entity = null;
		if (optional.isPresent()) {
			entity = optional.get();
		} else {
			throw new RuntimeException(" Not found car engine ID: " + id);
		}
		return entity;
	}
		
}
