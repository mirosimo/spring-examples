package mirosimo_examples.onetomany.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import mirosimo_examples.onetomany.model.Employee;
import mirosimo_examples.onetomany.service.DepartmentService;
import mirosimo_examples.onetomany.service.EmployeeService;




@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;	
	
	@Autowired
	DepartmentService departmentService;
	
	/* View displays list of employees in table form */
	@GetMapping("/employee-list")
	public String listEmployeeView(Model model) {
		model.addAttribute("listEmployee", employeeService.getAllEmployees());		
		return "employee-list";
	}
	
	/* View for adding new employees into system */
	@GetMapping("/employee-new")
	public String newEmployeeView(Model model) {
		Employee employee = new Employee();		
		model.addAttribute("employee", employee);		
		model.addAttribute("listDepartment", departmentService.getAllEntities());
		return "employee-new";
	} 
		
	@PostMapping("/employee-save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee, Model model								
			) throws IOException {
		
		System.out.println("emp name" + employee.getFirstName());
		System.out.println("emp department" + employee.getDepartment().getName());
		
		this.employeeService.saveEntity(employee);
		return "redirect:/employee-list";
	}	
}
