package mirosimo_examples.user_role.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import mirosimo_examples.user_role.model.Role;
import mirosimo_examples.user_role.service.RoleService;

@Controller
public class RoleController {
	@Autowired
	RoleService roleService;
	
    @GetMapping("/role-new")
    public String newUser(Model model) {
    	model.addAttribute("appRole", new Role());
    	return "role-new";
    } 
    
    @PostMapping("/role-save")
    public String saveUser(Model model, @ModelAttribute("appRole") Role role) {    	    	    	
    	this.roleService.saveEntity(role);    	
    	return "redirect:/role-new";
    }
}
