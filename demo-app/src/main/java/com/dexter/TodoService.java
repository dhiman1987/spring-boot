package com.dexter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

	@Autowired
	private TodoRepo todoRepo;
	
	public List<TodoEntity> findByTitle(String title){
		return todoRepo.findByTitle(title);
	}
	public List<TodoEntity> findByDescriptionContains(String description){
		return todoRepo.findByDescriptionContains(description);
	}
	public List<TodoEntity> findByCatagory(String name){
		return todoRepo.findByCategory_Name(name);
	}
	
	public List<TodoEntity> findIncompleteTodosInTimeRange(Date startDate,Date endDate ){
		SimpleDateFormat sdf =  new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(false);
		System.out.println(sdf.format(startDate)+" to "+sdf.format(endDate));
		return todoRepo.findIncompleteTodosInTimeRange(startDate,endDate);
	}
	public List<TodoEntity> findAll() {
		List<TodoEntity> todos =  new ArrayList<>();
		Iterable<TodoEntity> todoIterable = todoRepo.findAll();
		todoIterable.iterator().forEachRemaining(todos::add);
		return todos;
	}
	
	public Optional<TodoEntity> findById(Long id) {
		return todoRepo.findById(id);
	}
	
	public long addTodo(TodoEntity todo) {
		todoRepo.save(todo);
		return todo.getId();
	}
	
	public long updateTodo(TodoEntity todo) throws Exception {
		Optional<TodoEntity> todoTemp = todoRepo.findById(todo.getId());
		if(todoTemp.isPresent()) {
			todoRepo.save(todo);
		}else {
			throw new Exception("Unable to find TODO to update");
		}
		return todo.getId();
	}
	
	public long deleteTodo(long id) throws Exception {
		Optional<TodoEntity> todoTemp = todoRepo.findById(id);
		if(todoTemp.isPresent()) {
			todoRepo.delete(todoTemp.get());
		}else {
			throw new Exception("Unable to find TODO to delete");
		}
		return id;
	}
	
	
}
