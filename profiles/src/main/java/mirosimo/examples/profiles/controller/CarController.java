package mirosimo.examples.profiles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mirosimo.examples.profiles.db.DbSetup;

@RestController
public class CarController {
	@Autowired DbSetup dbSetup;
	
	@GetMapping("/get-car")
	public String getCar() {
		return dbSetup.setup();
	}
}
