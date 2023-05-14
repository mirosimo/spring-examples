package mirosimo_examples.user_role.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mirosimo_examples.user_role.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long>{

}
