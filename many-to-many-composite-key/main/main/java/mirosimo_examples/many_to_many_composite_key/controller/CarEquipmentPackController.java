package mirosimo_examples.many_to_many_composite_key.controller;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mirosimo_examples.many_to_many_composite_key.model.CarEngine;
import mirosimo_examples.many_to_many_composite_key.model.CarEquipmentPack;
import mirosimo_examples.many_to_many_composite_key.model.CarEquipmentPackCarEngine;
import mirosimo_examples.many_to_many_composite_key.service.CarEngineService;
import mirosimo_examples.many_to_many_composite_key.service.CarEquipmentPackCarEngineService;
import mirosimo_examples.many_to_many_composite_key.service.CarEquipmentPackService;



@Controller
public class CarEquipmentPackController {
	@Autowired
	CarEquipmentPackService carEquipmentPackService;
		
	@Autowired
	CarEngineService carEngineService;
	
	@Autowired
	CarEquipmentPackCarEngineService carEquipmentPackCarEngineService; 
	
	/* List of all Car EquipmentPack s */	
	@GetMapping("/car-equipment-pack-list")
	public String listEquipmentPackView(Model model) {		
		model.addAttribute("listEntities", carEquipmentPackService.getAllEntities());		
		return "car-equipment-pack-list";
	}
	
	/*  
	 * View for adding new Equipment Pack
	 */
	@GetMapping("/car-equipment-pack-new")
	public String newEquipmentPackView(Model model) {
		

		
		List<CarEngine> listCarEnginesOrdered = carEngineService.getAllEntities().stream()
						.sorted(CarEngine.getComparatorByFuelGroupName())
						.collect(Collectors.toList());		
		
		model.addAttribute("carEquipmentPack", new CarEquipmentPack());
		model.addAttribute("listCarEngines", listCarEnginesOrdered);
		return "car-equipment-pack-new";
	} 
	
	/* Save Equipment pack */
	@PostMapping("/car-equipment-pack-save")			
	public String saveItem(@Valid @ModelAttribute("carEquipmentPack") CarEquipmentPack carEquipmentPack,				
			Model model,
			@RequestParam("engine_checkbox") int[] engines) {													
		
		// Oracle generates an Id. 
		CarEquipmentPack savedEquipmentPack = this.carEquipmentPackService.saveEntity(carEquipmentPack);						
		
		// Adding engines assigned to equipmant pack.
		for (int engineId : engines) {
			CarEngine engine = carEngineService.getEntityById(engineId); 
			CarEquipmentPackCarEngine carEquipmentPackCarEngine = new CarEquipmentPackCarEngine();
			carEquipmentPackCarEngine.setCarEngine(engine);		
			carEquipmentPackCarEngine.setCarEquipmentPack(savedEquipmentPack);
			carEquipmentPackCarEngine.setActive(true);
			carEquipmentPackCarEngine.setAdded(new Date());
			carEquipmentPackCarEngineService.saveEntity(carEquipmentPackCarEngine);
		}
				
		return "redirect:/car-equipment-pack-list/";
	}
	
	/* Deletes CarEquipmentPack entity by Id */
	@GetMapping("/car-equipment-pack-delete/{id}")
	public String deleteItem(@PathVariable (value="id") long id) {
		this.carEquipmentPackService.deleteEntityById(id);
		return "redirect:/car-equipment-pack-list";
	}
	
	/* 
	 * View for displaying Equipmant Packs and its Engines
	 * Under each equipment pack is a list of engines 
	 * available for particular equipment pack.
	 * 
	 * Entity CarEquipmentPack has field *carEquipmentPackCarEngines* 
	 * which contains engines assigned to equipmantPack.
	 *  
	 * And method *getEnginesOrderedByEngineGroupAndName()* 
	 * which is called in Thymeleaf - used for fetching and order the records   
	 *   
	 */
	@GetMapping("/car-equipment-pack-engine-list")
	public String newEquipmentPackEnginesView(Model model) {						
		List<CarEquipmentPack> sortedByEqPackName = carEquipmentPackService.getAllEntities().stream()
				.filter(eqPack -> eqPack.isActive())
				//.sorted((eqPack1, eqPack2) -> eqPack1.getName().compareTo(eqPack2.getName()))
				.sorted(Comparator.comparing(CarEquipmentPack::getName))
				.collect(Collectors.toList());
		model.addAttribute("listEntities", sortedByEqPackName);
		return "car-equipment-pack-engine-list";
	} 
}

