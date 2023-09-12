package com.practice.learnspringframework.examples.h1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.practice.learnspringframework.game.GameRunner;

public class XmlConfigurationContextLauncherApplication {

	public static void main(String[] args) {
		
		var context = new ClassPathXmlApplicationContext("contextConfiguration.xml");
		
		Arrays.stream(context.getBeanDefinitionNames())		
		.forEach(System.out::println);
		
		System.out.println(context.getBean("name"));
		
		System.out.println(context.getBean("age"));
		
		context.getBean(GameRunner.class).run();
	}

}