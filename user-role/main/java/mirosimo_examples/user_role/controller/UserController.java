package mirosimo_examples.user_role.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mirosimo_examples.user_role.model.Role;
import mirosimo_examples.user_role.model.User;
import mirosimo_examples.user_role.model.UserRole;
import mirosimo_examples.user_role.service.RoleService;
import mirosimo_examples.user_role.service.UserRoleService;
import mirosimo_examples.user_role.service.UserService;



@Controller
public class UserController {
	@Autowired
	UserService userService;	       
    
	@Autowired
	RoleService roleService;
	
	@Autowired
	UserRoleService userRoleService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	/* Show view for adding new User into system. */
    @GetMapping("/user-new")
    public String newUser(Model model) {
    	model.addAttribute("appUser", new User());
    	model.addAttribute("listRoles", roleService.getAllEntities());
    	return "user-new";
    } 
    
    
    /* Saves User into database. */
    @PostMapping("/save-user")
    public String saveUser(Model model, @ModelAttribute("appUser") User user,
    		@RequestParam("password") String passw,
    		@Validated String rolecmb) {    	    	
    	
    	// Encoding password
    	user.setPassword(passwordEncoder.encode(passw));
    	
    	/*
    	 *  User must be saved - because user ID is generated after added to db
    	 *  Id's are automatically generated in db, not in application
    	 *  
    	 */    	 
    	User userSaved = this.userService.saveEntity(user);

    	/*
    	 * Getting role instance by its id. Role Id is passed from view "new user view"
    	 */
    	Role role = roleService.getRoleById(Long.parseLong(rolecmb));
    	
    	    	
    	/*  
    	 * UserRole  	- Represents connection entity
    	 * 				- Particular combination of User and Role - relation M:N
    	 *           	- Contains primary key UserRoleId - composite key consist of Role and User
    	 *           
         *    	
    	 *  Contains extra fields in connection entity 
    	 *  - this fields have sense just for one particular combination of User and Role
    	 *       - boolean active 		- Is role Active or Not 
    	 *       - Date dateAdded  		- Date when was role added
    	 *       - int whoAssignRole 	- Who was assigned the role
    	 */ 
    	UserRole userRole = new UserRole();
    	
    	/* Key fields in connection entity UserRole */
    	userRole.setUser(userSaved);
    	userRole.setRole(role);
    	
    	/* Extra fields in connection entity UserRole */
    	userRole.setActive(true);
    	userRole.setDateAdded(new Date());    
    	userRoleService.saveEntity(userRole);
    	    	
    	return "redirect:/user-list";
    }
    
	/* View displays list of users - in table form */
	@GetMapping("/user-list")
	public String listUserView(Model model) {
		model.addAttribute("listUsers", userService.getAllEntities());
		return "user-list";
	}
	
	/* Delete user from system */
	@GetMapping("/user-delete/{id}")
	public String deleteUser(@PathVariable (value="id") long id) {
		this.userService.deleteEntityById(id);
		return "redirect:/user-list";
	}
}
