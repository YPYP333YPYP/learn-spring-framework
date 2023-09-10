package com.practice.learnspringframework.examples.e1;

import java.util.Arrays;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



@Component
class NormalClass {
	
}

@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass {
	
}


@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {

	public static void main(String[] args) {
		
		var context = new AnnotationConfigApplicationContext(BeanScopesLauncherApplication.class);
		
		// 싱글톤 타입은 Spring에서 디폴트 값이고 Spring Bean을 호출할 때마다 같은 인스턴스를 검색한다.
		System.out.println(context.getBean(NormalClass.class));
		System.out.println(context.getBean(NormalClass.class));
		System.out.println(context.getBean(NormalClass.class));
		
		// 프로토타입은 @Scope 어노테이션을 사용해서 따로 지정해줘야 하고 Spring Bean을 호출 할때마다 다른 인스턴스를 검색한다.
		System.out.println(context.getBean(PrototypeClass.class));
		System.out.println(context.getBean(PrototypeClass.class));
		System.out.println(context.getBean(PrototypeClass.class));
	}

}