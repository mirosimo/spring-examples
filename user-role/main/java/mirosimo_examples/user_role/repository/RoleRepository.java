package mirosimo_examples.user_role.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mirosimo_examples.user_role.model.Role;



public interface RoleRepository  extends JpaRepository<Role, Long>{

}
