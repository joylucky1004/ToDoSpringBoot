package com.joysoft.persistency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joysoft.entity.ToDoEntity;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDoEntity, String>{
	//기본 메서드가 아닌 데이터베이스 사용 함수
	//UserId를 가지고 조회하는 메서드
	List<ToDoEntity> findByUserId(String userId);
	
	
	
}
