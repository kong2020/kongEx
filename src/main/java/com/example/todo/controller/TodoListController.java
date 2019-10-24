package com.example.todo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.todo.dto.ReqTodoListDto;
import com.example.todo.dto.ResTodoListDto;
import com.example.todo.service.TodoListService;
import com.example.todo.service.TodoListService2;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class TodoListController {

  private TodoListService todoListService;
  private TodoListService2 todoListService2;

  @GetMapping("/hello")
  public String hello() {
    return "HelloWorld";
  }
  
  @GetMapping("/")
  public ModelAndView regTodo(ModelAndView model) {
      //TodoList todo = new TodoList("테스트", "N");
	  //model.addObject("todo", todo);
      model.setViewName("todo");
      
      return model;
  }
  
  @PostMapping("/todo")
  public ResTodoListDto saveTodo(@RequestBody ReqTodoListDto dto) {
    return todoListService.save(dto);
  }
  
  @GetMapping("/todoList")
  public ModelAndView getTodoList(ModelAndView model) {
	  model.addObject("todoList", todoListService2.findAllDesc());
	  model.setViewName("todoList");
      return model;
  }
  
  @DeleteMapping("/todoDelete")
  public Long deleteTodo(@RequestBody ReqTodoListDto dto) {
	System.out.println("*********************id=" + dto.getId());  
    return todoListService.delete(dto);
  }
}
