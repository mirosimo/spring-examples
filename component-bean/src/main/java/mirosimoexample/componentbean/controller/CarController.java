package mirosimoexample.componentbean.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mirosimoexample.componentbean.car.CarInfo;

@RestController
public class CarController {
	
	/*
	 * Here is used Autowire by name - property name is same 
	 * as bean name - Reason ---> Interface... 
	 * 
	 * The beans have assigned explicit name (prototypeA, prototypeB)
	 *   
	 * */
	@Autowired
	CarInfo prototypeA;
	
	@GetMapping("/car-info")
	public String getCarInfo() {		
		return prototypeA.getCarInfo();
	}
}
