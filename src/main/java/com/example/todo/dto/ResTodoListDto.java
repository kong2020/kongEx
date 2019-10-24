package com.example.todo.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.example.todo.entity.TodoList;

import lombok.Getter;

@Getter
public class ResTodoListDto {

	private Long id;
    private String contents;
    private boolean done;
    private String modifiedDate;

    public ResTodoListDto(TodoList entity) {
        id = entity.getId();
        contents = entity.getContents();
        done = entity.isDone();
        modifiedDate = toStringDateTime(entity.getModifiedDate());
    }
    
    /**
     * Java 8 버전
     */
    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }
}
