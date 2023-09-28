package com.practice.springboot.myfastwebapp.security;


import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		
		UserDetails userDetails1 = createNewUser("Lee", "dummy");
		UserDetails userDetails2 = createNewUser("Lee2", "dummydummy");
		
		// InMemoryUserDetailsManager의 경우 파라미터를 가변인자로 받을 수 있기 때문에 여러 파라미터 입력이 가능하다. 
		return new InMemoryUserDetailsManager(userDetails1, userDetails2);
	}
	
	// 기존의 createUserDetailManager 메서드를 리팩토링하여 createNewUser 메서드를 만들어 userDetails를 만들 수 있도록 하였다. 
	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder
		= input -> passwordEncoder().encode(input);

		UserDetails userDetails = User.builder()
									.passwordEncoder(passwordEncoder)
									.username(username)
									.password(password)
									.roles("USER","ADMIN")
									.build();
		return userDetails;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// Spring Security는 기본적으로 모든 URL을 보호하며, login 양식은 권한이 없을때 요청 되어진다.
	// h2 console과 같은 페이지를 사용할 때마다 login 양식을 보는 것은 비효율적 이기 때문에 
	// Http 요청중 일부를 제외하는 메서드를 생성하는 것 이다. 
	// 파라미터로는 HttpSecurity 객체를 사용하는데 이는 Spring Security의 구성을 설정하는데 사용되는 객체이다.
	// http.authorizeHttpRequests 부분은 모든 HTTP 요청에 대해서 인증된 사용자만 접근할 수 있도록 설정하며 이는 로그인한 사용자는 모든 요청에 접근할 수 있다는 뜻이다.
	// http.formLogin 부분은 일반적인 로그인 구성을 자동으로 설정하며, csrf 공격을 방지하는 csrf 보호 기능을 비활성화하고 X-Frame-Options을 비활성화 하여 
	// h2-console과 같은 관리 페이지를 이동하는데 로그인 양식이 뜨지 않도록 메서드를 구성했다. 
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated());
		http.formLogin(withDefaults());
		
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
		return http.build();
	}
	
}

// Spring Security의 경우 메모리 내에서 저장된 사용자 이름/비밀번호 기반 인증을 지원하기 위해 InMemoryUserDetailsManager 클래스를 이용한다. 
// 그냥 비밀번호를 사용하는 것은 보안상 좋지 않기 때문에 PasswordEncoder 클래스를 이용해 BCryptPasswordEncoder 라는 해시함수 기반의 암호화 알고리즘을 사용하는 메서드를 생성한다.
// UserDetails는 사용자 객체 생성과 더불어 세부 정보를 설정할 수 있는데 builder 함수를 기반으로 비밀번호 암호화, 유저 이름, 비밀번호, 권한을 설정할 수 있다.
// 사용자로부터 비밀번호를 받아 암호화 해야 하기 때문에 함수형 인터페이스를 사용하는데, 사용자로부터 input 값을 받으면 passwordEncoder 메서드를 사용해 암호화하고 
// 그 내용을 paswordEncoder라는 함수형 인터페이스로 생성한다. 이 함수는 두개의 제네릭 타입 매개변수를 가지는데 첫 번째는 입력이고 두 번째는 결과값을 뜻한다.
// passwordEncoder의 매개변수로 함수형 인터페이스가 사용되는 이유는 나중에 암호화 알고리즘을 교체할 때 교체 가능성을 높힐 수 있고, 유지 보수성과 확장성을 향상할 수 있기 때문이다. 