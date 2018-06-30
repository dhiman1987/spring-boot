package com.dexter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("todo")
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@GetMapping("/search")
	public List<TodoEntity> getTodos(
			@RequestParam(value="title", required=false) String title,
			@RequestParam(value="description", required=false) String description,
			@RequestParam(value="category", required=false) String category,
			@RequestParam(value="id", required=false) Long id
			){
		List<TodoEntity> todos =  new ArrayList<>();
		
		if(!StringUtils.isEmpty(title)) {
			todos = todoService.findByTitle(title);
		}else if(!StringUtils.isEmpty(description)) {
			todos = todoService.findByDescriptionContains(description);
		}else if(!StringUtils.isEmpty(category)) {
			todos = todoService.findByCatagory(category);
		}else if(null!=id) {
			Optional<TodoEntity> todo = todoService.findById(id);
			if(todo.isPresent()) {
				todos.add(todo.get());
			}
		}else {
			todos = todoService.findAll();
		}
		
		return todos;
	}
	
	@GetMapping("/search-in-time-range")
	public List<TodoEntity> getTodos(
			@RequestParam(value="startDate") String startDateStr,
			@RequestParam(value="endDate") String endDateStr) throws Exception{
		
		if(StringUtils.isEmpty(startDateStr) || StringUtils.isEmpty(startDateStr)) {
			throw new Exception("startDate and endDate is mandatory");
		}
		SimpleDateFormat sdf =  new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(false);
		Date startDate = null;
		Date endDate = null;
		
		startDate = sdf.parse(startDateStr);
		endDate = sdf.parse(endDateStr);
		
		return todoService.findIncompleteTodosInTimeRange(startDate, endDate);
	}
	
	
	@PostMapping(value="/add",consumes="application/json")
	@Transactional
	public long addTodo(TodoEntity todo)throws Exception {
		if(null== todo) {
			throw new Exception("Cannot add NULL TODO");
		}
		return todoService.addTodo(todo);
	}
	
	@PutMapping(value="/update",consumes="application/json")
	@Transactional
	public long updateTodo(TodoEntity todo) throws Exception {
		if(null== todo) {
			throw new Exception("Cannot add NULL TODO");
		}
		if(null==todo.getId()) {
			throw new Exception("Cannot add update TODO with null id");
		}
		return todoService.addTodo(todo);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public String deleteToDo(@PathParam("id") Long id) {
		String message = "";
		try {
			id = todoService.deleteTodo(id);
			if(id>=0) {
				message="Successfully deleted todo with id "+id;
			}
		} catch (Exception e) {
			message=e.getMessage();
		}
		return message;
	}
	
}
