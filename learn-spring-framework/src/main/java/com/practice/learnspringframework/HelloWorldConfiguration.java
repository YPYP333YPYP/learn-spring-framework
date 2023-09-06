package com.practice.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// Configuration 어노테이션을 사용한 클래스의 경우 Spring Bean을 정의할 수 있다. 
// Bean 이란 Spring이 관리하는 객체를 의미한다.
public class HelloWorldConfiguration {

	@Bean
	public String name() {
		return "Lee";
	}
}
