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
	
	// 가장 널리 사용되는 뷰 기술은 JSP(Java Server Pages)이다. 
	// jsp 파일은 Spring Boot에서 특정한 경로의 폴더에 생성 해야한다. 
	// 즉 jsp 파일은 항상 같은 공간에 저장 되기 때문에 application.properties 파일에 항상 앞에오는 내용을 prefix에 저장, 항상 뒤에 오는 내용을 suffix에 저장할 수 있다.
	// 여기서는 @ResponseBody 어노테이션을 제거해야 하는데 이유는 우리가 원하는 것은 jsp로 리다이렉션 하는 것이기 때문이다. 
	// 일련의 과정을 살펴보면 /say-hello-jsp 라는 url로 접속하면 SayHelloController의 sayHelloJsp method가 요청을 처리하는데 이때 sayHello가 return 된다.
	// 여기서 Spring MVC는 뷰 리졸버를 사용하는데 application.properties에 설정해놓은 접두어와 접미어를 통해 경로와 확장자명을 붙이게 되고 완성된 jsp 파일로 사용자에게 리다이렉션하게 된다. 
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}
	
	
}
