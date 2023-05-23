package mirosimo_examples.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mirosimo_examples.onetomany.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}

