package com.practice.learnspringframework.examples.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// 3개의 class 생성 -> YourBusinessClass, Dependency1, Dependency2
// YourBusinessClass가 Dependency1, Dependency2의 의존성을 가진다.

// 결론 : 3개의 방법 중에 무엇을 사용해야 할까? -> 생성자 주입을 사용 -> 이유는 생성자라는 메서드 하나로 모든 의존성을 주입할 수 있기 때문이다.
@Component
class YourBusinessClass {
	
	// 3개의 옵션 -> 필드 주입, 세터 주입, 생성자 주입
	
	// 1. 필드 주입 -> 생성한 객체에 @Autowired 어노테이션 사용
	//@Autowired
	Dependency1 dependency1;
	//@Autowired
	Dependency2 dependency2;
	
	// 2. 세터 주입 -> setter 코드에 @Autowried 어노테이션 사용
	//@Autowired
	public void setDependency1(Dependency1 dependency1) {
		System.out.println("Use setter Injection");
		this.dependency1 = dependency1;
	}

	//@Autowired
	public void setDependency2(Dependency2 dependency2) {
		this.dependency2 = dependency2;
	}
	
	// 3. 생성자 주입 -> 의존성을 인수로 가지는 생성자를 생성
	public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		System.out.println("Use Constructor Injection");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}

	public String toString() {
		return "Using " + dependency1 + " and " + dependency2;
	}

}

@Component
class Dependency1 {
	

}

@Component
class Dependency2 {
	
	
}

@Configuration
@ComponentScan
public class DepInjectionLauncherApplication {

	public static void main(String[] args) {
		
		var context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class);
		
		Arrays.stream(context.getBeanDefinitionNames())		
		.forEach(System.out::println);
		
		System.out.println(context.getBean(YourBusinessClass.class));
	}

}