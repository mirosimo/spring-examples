package mirosimoexample.logging.accounting.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AccountController {
	

	
	Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	
	@GetMapping("/account")
	public String getAccount() {
		System.out.println(" -----------ACCOUNT----------- ");
		String cl = this.getClass().getSimpleName();
		logger.trace(cl + " - TRACE Message");
        logger.debug(cl + " - DEBUG Message");
        logger.info(cl + " - INFO Message");
        logger.warn(cl + " - WARN Message");
        logger.error(cl + " - ERROR Message");        
        
		return "Some Account ";
	}
}
