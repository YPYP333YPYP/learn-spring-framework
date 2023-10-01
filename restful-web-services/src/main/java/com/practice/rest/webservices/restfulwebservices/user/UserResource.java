package com.practice.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {

	private UserDaoService service;

	public UserResource(UserDaoService service) {
		this.service = service;
	}

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);
		
		if(user==null)
			throw new UserNotFoundException("id:"+id);
		
		EntityModel<User> entityModel = EntityModel.of(user);
		
		WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
	}
	
	// POST API의 경우에는 @RequestBody가 필요한데, 이 어노테이션은 Java Spring의 객체를 HTTP 요청의 바디값으로 사용하겠다는 어노테이션이다.
	// ResponseEntity의 경우 사용자의 HttpRequest에 대한 응답 데이터를 포함하는 클래스이다. 
	// 기존에는 간단하게 User 객체를 반환했다면 사용자로 하여금 create를 뜻하는 201코드를 전송하며 더불어 생성된 User를 조회할 수 있는
	// location를 사용자로 하여금 전달하기 위해서 ResponseEntity를 반환하는 것 이다.
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		
		User savedUser = service.save(user);
		
		// ResponseEntity의 경우 created 메서드를 사용할 수 있는데 이는 201 created 상태 코드와 함께
		// 새로운 리소스의 위치를 표시하는 응답을 생성하며 build 메서드를 통해 최종적으로 반환되어진다.
		
		// location 변수는 ServletUriComponentsBuilder 클래스를 사용하는데 이 부분은 현재 요청의 URI를 기반으로 새로운 URI를 만들고 
		// path는 기본 경로를 buildAndExapand 부분은 생성된 User의 Id 정보를 추가하고 toUri를 통해 객체에서 URI로 전환되어 변수에 담기게 된다.
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedUser.getId())
						.toUri();   
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deleteById(id);
	}
}
