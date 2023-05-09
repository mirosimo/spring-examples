package mirosimo_examples.custom_login.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mirosimo_examples.custom_login.model.User;
import mirosimo_examples.custom_login.repository.UserRepository;


@Service
public class AuthenticationUserService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

		
	@Override
	public UserDetails loadUserByUsername(String username) {
		User user = userRepository.findByUsername(username);		
		if (user == null) {
            throw new UsernameNotFoundException(username);
        }
		//Set<UserRole> roles = user.getUserRoles();
		//List<String> listRoles = roles.stream().map(ur -> ur.getRole().getName()).collect(Collectors.toList());
        UserBuilder builder= org.springframework.security.core.userdetails.User
				.withUsername(username);
        builder.password(user.getPassword());         
        //builder.roles(listRoles.toArray(new String[0]));
        builder.authorities("somerolee");
        return builder.build();
	}
		
    /*private Set<GrantedAuthority> convertAuthorities(Set<UserRole> userRoles) {
        Set<GrantedAuthority> authorities=new HashSet<>();
        for (UserRole userRole : userRoles) {
            authorities.add(new SimpleGrantedAuthority(userRole.getRole()));
        }
        return authorities;
    }*/
}
