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
	public List<Todo> getAllItems() {
		return todoService.allItems();
	}
	
	@GetMapping(value="/todos/{id}")
	public Todo getItem(@PathVariable String id) {
		return todoService.getItem(id);
	}
	
	@PostMapping(value="/todos")
	public void addItem(@RequestBody Todo todo) {
		todoService.addItem(todo);
	}
	
	@PutMapping(value="/todos/{id}")
	public void updateItem(@PathVariable String id, @RequestBody Todo todo) {
		todoService.updateItem(id, todo);
	}
	
	@DeleteMapping(value="/todos/{id}")
	public void updateItem(@PathVariable String id) {
		todoService.deleteItem(id);
	}
	
	@GetMapping(value="/todos/titles")
	public List<Todo> getTitleItem(@RequestParam("title") String title) {
		return todoService.titleItem(title);
	}
	
	@GetMapping(value="/todos/statuses")
	public List<Todo> getstatusItem(@RequestParam("status") String status) {
		return todoService.statusItem(status);
	}
}
