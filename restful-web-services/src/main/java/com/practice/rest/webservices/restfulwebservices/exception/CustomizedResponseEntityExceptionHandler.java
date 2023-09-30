package com.practice.rest.webservices.restfulwebservices.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

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
	
	// 클라이언트가 보낸 요청에서 문제가 유효성 검증에 실패한 경우 클라이언트에게 명확한 오류 메세지를 보내서 정상적인 값을 받도록 유도하는 것은 중요하다.
	// 그렇기에 handleMethodArgumentNotValid 클래스를 오버라이딩 하여 문제가 생긴 부분을 errorDetails 객체에 담아서 ResponseEntity로 반환하도록 한다. 
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), 
				"Total Errors:" + ex.getErrorCount() + " First Error:" + ex.getFieldError().getDefaultMessage(), request.getDescription(false));
		
		
		return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	

	
}