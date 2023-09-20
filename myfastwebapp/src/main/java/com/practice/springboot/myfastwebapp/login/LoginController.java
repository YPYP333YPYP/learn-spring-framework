package com.practice.springboot.myfastwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	// URL에서 값을 받아서 컨트롤러 코드에 전달하기 위해서 @RequestParam을 사용해야 한다. 
	// 이렇게 받은 값을 jsp에 전달할려고 하는데 이때 등장하는 개념이 Model이다. 
	// 컨트롤러에서 jsp로 전달하려고 할 때 그 내용을 모델에 넣어서 진행할 수 있다.
	// Spring MVC가 제공하는 옵션 중 ModelMap이 있는데 이것을 이용해 jsp 값을 사용할 수 있다. 
	@RequestMapping("login")
	public String gotoLoginPage(@RequestParam String name, ModelMap model) {
		model.put("name", name);
		return "login";
	}

}
