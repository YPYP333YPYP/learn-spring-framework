package com.practice.learnspringframework.examples.d1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {
	
}


@Component
@Lazy
// 초기화 하는 것을 지연하고 싶을 경우 사용 -> 언제 초기화가 되나 ? -> 사용할 때 초기화가 된다.
class ClassB {
	ClassA ClassA;
	
	public ClassB(ClassA ClassA) {
		// ClassB와 같이 @Bean이나 @Component 어노테이션이 사용된 클래스의 경우 어플리케이션의 시작과 함께 초기화된다.
		System.out.println("ClassB Initialization");
		this.ClassA = ClassA;
	}
	
	void doSomething() {
		System.out.println("Using ClassB Bean");
	}
	
	
}



@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {

	public static void main(String[] args) {
		
		var context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class);
		
		context.getBean(ClassB.class).doSomething();;
		
	}

}