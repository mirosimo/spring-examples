package mirosimo_examples.custom_login.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig { 
	
	//@Order
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {		
		http .authorizeRequests()						
			   .antMatchers("/").permitAll()
			   .antMatchers("/home").permitAll()
			   .antMatchers("/login").permitAll()
			   .antMatchers("/logout").permitAll()			   														
			   .anyRequest().authenticated()					
			   .and()
			.formLogin()
				.loginPage("/login")
				.usernameParameter("usname")
				.passwordParameter("passwd")
				.permitAll()  				
				//.successForwardUrl("/login_success_handler")
				.loginProcessingUrl("/mirosimo-login")				
				.defaultSuccessUrl("/home", true)
				.failureUrl("/login?error=true")
				.and()
			.logout()
				.logoutUrl("/mirosimo-logout")
				.deleteCookies("JSESSIONID")
				.logoutSuccessUrl("/logout");						
		return http.build();
	}
		
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/img/**", "/css/**");
    }
}

