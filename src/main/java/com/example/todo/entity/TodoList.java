package com.example.todo.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.todo.converter.YnConverter;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@Entity
public class TodoList extends BaseTimeEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 500, nullable = false)
  private String contents;

  @Column(name = "is_done", length = 1, nullable = false, unique = false)
  @Convert(converter = YnConverter.class)
  private boolean done;

  @Builder
  public TodoList(String contents, boolean done) {
    this.contents = contents;
    this.done = done;
  }
}
