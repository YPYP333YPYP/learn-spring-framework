package com.practice.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//record는 Java 16 부터 나온 기능으로 getter, setter, 생성자를 만들 필요 없이 자동으로 만들어주는 기능을 가진다. 
record Person (String name, int age, Address address) {};

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
	
	// 하드 코딩으로 Bean 생성
	@Bean
	public Person person() {
		return new Person("Kim", 20, new Address("Baker Street","London"));
	
	}
	
	// 기존의 Bean을 재사용해서 사용 
	// method 1. 메서드를 사용하는 방법
	@Bean
	public Person person2MethodCall() {
		return new Person(name(), age(), address());
	}
	
	// method 2. 파라미터를 사용하는 방법
	@Bean
	public Person person3Parameters(String name, int age, Address address3) {
		return new Person(name, age, address3);
	}
	
	// address 객체는 address2 라는 bean name을 가질 수 있다. 
	@Bean(name = "address2")
	public Address address() {
		return new Address("Baker Street","London");
	}
	
	@Bean(name = "address3")
	public Address address3() {
		return new Address("Main Street","Seoul");
	}
}
