package com.example.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todo.entity.TodoList;

@Repository
public interface TodoListRepository3 extends JpaRepository<TodoList, Long> {
    
}
