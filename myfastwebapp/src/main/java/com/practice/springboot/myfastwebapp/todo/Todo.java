package com.practice.springboot.myfastwebapp.todo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;


// Entity 어노테이션을 사용하면 Spring Bean을 자동으로 Database 테이블로 생성할 수 있게 된다.
// Id 어노테이션이나 Column 어노테이션을 사용해 속성의 이름을 변경하는 등의 행동을 취할 수 있다. 
@Entity
public class Todo {
	
	@Id
	@GeneratedValue
	private int id;
	private String username;
	
	@Size(min=10, message="Enter at least 10 characters")
	private String description;
	private LocalDate targetDate;
	private boolean done;
	
	public Todo() {
		
	}
	
	
	public Todo(int id, String username, String description, LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getDescription() {
		return description;
	}
	public LocalDate getTargetDate() {
		return targetDate;
	}
	public boolean isDone() {
		return done;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	
	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
				+ targetDate + ", done=" + done + "]";
	}
	

}
