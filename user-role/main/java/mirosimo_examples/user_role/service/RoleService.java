package mirosimo_examples.user_role.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mirosimo_examples.user_role.model.Role;
import mirosimo_examples.user_role.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired 
	private RoleRepository roleRepository;
	
	public List<Role> getAllEntities() {
		return roleRepository.findAll();
	}
	
	public Role saveEntity(Role entity) {
		return this.roleRepository.save(entity);
	}
			
	public void deleteEntityById(long id) {
		this.roleRepository.deleteById(id);
	}
	
	public Role getRoleById(long id) {
		Optional<Role> optional = this.roleRepository.findById(id);
		Role entity = null;
		if (optional.isPresent()) {
			entity = optional.get();
		} else {
			throw new RuntimeException(" Not found user by ID: " + id);					
		}
		return entity;
	}
}
