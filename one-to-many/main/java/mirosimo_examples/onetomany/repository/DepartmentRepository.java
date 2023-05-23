package mirosimo_examples.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mirosimo_examples.onetomany.model.Department;

public interface DepartmentRepository  extends JpaRepository<Department, Long>{

}
