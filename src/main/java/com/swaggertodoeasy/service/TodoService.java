package com.swaggertodoeasy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swaggertodoeasy.entity.Todo;
import com.swaggertodoeasy.repository.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository todoRepository;
	
	public List<Todo> getAllItems() {
		List<Todo> todos = todoRepository.getallTodos();
		return todos;
	}
	
	public Todo getItem(long id) {
		return todoRepository.getTodo(id);
	}
	
	public void addItem(Todo todo) {
		todoRepository.addItem(todo);
	}
	
	public void updateItem(long id, Todo todo) {
		todoRepository.updateItem(id, todo);
	}
	
	public void deleteItem(long id) {
		todoRepository.delete(id);
	}

	public List<Todo> getTitleStatusAllItems(String title, String status) {
		return todoRepository.getTitleStatusallTodos(title, status);
	}

	public List<Todo> getTitleAllItems(String title) {
		// TODO 自動生成されたメソッド・スタブ
		return todoRepository.getTitleallTodos(title);

	}

	public List<Todo> getStatusAllItems(String status) {
		// TODO 自動生成されたメソッド・スタブ
		return todoRepository.getStatusallTodos(status);

	}
}
