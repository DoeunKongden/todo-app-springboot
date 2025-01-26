package com.example.mytodolistapp.mapper;

import com.example.mytodolistapp.model.Todo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TodoMapper {

    @Select("SELECT * FROM todos;")
    List<Todo> findAllTodo();

    @Select("SELECT * FROM todos WHERE id=#{id}")
    Todo findTodoById(Long id);

    @Insert("INSERT INTO todos(title,description,completed,created_at,updated_at,category_id)" +
            "VALUES(#{title}, #{description}, #{completed}, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, #{category_id})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addNewTodo(Todo todo);

    @Update("""
            UPDATE todos
            SET title=#{title}, description=#{description}, completed=#{completed},
            category_id=#{category_id}, updated_at= CURRENT_TIMESTAMP
            WHERE id=#{id}
            """)
    void updateTodo(Todo todo, Long id);

    @Delete("""
            DELETE FROM todos WHERE id= #{id}
            """)
    void deleteTodo(Long id);
}
