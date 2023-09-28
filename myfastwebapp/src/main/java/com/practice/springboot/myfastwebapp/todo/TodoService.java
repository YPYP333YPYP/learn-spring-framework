package com.practice.springboot.myfastwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	
	private static int todosCount = 0;
	
	static {
		todos.add(new Todo(++todosCount, "Lee", "Learn Google Cloud", LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todosCount, "Lee", "Learn DevOps", LocalDate.now().plusYears(2),false));
		todos.add(new Todo(++todosCount, "Lee", "Learn Full Stack", LocalDate.now().plusYears(3),false));
		
	}
	
	// findByUsername의 메서드 또한 바뀌게 되는데 todo의 username과 사용자가 입력한 username의 일치를 판단하는 함수형 인터페이스를 생성해서
	// stream 객체로 데이터의 흐름을 만들고 필터링을 하여 일치하는 것만 반환할 수 있게 된다. 
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate = 
				todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
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
	
	// id 값에 따라 Todo 객체를 반환하는 메서드
	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		
		// stream은 배열이나 컬렉션 인스턴스를 for문 혹은 foreach문을 도는 것과 똑같은 방식으로 탐색할 수 있는 클래스
		// 보통 사용하는 방식은 stream 인스턴스 생성 -> 가공(필터링 or 맵핑 등등) -> 결과물 생성
		// stream 객체에서 predicate를 인자로 받는 fileter 함수를 실행 (필터링) -> 첫번째 객체를 -> get
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
	
	// description 필드값에 대한 제한을 검증
	public void updateTodo(@Valid Todo todo) {
		// 해당하는 todo를 삭제하고, 사용자가 요청한 todo를 더함
		deleteById(todo.getId());
		todos.add(todo);
	}
}
