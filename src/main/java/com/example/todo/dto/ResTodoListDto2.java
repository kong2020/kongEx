package com.example.todo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class ResTodoListDto2 {

	private Long id;
    private String contents;
    private boolean done;
    private LocalDateTime modifiedDate;

}
