package com.example.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todo.entity.TodoList;

@Repository
public interface TodoListRepository3 extends JpaRepository<TodoList, Long> {
	//(1) findBy로 시작 + Entity 필드 이름
	//(2) countBy로 시작 + Entity 필드 이름
	//기본기능을 제외한 조회 기능을 추가하고 싶으면 명명규칙에 맞는 메서드를 추가해야한다.
	//Member findByName(String name);
    //Page<Member> findByName(String name, Pageable pageable);
	
	//  And:   findByEmailAndUserId(String email, String userId)
	//  Or:    findByEmailOrUserId(String email, String userId)
	//  Between: findByCreatedAtBetween(Date fromDate, Date toDate)
	//  LessThan: findByAgeGraterThanEqual(int age)
	//  GreaterThanEqual:  findByAgeGraterThanEqual(int age)
	//  Like:  findByNameLike(String name)
	//  IsNull: findByJobIsNull()
	//  In:  findByJob(String … jobs)
	//  OrderBy: findByEmailOrderByNameAsc(String email)	
}
