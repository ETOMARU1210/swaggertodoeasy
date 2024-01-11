package com.swaggertodoeasy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.swaggertodoeasy.entity.Todo;

@Mapper
public interface TodoMapper {
	
	@Select("SELECT id, title, status, detail FROM todos")
	public List<Todo> getAllTodos();

	@Select("SELECT id, title, status, detail FROM todos WHERE id = #{id}")
	public Todo getTodo(long id);

	@Insert("INSERT INTO todos (title, status, detail) VALUES (#{title}, #{status}, #{detail})")
	public void addTodo(Todo todo);

	@Update("UPDATE todos SET title = #{todo.title}, status = #{todo.status}, detail=#{todo.detail} WHERE id = #{id}")
	public void updateTodo(@Param("id") long id, @Param("todo") Todo todo);

	@Delete("DELETE FROM todos WHERE id = #{id}")
	public void deleteTodo(long id);

	@Select("SELECT id, title, status, detail FROM todos WHERE title = #{title} AND status = #{status}")
	public List<Todo> getTitleStatusAllTodos(String title, String status);

	@Select("SELECT id, title, status, detail FROM todos WHERE title = #{title}")
	public List<Todo> getTitleAllTodos(String title);

	@Select("SELECT id, title, status, detail FROM todos WHERE status = #{status}")
	public List<Todo> getStatusAllTodos(String status);
}
