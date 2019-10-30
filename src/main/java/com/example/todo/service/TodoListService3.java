package com.example.todo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.todo.entity.TodoList;
import com.example.todo.repository.TodoListRepository3;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Service
@Slf4j
public class TodoListService3 {
  private TodoListRepository3 todoListRepository3;

  @Transactional(readOnly = true)
  public Page<TodoList> findAll(Pageable pageable) {

    int page =
        (pageable.getPageNumber() == 0)
            ? 0
            : (pageable.getPageNumber() - 1); // page는 index 처럼 0부터 시작
    
    pageable = PageRequest.of(page, 10, new Sort(Sort.Direction.DESC, "id"));

    Page<TodoList> todoList = todoListRepository3.findAll(pageable);
    
    log.info("총 element 수 : {}, 전체 page 수 : {}, 페이지에 표시할 element 수 : {}, 현재 페이지 index : {}, 현재 페이지의 element 수 : {}",
    		todoList.getTotalElements(), todoList.getTotalPages(), todoList.getSize(),
    		todoList.getNumber(), todoList.getNumberOfElements());
    
    return todoList;
  }
}
