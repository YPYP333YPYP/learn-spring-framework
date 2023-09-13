package com.practice.springboot.learnspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBootApplication.class, args);
	}

}

// Spring Boot Starter Project는 편리한 의존성 디스크립터이다. 
// Spring Boot에 필요한 모든 의존성은 Starter Project에 포함되어 있다. 

// Spring Boot에서 사용자를 위한 REST API를 개발한다고 쳤을 때 많은 설정을 요구한다. 
// 이때 도움을 주는 요소가 Spring Boot Auto Configuration이다.
// Maven Dependencies -> spring-boot-autoconfigure.jar 파일에 보면 많은 package를 볼 수 있다.
// Auto Configuration 덕분에 bean을 자동으로 json으로 변환하고 error page를 디폴트값으로 생성하는 등 사용자의 편의에 많은 도움을 준다. 

