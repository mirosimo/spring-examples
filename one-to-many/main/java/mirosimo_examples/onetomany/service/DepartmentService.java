package mirosimo_examples.onetomany.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mirosimo_examples.onetomany.model.Department;
import mirosimo_examples.onetomany.repository.DepartmentRepository;


@Service
public class DepartmentService {
	
	@Autowired 
	private DepartmentRepository departmentRepository;
	
	public List<Department> getAllEntities() {
		return departmentRepository.findAll();
	}
	
	public void saveEntity(Department entity) {
		this.departmentRepository.save(entity);
	}
			
	public void deleteEntityById(long id) {
		this.departmentRepository.deleteById(id);
	}
}
