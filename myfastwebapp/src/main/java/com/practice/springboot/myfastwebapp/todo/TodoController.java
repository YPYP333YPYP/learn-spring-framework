package com.practice.springboot.myfastwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

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
	public String showNewTodoPage(ModelMap model) {
		String username = (String)model.get("name");
		Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "todo";
	}
	
	// Todo 객체의 필드값은 5개이다. 만약 필드값이 10개 이상이라면 파라미터로 적기 애매할 것 이다.
	// 그렇기에 등장한 개념이 커맨드 빈이다. Spring Bean에 등록 되어있기 때문에 직접 Todo Bean에 바인딩 하는 것 이다. 
	// 이때 주의할 점은 ModelMap이 인자로 먼저 와야 한다는 것 이다. 
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		String username = (String)model.get("name");
		todoService.addTodo(username, todo.getDescription(), LocalDate.now().plusYears(1), false);
		
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteById(id);
		return "redirect:list-todos";
		
	}
	
	
	// 업데이트 페이지로 이동(todo page)
	@RequestMapping(value="update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		// todo를 수정하기 위해서 id가 일치하는 todo를 가져와서 사용자에게 보여줌
		Todo todo = todoService.findById(id);
		model.addAttribute("todo", todo);
		return "todo";
	}
	
	// todo page에서 form 형식으로 POST 요청을 보냄
	@RequestMapping(value="update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		
		String username = (String)model.get("name");
		todo.setUsername(username);
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}
	
}


// 하나의 요청에 관련되어 있는 값들은 해당 요청에 한해서만 유효하다.
// 마찬가지로 모델에 있는 값 또한 새로운 요청이 생기면서 새로운 페이지로 이동하면 없어지게 된다.
// 이런 상황에서 값을 오랫동안 유지하고 싶으면 세션에다가 담아야한다. 
// @SessionAttributes 어노테이션을 통해 여러 요청 동안 정보를 사용할 수 있다.
// 세션은 모든 세부정보를 가지고 있기 때문에 조심해서 사용해야한다. 