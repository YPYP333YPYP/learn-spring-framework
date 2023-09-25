package com.practice.springboot.myfastwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	private TodoService todoService;
	
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		List<Todo> todos = todoService.findByUsername("practice");
		model.addAttribute("todos",todos);
		
		return "listTodos";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewTodoPage() {
		return "todo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewTodo(@RequestParam String description, ModelMap model) {
		String username = (String)model.get("name");
		todoService.addTodo(username, description, LocalDate.now().plusYears(1), false);
		
		return "redirect:list-todos";
	}
	
	
}


// 하나의 요청에 관련되어 있는 값들은 해당 요청에 한해서만 유효하다.
// 마찬가지로 모델에 있는 값 또한 새로운 요청이 생기면서 새로운 페이지로 이동하면 없어지게 된다.
// 이런 상황에서 값을 오랫동안 유지하고 싶으면 세션에다가 담아야한다. 
// @SessionAttributes 어노테이션을 통해 여러 요청 동안 정보를 사용할 수 있다.
// 세션은 모든 세부정보를 가지고 있기 때문에 조심해서 사용해야한다. 