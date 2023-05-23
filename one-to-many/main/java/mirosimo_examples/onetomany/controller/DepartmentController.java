package mirosimo_examples.onetomany.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import mirosimo_examples.onetomany.model.Department;
import mirosimo_examples.onetomany.service.DepartmentService;


@Controller
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;
	
	/* View displays list of departments - in table form */
	@GetMapping("/department-list")
	public String listDepartmentView(Model model) {
		model.addAttribute("listDepartments", departmentService.getAllEntities());
		return "department-list";
	}
	
	/* View for adding new Department into system */
	@GetMapping("/department-new")
	public String newDepartmentView(Model model) {
		Department department = new Department();
		model.addAttribute("department", department);
		return "department-new";
	} 
	
	/* Save department */
	@PostMapping("/department-save")
	public String savaDepartment(@ModelAttribute("department") Department department) {
		this.departmentService.saveEntity(department);
		return "redirect:/department-list";
	}
	
	/* Delete departments from system */
	@GetMapping("/department-delete/{id}")
	public String deleteDepartment(@PathVariable (value="id") long id) {
		this.departmentService.deleteEntityById(id);
		return "redirect:/department-list";
	}
	
	/* View displays departments and its employees */
	@GetMapping("/department-employee-list")
	public String listDepartmentEmployeesView(Model model) {
		model.addAttribute("listDepartments", departmentService.getAllEntities());
		return "department-employees";
	}
}
