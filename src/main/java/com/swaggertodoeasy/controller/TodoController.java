package com.swaggertodoeasy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swaggertodoeasy.entity.Todo;
import com.swaggertodoeasy.service.TodoService;

@RestController
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@GetMapping(value="/todos")
	public List<Todo> getAllItems( @RequestParam(required = false) String title, @RequestParam(required=false) String status) {
		if (title != null && status != null) {
			return todoService.getTitleStatusAllItems(title, status);
		}
		else if (title != null) {
			return todoService.getTitleAllItems(title);
		}
		else if (status != null) {
			return todoService.getStatusAllItems(status);
		}
		return todoService.getAllItems();
	}
	
	@GetMapping(value="/todos/{id}")
	public Todo getItem(@PathVariable long id) {
		return todoService.getItem(id);
	}
	
	@PostMapping(value="/todos")
	public void addItem(@RequestBody Todo todo) {
		todoService.addItem(todo);
	}
	
	@PutMapping(value="/todos/{id}")
	public void updateItem(@PathVariable long id, @RequestBody Todo todo) {
		todoService.updateItem(id, todo);
	}
	
	@DeleteMapping(value="/todos/{id}")
	public void updateItem(@PathVariable long id) {
		todoService.deleteItem(id);
	}
}
