package mirosimo_examples.user_role.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mirosimo_examples.user_role.model.User;





public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}