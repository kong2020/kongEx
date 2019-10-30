package com.example.todo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.todo.dto.ReqTodoListDto;
import com.example.todo.dto.ResTodoListDto2;
import com.example.todo.entity.TodoList;
import com.example.todo.repository.TodoListRepository2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TodoListService2 {
  private TodoListRepository2 todoListRepository2;

  @Transactional
  public ResTodoListDto2 save(ReqTodoListDto dto) {
    // 신규생성
    Long id = todoListRepository2.save(dto.toEntity()).getId();

    // 조회
    Optional<TodoList> todolist = todoListRepository2.findById(id);
    if(todolist.isPresent()) {
    	TodoList xxx = todolist.get();
    	return new ResTodoListDto2(xxx.getId(), xxx.getContents(), xxx.isDone(), xxx.getModifiedDate());
    } else {
    	return null;
    }
  }

  @Transactional(readOnly = true)
  public List<ResTodoListDto2> findAllDesc() {
    
	List<TodoList> todoList = todoListRepository2.findAllDesc();
    
	List<ResTodoListDto2> resDto = new ArrayList<ResTodoListDto2>();
	for(TodoList todo : todoList) {
		resDto.add(new ResTodoListDto2(todo.getId(), todo.getContents(), todo.isDone(), todo.getModifiedDate()));
    }

    return resDto;
  }

  @Transactional
  public Long delete(ReqTodoListDto dto) {
    todoListRepository2.deleteById(dto.getId());
    return dto.getId();
  }
  
  public Long delete(Long id) {
	    todoListRepository2.deleteById(id);
	    return id;
  }
  
  @Transactional
  public ResTodoListDto2 update(ReqTodoListDto dto) {
    // 수정
    todoListRepository2.save(dto.toEntityForUpdate());

    // 조회
    Optional<TodoList> todolist = todoListRepository2.findById(dto.getId());
    if(todolist.isPresent()) {
    	TodoList xxx = todolist.get();
    	return new ResTodoListDto2(xxx.getId(), xxx.getContents(), xxx.isDone(), xxx.getModifiedDate());
    } else {
    	return null;
    }
  }
}
