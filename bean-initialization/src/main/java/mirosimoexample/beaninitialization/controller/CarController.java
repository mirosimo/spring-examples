package mirosimoexample.beaninitialization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mirosimoexample.beaninitialization.car_equipment.Radio;
import mirosimoexample.beaninitialization.car_equipment.Radio2;
import mirosimoexample.beaninitialization.car_equipment.Radio3;

@RestController
public class CarController {
	
	/*
	 * This property is initialized using @PostConstruct
	 */
	private Radio carRadio;
	
	/*
	 * This property is initialized using interface InitializingBean 
	 * and its method afterPropertiesSet()
	 */
	private Radio2 carRadio2;
	
	/*
	 * This property is initialized using initMethod  
	 * Look at definition of beans in Config.java.
	 * 
	 */
	private Radio3 carRadio3;

	@Autowired
	public void setCarRadio(Radio carRadio) {
		this.carRadio = carRadio;
	}
	
	@Autowired
	public void setCarRadio2(Radio2 carRadio2) {
		this.carRadio2 = carRadio2;
	}
	
	@Autowired
	public void setCarRadio3(Radio3 carRadio3) {
		this.carRadio3 = carRadio3;
	} 

	
	public Radio getCarRadio() {
		return carRadio;
	}
	
	public Radio2 getCarRadio2() {
		return carRadio2;
	}
	
	public Radio3 getCarRadio3() {
		return carRadio3;
	}

	@GetMapping("/radio-info")
	public String getRadioInfo() {
		
		String postConstructTxt = 
				"Radio info - initialization using @PostConstruct<BR>" +
				"Frequency: " + this.getCarRadio().getFrequency() + "<BR>" + 
				"Statin name: " + this.getCarRadio().getStationName();
		
		String initializingBeanTxt =
				"Radio info - initialization using interface InitializingBean<BR>" +
				"Frequency: " + this.getCarRadio2().getFrequency() + "<BR>" + 
				"Statin name: " + this.getCarRadio2().getStationName();
		
		String initMethod =
				"Radio info - initialization using initMethod<BR>" +
				"Frequency: " + this.getCarRadio3().getFrequency() + "<BR>" + 
				"Statin name: " + this.getCarRadio3().getStationName();
		
		return postConstructTxt + "<BR><BR>" + 
		initializingBeanTxt + "<BR><BR>" +
		initMethod;
	}	
}
