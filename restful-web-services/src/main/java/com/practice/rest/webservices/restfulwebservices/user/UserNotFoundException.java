package com.practice.rest.webservices.restfulwebservices.user;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Exception 클래스를 상속받아 여러개의 custom Exception을 만들 수 있다.
// @ResponseStatus의 경우 code 값으로 HttpStatus에서 상태코드를 설정할 수 있는데 401,404,500등 상황에 맞게 사용할 수 있다. 
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException(String message) {
		super(message);
	}

}