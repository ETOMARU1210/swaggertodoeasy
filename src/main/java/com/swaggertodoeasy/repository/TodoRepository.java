package com.swaggertodoeasy.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swaggertodoeasy.entity.Todo;
import com.swaggertodoeasy.mapper.TodoMapper;

@Repository
public class TodoRepository {
	
	@Autowired
	private TodoMapper todoMapper;

	public List<Todo> getallTodos() {
		return todoMapper.getAllTodos();
	}

	public Todo getTodo(long id) {
		return todoMapper.getTodo(id);
	}

	public void addItem(Todo todo) {
		todoMapper.addTodo(todo);
	}

	public void updateItem(long id, Todo todo) {
		todoMapper.updateTodo(id, todo);
	}

	public void delete(long id) {
		todoMapper.deleteTodo(id);
	}

	public List<Todo> getTitleStatusallTodos(String title, String status) {
		// TODO 自動生成されたメソッド・スタブ
		return todoMapper.getTitleStatusAllTodos(title, status);
	}

	public List<Todo> getTitleallTodos(String title) {
		// TODO 自動生成されたメソッド・スタブ
		return todoMapper.getTitleAllTodos(title);
	}

	public List<Todo> getStatusallTodos(String status) {
		// TODO 自動生成されたメソッド・スタブ
		return todoMapper.getStatusAllTodos(status);
	}
}
