package com.practice.springboot.myfastwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	
	// Spring MVC는 문자열을 리턴할 때, 이름으로 된 뷰를 검색하기 때문에 그냥 문자열을 쓰는 대신에 @ResponseBody 어노테이션을 사용해야한다. 
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello! What are you learning today?";
	}
}
