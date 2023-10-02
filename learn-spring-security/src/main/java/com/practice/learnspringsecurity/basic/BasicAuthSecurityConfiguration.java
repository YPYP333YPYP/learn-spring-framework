package com.practice.learnspringsecurity.basic;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class BasicAuthSecurityConfiguration {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(
						auth -> {
							auth.anyRequest().authenticated();
						});
		
		http.sessionManagement(
						session -> 
							session.sessionCreationPolicy(
									SessionCreationPolicy.STATELESS)
						);
		
		//http.formLogin();
		http.httpBasic(withDefaults());
		
		http.csrf(csrf -> csrf.disable());
		
		return http.build();
	}
	
	// UserDetailsService 클래스를 이용해 User에 대한 객체 생성이 가능하다.
	// InMemoryUserDetailsManager는 사용자 정보를 메모리에 저장할 수 있다. 
	@Bean
	public UserDetailsService userDetailService() {
		
		var user = User.withUsername("Lee")
			.password("{noop}dummy")
			.roles("USER")
			.build();

		
		var admin = User.withUsername("admin")
				.password("{noop}dummy")
				.roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(user, admin);
	}


}
