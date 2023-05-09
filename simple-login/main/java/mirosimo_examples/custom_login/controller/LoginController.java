package mirosimo_examples.custom_login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {
	
	@GetMapping({"/", "/home", "/logout"})
	public String getHome() {
		return "home";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}	
	
	// Customer view - secured
	@GetMapping("/customer")
	public String getCustomer() {
		return "customers";
	}	
		
	// Redirecting to login view
	@PostMapping("/login-view")
	public String loginView() {
		return "redirect:/login";
	}
}
