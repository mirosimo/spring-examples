package mirosimoexample.logging.sale.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
		
	Logger logger = LoggerFactory.getLogger(CarController.class);
		
	@GetMapping("/car")
	public String getCar() {
		System.out.println(" -----------CAR----------- ");
		String cl = this.getClass().getSimpleName();
		logger.trace(cl + " - TRACE Message");
        logger.debug(cl + " - DEBUG Message");
        logger.info(cl + " - INFO Message");
        logger.warn(cl + " - WARN Message");
        logger.error(cl + " - ERROR Message");
        
		return "Some Car ";
	}
}
