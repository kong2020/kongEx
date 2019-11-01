package com.example.todo.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.todo.dto.ReqTodoListDto;
import com.example.todo.dto.ResTodoListDto2;
import com.example.todo.service.TodoListService;
import com.example.todo.service.TodoListService2;
import com.example.todo.service.TodoListService3;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class TodoListController {

  private TodoListService todoListService;
  private TodoListService2 todoListService2;
  private TodoListService3 todoListService3;

  @GetMapping("/hello")
  public String hello() {
    return "HelloWorld";
  }
  
  @GetMapping("/")
  public ModelAndView initTodo(ModelAndView model) {
      //TodoList todo = new TodoList("테스트", "N");
	  //model.addObject("todo", todo);
      model.setViewName("todoList2");
      return model;
  }
  
  @PostMapping("/todo")
  public ResTodoListDto2 insertTodo(@RequestBody ReqTodoListDto dto) {
    return todoListService2.save(dto);
  }
  
  //ajax사용하지 않는 순수 버전
  @PostMapping("/todo2")
  public ModelAndView insertTodo2(@ModelAttribute ReqTodoListDto dto) {
	
	todoListService2.save(dto);
    
	ModelAndView model = new ModelAndView();
    model.addObject("todoList", todoListService2.findAllDesc());
	model.setView(new RedirectView("todoList2"));
    return model;
  }
  
  @GetMapping("/todoList")
  public ModelAndView getTodoList(ModelAndView model) {
	  model.addObject("todoList", todoListService2.findAllDesc());
	  model.setViewName("todoList");
      return model;
  }
  
  //ajax사용하지 않는 순수 버전
  @GetMapping("/todoList2")
//  public ModelAndView getTodoList2(ModelAndView model) {
	public ModelAndView getTodoList2(@PageableDefault Pageable pageable, ModelAndView model) {
	  model.addObject("todoList", todoListService3.findAll(pageable));
	  model.setViewName("todoList2");
      return model;
  }
  
  @GetMapping("/todoListPage")
  public ModelAndView getTodoListPage(@PageableDefault Pageable pageable, ModelAndView model) {
	  model.addObject("todoList", todoListService3.findAll(pageable));
	  model.setViewName("todoList");
      return model;
  }
  
  @DeleteMapping("/todoDelete")
  public Long deleteTodo(@RequestBody ReqTodoListDto dto) {
	System.out.println("*********************id=" + dto.getId());  
    return todoListService2.delete(dto);
  }
  
  @GetMapping("/todoDelete2")
  public ModelAndView deleteTodo2(Long id) {
    todoListService2.delete(id);
    ModelAndView model = new ModelAndView();
    model.addObject("todoList", todoListService2.findAllDesc());
	model.setView(new RedirectView("todoList2"));
    return model;
  }
  
  @PutMapping("/todoUpdate")
  public ResTodoListDto2 updateTodo(@RequestBody ReqTodoListDto dto) {
	System.out.println("*********************id=" + dto.getId());  
	System.out.println("*********************contents=" + dto.getContents());  
	System.out.println("*********************done=" + dto.getDone());  
    return todoListService2.update(dto);
  }
}
