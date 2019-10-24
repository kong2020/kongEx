package com.example.todo.repository;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.todo.entity.TodoList;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Long> {
    
	@Query("SELECT p " +
            "FROM TodoList p " +
            "ORDER BY p.id DESC")
	Stream<TodoList> findAllDesc();
}
