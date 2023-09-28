package com.practice.springboot.myfastwebapp.login;


import org.springframework.security.core.Authentication;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

	@RequestMapping(value="/",method = RequestMethod.GET)
	public String gotoWelcomePage(ModelMap model) {
		model.put("name", getLoggedinUsername());
		return "welcome";
	}
	
	// 먼저 SecurityContextHolder 클래스는 Spring Security에서 인증 정보를 관리하는 클래스이다.
	// 여기서 getContext 메서드를 호출하여 SecurityContext를 얻을 수 있다. 또한 getAuthentication 메서드로 사용자의 인증정보를 받아올 수 있는데
	// 이 내용을 Authentication 인터페이스의 객체에 저장할 수 있다. 
	private String getLoggedinUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}