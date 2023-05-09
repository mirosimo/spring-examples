package mirosimo_examples.custom_login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mirosimo_examples.custom_login.model.User;



public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}