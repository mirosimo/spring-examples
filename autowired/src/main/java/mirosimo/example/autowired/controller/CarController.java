package mirosimo.example.autowired.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mirosimo.example.autowired.car.CarInfo;
import mirosimo.example.autowired.car.Prototype;

@RestController
public class CarController {
	
	@Autowired
    private CarInfo prototype;
	
	@Autowired
	@Qualifier("prot_A2")
	private CarInfo prototype2;
	
	@Autowired
	@Prototype("prot_B2")
	private CarInfo prototype3;
	
    //@Autowired
    //public void setPrototypeA(CarInfo prototypeA) {
    //	this.prototypeA = prototypeA;
    //}
    
	public CarController() {
		System.out.println("Hallo, here is default constructor");
	}
	
	//@Autowired
	//public CarController(CarInfo prototypeA) {
	//	this.prototypeA = prototypeA;
	//}
	
	
	
	//@Autowired(required = false)
	//CarEngine carEngine;
	
	@GetMapping("/car-info")
	public String getCarInfo() {		
		return prototype.getCarInfo() + "<BR><BR>" 
				+ prototype2.getCarInfo() + "<BR><BR>"
				+ prototype3.getCarInfo();		
		
	}
}
