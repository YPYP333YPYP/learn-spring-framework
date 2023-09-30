package com.practice.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {
	
	
	private Integer id;
	
	
	// 이전에 했던 내용 처럼 Controller에서 파라미터에 @Valid 어노테이션이 사용되면 필드값에 대해서 유효성 검증이 가능하다.
	// 예시로 @Size는 글자수의 최소크기를 지정할 수 있고, @Past는 Date에 대해서 이전의 Date만 사용하도록 만들 수 있다.
	@Size(min=2, message = "Name should have atleast 2 characters")
	private String name;
	
	@Past(message = "Birth Date should be in the past")
	private LocalDate birthDate;
	
	public User(Integer id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
}