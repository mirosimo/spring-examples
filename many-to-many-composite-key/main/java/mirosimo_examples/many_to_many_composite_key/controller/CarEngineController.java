package mirosimo_examples.many_to_many_composite_key.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import mirosimo_examples.many_to_many_composite_key.enums.PropellantType;
import mirosimo_examples.many_to_many_composite_key.model.CarEngine;
import mirosimo_examples.many_to_many_composite_key.service.CarEngineService;
import mirosimo_examples.many_to_many_composite_key.service.CarEquipmentPackService;




@Controller
public class CarEngineController {
	
	@Autowired
	CarEngineService carEngineService;
	
	@Autowired
	CarEquipmentPackService carEquipmentPackService;


	/* 
	 * View with all engines - All Engine list
	 *  
	 * The ordering of entities is done on application level. 
	 * Normally would probably be done on database level. 
	 * This just an example with not a lot of data. 
	 * 
	 * 
	 * Nevertheless, You can check here how to use Stream API for ordering data 
	 * by multiple fields - using Comparator
	 * The required ordering of CarEngine entities is by 3 following fields 
	 * 
	 * - propellantType - is enum type
	 * - engineGroup
	 * - engineName 
	 * 
	 * */
	@GetMapping("/car-engine-list")
	public String getEngineListAll(Model model) {
		List<CarEngine> listEntities = carEngineService.getAllEntities().stream()
				.sorted(CarEngine.getComparatorByFuelGroupName())
				.collect(Collectors.toList());
		model.addAttribute("listEntities", listEntities);	
		return "car-engine-list";
	}			
	
	/* 
	 * Displays View for adding new Engine  
	 *  */		
	@GetMapping("/car-engine-new")
	public String newCarEngineForm(Model model) {
		CarEngine carEngine = new CarEngine();						
		model.addAttribute("carEngine", carEngine);	
		return "car-engine-new";
	} 
	
	/* Save Car Engine entity */
	@PostMapping("/car-engine-save")	
	public String saveCarEngine(@Valid CarEngine carEngine, @Valid PropellantType fuelCmb, 
			 Model model)
		{						
		carEngine.setPropellantType(fuelCmb);
		this.carEngineService.saveEntity(carEngine);
		return "redirect:/car-engine-list";
	}
	
	/* Deletes Car Engine entity by Id */
	@GetMapping("/car-engine-delete/{id}")
	public String deleteItem(@PathVariable (value="id") long id) {
		this.carEngineService.deleteEntityById(id);
		return "redirect:/car-engine-list/";
	}
}
