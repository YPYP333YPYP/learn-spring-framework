package com.practice.springboot.myfastwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	private AuthenticationService authenticationService;
	
	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	// 일반적으로 정보를 확인할 때 sysout을 사용하지만 이것 보다는 logging을 사용하는 것이 좋다.
	// logging은 레벨에 따라 debug, info 등 세분화하여 메세지를 확인할 수 있다.
	// Logback은 로깅 프레임워크이며 여기서는 SLF4j를 사용했다. 
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	// URL에서 값을 받아서 컨트롤러 코드에 전달하기 위해서 @RequestParam을 사용해야 한다. 
	// 이렇게 받은 값을 jsp에 전달할려고 하는데 이때 등장하는 개념이 Model이다. 
	// 컨트롤러에서 jsp로 전달하려고 할 때 그 내용을 모델에 넣어서 진행할 수 있다.
	// Spring MVC가 제공하는 옵션 중 ModelMap이 있는데 이것을 이용해 jsp 값을 사용할 수 있다. 
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String gotoLoginPage() {
		return "login";
	}
	
	// login page 자체로 이동하는 것은 GET API 이지만 로그인 페이지에서 회원 가입을 하는 Form의 경우는 POST 방식이다. 
	// 그렇기에 RequestMapping 옵션 중 method 옵션을 다르게 주어 다른 API로 설정할 수 있다.
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
		
		if (authenticationService.authentiacate(name, password)) {
			
			model.put("name", name);
			
			return "welcome";
		}
		model.put("errorMessage", "Invalid Credentials! Plz try again");
		return "login";
	}

}
