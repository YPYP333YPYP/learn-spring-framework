package com.practice.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//record는 Java 16 부터 나온 기능으로 getter, setter, 생성자를 만들 필요 없이 자동으로 만들어주는 기능을 가진다. 
record Person (String name, int age) {};

record Address (String firstLine, String city) {};
@Configuration
// Configuration 어노테이션을 사용한 클래스의 경우 Spring Bean을 정의할 수 있다. 
// Bean 이란 Spring이 관리하는 객체를 의미한다.
public class HelloWorldConfiguration {

	@Bean
	public String name() {
		return "Lee";
	}
	
	@Bean 
	public int age() {
		return 15;
	}
	
	@Bean
	public Person person() {
		return new Person("Kim", 20);
	
	}
	
	@Bean
	public Address address() {
		return new Address("Baker Street","London");
	}
}
