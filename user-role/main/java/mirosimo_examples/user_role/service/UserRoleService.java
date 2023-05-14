package mirosimo_examples.user_role.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mirosimo_examples.user_role.model.User;
import mirosimo_examples.user_role.model.UserRole;
import mirosimo_examples.user_role.repository.UserRoleRepository;

@Service
public class UserRoleService {
	@Autowired 
	private UserRoleRepository userRoleRepository;
	
	public List<UserRole> getAllEntities() {
		return userRoleRepository.findAll();
	}
	
	public UserRole saveEntity(UserRole entity) {
		return this.userRoleRepository.save(entity);
	}
			
	public void deleteEntityById(long id) {
		this.userRoleRepository.deleteById(id);
	}
}
