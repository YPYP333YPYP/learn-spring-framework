package com.practice.springboot.myfastwebapp.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		
		Function<String, String> passwordEncoder
				= input -> passwordEncoder().encode(input);
		
		UserDetails userDetails = User.builder()
									.passwordEncoder(passwordEncoder)
									.username("Lee")
									.password("dummy")
									.roles("USER","ADMIN")
									.build();
		
		return new InMemoryUserDetailsManager(userDetails);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}

// Spring Security의 경우 메모리 내에서 저장된 사용자 이름/비밀번호 기반 인증을 지원하기 위해 InMemoryUserDetailsManager 클래스를 이용한다. 
// 그냥 비밀번호를 사용하는 것은 보안상 좋지 않기 때문에 PasswordEncoder 클래스를 이용해 BCryptPasswordEncoder 라는 해시함수 기반의 암호화 알고리즘을 사용하는 메서드를 생성한다.
// UserDetails는 사용자 객체 생성과 더불어 세부 정보를 설정할 수 있는데 builder 함수를 기반으로 비밀번호 암호화, 유저 이름, 비밀번호, 권한을 설정할 수 있다.
// 사용자로부터 비밀번호를 받아 암호화 해야 하기 때문에 함수형 인터페이스를 사용하는데, 사용자로부터 input 값을 받으면 passwordEncoder 메서드를 사용해 암호화하고 
// 그 내용을 paswordEncoder라는 함수형 인터페이스로 생성한다. 이 함수는 두개의 제네릭 타입 매개변수를 가지는데 첫 번째는 입력이고 두 번째는 결과값을 뜻한다.
// passwordEncoder의 매개변수로 함수형 인터페이스가 사용되는 이유는 나중에 암호화 알고리즘을 교체할 때 교체 가능성을 높힐 수 있고, 유지 보수성과 확장성을 향상할 수 있기 때문이다. 