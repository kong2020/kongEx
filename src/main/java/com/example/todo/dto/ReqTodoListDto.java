package com.example.todo.dto;

import com.example.todo.entity.TodoList;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReqTodoListDto {

  private Long id;
  private String contents;
  private String done;

  @Builder
  public ReqTodoListDto(String contents, String done) {
      this.contents = contents;
      this.done = done;
  }
  
  public TodoList toEntity() {
	boolean xxx = "y".equalsIgnoreCase(done) ? true : false;  
    return TodoList.builder().contents(contents).done(xxx).build();
  }
}
