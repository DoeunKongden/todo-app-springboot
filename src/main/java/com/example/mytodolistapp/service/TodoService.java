package com.example.mytodolistapp.service;

import com.example.mytodolistapp.mapper.TodoMapper;
import com.example.mytodolistapp.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoMapper todoMapper;
    public List<Todo> getAllTodos(){
        return  todoMapper.findAllTodo();
    }
    public Todo getTodoById(Long id){
        return todoMapper.findTodoById(id);
    }

    public void createTodo(Todo todo){
        todoMapper.addNewTodo(todo);
    }

    public void updateTodo(Todo todo, Long id){
        todoMapper.updateTodo(todo,id);
    }

    public void deleteTodo(Long id){
        todoMapper.deleteTodo(id);
    }
}
