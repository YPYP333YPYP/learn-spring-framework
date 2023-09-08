package com.practice.learnspringframework.helloworld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App02HelloWorldSpring {

	public static void main(String[] args) {
		// 목표 : 원래는 JVM 이 관리하는 객체들을 Spring이 관리하도록 한다.
		
		// step1. Spring Context를 실행한다.
		
		var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
		
		// step2. Spring이 이것들을 관리하도록 설정한다. 
		// HelloWorldConfiguration -@Configuration
		// name - @Bean
		
		// step3. Bean이 Spring에 의해 관리 되는지 확인한다.
		System.out.println(context.getBean("name"));
		
		System.out.println(context.getBean("age"));
		
		System.out.println(context.getBean("person"));
		
		System.out.println(context.getBean("person2MethodCall"));
		
		System.out.println(context.getBean("person3Parameters"));

		System.out.println(context.getBean("person4Parameters"));

		System.out.println(context.getBean("person5Qualifier"));
		
		System.out.println(context.getBean("address2"));
		
		System.out.println(context.getBean("address3"));
		
		
		
		// 여러 개의 Bean 이 있을 때 이것을 검색하는 방법
		
		// Spring이 관리하는 모든 Bean을 출력하기
		// Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		
		// 겹치는 Bean이 있을 경우 
		System.out.println(context.getBean(Address.class));
		
		System.out.println(context.getBean(Person.class));
	}

}