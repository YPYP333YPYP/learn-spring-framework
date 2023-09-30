package com.practice.rest.webservices.restfulwebservices.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.practice.rest.webservices.restfulwebservices.user.UserNotFoundException;

// @ControllAdvice 어노테이션은 여러 컨트롤러 클래스에서 발생하는 예외를 처리할 수 있다.
// 아래처럼 클라이언트에게 에러메세지를 응답할 때 원하는 내용을 보내고 싶다면 ExceptionHandler를 이용해 커스터마이징 할수 있다.
// ResponseEntityExceptionHandler는 기본적으로 예외 처리 클래스를 확장하여 사용할 때 사용하는 클래스이다. 
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	// @ExceptionHandler 어노테이션을 사용한 부분에서 매개변수 안에 있는 예외 클래스와 하위 예외를 처리한다고 정의하는 부분이다. 
	// 내용을 보면 요청에 대해서 에러 ResponseEntity를 응답할때 errorDetails이라는 변수를 만들어 에러에 대한 내용을 정의하고 상태코드와 더불어 반환하는 내용이다.
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), 
				ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), 
				ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
		
	}

	
}