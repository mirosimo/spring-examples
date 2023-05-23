package mirosimo_examples.onetomany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mirosimo_examples.onetomany.model.Employee;
import mirosimo_examples.onetomany.repository.EmployeeRepository;

;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	public Employee saveEntity(Employee emp) {
		return this.employeeRepository.save(emp);		
	}
	
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional = this.employeeRepository.findById(id);
		Employee emp = null;
		if (optional.isPresent()) {
			emp = optional.get();
		} else {
			throw new RuntimeException(" Not found employee ID: " + id);
		}
		return emp;
	}
}
