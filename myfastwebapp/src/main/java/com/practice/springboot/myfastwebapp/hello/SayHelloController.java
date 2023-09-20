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
	
	// 그냥 문자열을 첨부하는 것은 효율성이 떨어지기 때문에 StringBuffer를 사용하여 html 구문을 삽입
	// html을 response로 사용했지만 위 방식은 사실상 비효율적, 다음 단계에서 View를 이용하여 개선필요
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>My first HTML Page</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My first html page with body");
		sb.append("</body>");
		sb.append("</html>");
		
		return sb.toString();
	}
}
