package com.practice.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
		// 목표 : 원래는 JVM 이 관리하는 객체들을 Spring이 관리하도록 한다.
		
		// step1. Spring Context를 실행한다.
		
		var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
		
		// step2. Spring이 이것들을 관리할것을 설정한다. 
		// HelloWorldConfiguration -@Configuration
		// name - @Bean
		
		// step3. Bean이 Spring에 의해 관리 되는지 확인한다.
		System.out.println(context.getBean("name"));
		
	}

}