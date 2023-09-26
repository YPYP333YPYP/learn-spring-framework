package com.practice.springboot.myfastwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	
	private static int todosCount = 0;
	
	static {
		todos.add(new Todo(++todosCount, "practice", "Learn AWS", LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todosCount, "practice", "Learn DevOps", LocalDate.now().plusYears(2),false));
		todos.add(new Todo(++todosCount, "practice", "Learn Full Stack", LocalDate.now().plusYears(3),false));
		
	}
	
	public List<Todo> findByUsername(String username){
		return todos;
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todosCount, username, description, targetDate, done);
		todos.add(todo);
	}

	// Predicate는 java.util.function 표준 API 패키지의 함수적 인터페이스이다.
	// 람다식 표현을 이용해서 매개값이 조건에 맞는지 확인해 boolean을 리턴하는데
	// 람다식 표현이랑 매개값 -> {구현코드}; 의 형식으로 이뤄진다
	// 즉 매개변수로 받은 id값과 todo의 id 값의 일치여부를 람다식에서 반환하며 
	// Predicate에 값이 담기고 ArrayList(todos)의 removeIf와 같은 Predicate를 인자로 받는 함수를 사용할 수 있다. 
	public void deleteById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}
}
