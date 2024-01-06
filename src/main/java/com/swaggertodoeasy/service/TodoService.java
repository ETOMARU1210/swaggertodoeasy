package com.swaggertodoeasy.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.swaggertodoeasy.entity.Todo;

@Service
public class TodoService {
	
	private List<Todo> allItems = new ArrayList<Todo>(Arrays.asList(
			new Todo("1", "タイトル1", "未着手", "詳細1"),
			new Todo("2", "タイトル2", "未着手", "詳細2"),
			new Todo("3", "タイトル3", "進行中", "詳細3"),
			new Todo("4", "タイトル4", "完了", "詳細4"),
			new Todo("5", "タイトル5", "未着手", "詳細5"),
			new Todo("6", "タイトル5", "未着手", "詳細5"),
			new Todo("7", "タイトル5", "未着手", "詳細5"),
			new Todo("8", "タイトル5", "未着手", "詳細5"),
			new Todo("9", "タイトル5", "未着手", "詳細5")
	));
	
	public List<Todo> allItems() {
		return allItems;
	}
	
	public Todo getItem(String id) {
		for (int i = 0; i < allItems.size(); i++) {
			if (allItems.get(i).getId().equals(id)) {
				return allItems.get(i);
			}
		}
		return null;
	}
	
	public void addItem(Todo todo) {
		allItems.add(todo);
	}
	
	public void updateItem(String id, Todo todo) {
		for (int i = 0; i < allItems.size(); i++) {
			if (allItems.get(i).getId().equals(id)) {
				allItems.set(i, todo);
			}
		}
	}
	
	public void deleteItem(String id) {
		allItems.removeIf(todo -> todo.getId().equals(id) );
	}
	
	public List<Todo> titleItem(String title){
		List<Todo> todos = new ArrayList<>();
		for (int i = 0; i < allItems.size(); i++) {
			if (allItems.get(i).getTitle().equals(title)) {
				 todos.add(allItems.get(i));
			}
		}
		
		return todos;
	}
	
	public List<Todo> statusItem(String status){
		List<Todo> todos = new ArrayList<>();
		for (int i = 0; i < allItems.size(); i++) {
			if (allItems.get(i).getStatus().equals(status)) {
				 todos.add(allItems.get(i));
			}
		}
		return todos;
	}
}
