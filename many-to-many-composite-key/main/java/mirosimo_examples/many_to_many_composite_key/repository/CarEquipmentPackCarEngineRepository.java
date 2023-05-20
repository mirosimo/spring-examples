package mirosimo_examples.many_to_many_composite_key.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mirosimo_examples.many_to_many_composite_key.model.CarEquipmentPackCarEngine;


public interface CarEquipmentPackCarEngineRepository extends JpaRepository<CarEquipmentPackCarEngine, Long> {

}
