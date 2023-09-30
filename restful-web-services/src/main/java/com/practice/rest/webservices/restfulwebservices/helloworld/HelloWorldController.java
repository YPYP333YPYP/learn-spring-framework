package com.practice.rest.webservices.restfulwebservices.helloworld;


import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


// @RestController 어노테이션은 기존의 View만을 반환하는 @Controller와 다르게 JSON 형태로 객체 데이터를 반환할 수 있는 Controller를 생성하게 만든다.
@RestController
public class HelloWorldController {
	
	
	private MessageSource messageSource;
	
	public HelloWorldController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	// RequestMapping 어노테이션을 사용하여 API 방식과 경로를 설정할 수 있지만, GetMapping 어노테이션을 사용하는 것이 더 효율적이며 일반적이다.
	//@RequestMapping(method=RequestMethod.GET, path="/hello-world")
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World"; 
	}
	
	// String 반환이 아닌, JSON 형식으로 객체 데이터(Spring Bean)을 반환하는 컨트롤러를 생성했다.
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World"); 
	}
	
	// URL에 사용자가 정보를 입력하는 경우도 있는데 그 부분을 패스 매개변수라고 부른다.
	// 입력하는 부분은 path 상에서 { } 처리하며 Controller 메서드에서는 @PathVariable 어노테이션을 사용하여 값을 입력받는다.
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name)); 
	}
	

	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale );
		

	}


	
}