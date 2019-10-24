package com.example.todo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.todo.dto.ReqTodoListDto;
import com.example.todo.dto.ResTodoListDto;
import com.example.todo.entity.TodoList;
import com.example.todo.repository.TodoListRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TodoListService {
  private TodoListRepository todoListRepository;

  @Transactional
  public ResTodoListDto save(ReqTodoListDto dto) {
    // 신규생성
    Long id = todoListRepository.save(dto.toEntity()).getId();

    // 조회
    if (id != null) {
      Optional<TodoList> todolist = todoListRepository.findById(id);
      return new ResTodoListDto(todolist.get());
    } else {
      return null;
    }
  }

  @Transactional(readOnly = true)
  public List<ResTodoListDto> findAllDesc() {
    // .map(ResTodoListDto::new)는 실제로는 .map(todoList -> new ResTodoListDto(todoList))와 동일
    // return
    // todoListRepository.findAllDesc().map(ResTodoListDto::new).collect(Collectors.toList());
    return todoListRepository
        .findAllDesc()
        .map(todoList -> new ResTodoListDto(todoList))
        .collect(Collectors.toList());
  }

  @Transactional
  public Long delete(ReqTodoListDto dto) {
    todoListRepository.deleteById(dto.getId());
    return dto.getId();
  }
}
