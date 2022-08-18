package com.joysoft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.joysoft.entity.ToDoEntity;
import com.joysoft.persistency.ToDoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
//final 로 선언된 인스턴스 속성을 외부로 주입받도록 해주는 
//어노테이션
@RequiredArgsConstructor
//로그 기록을 위한 객체 주입 - logger 가 자동 주입
@Slf4j

public class ToDoServiceImpl implements ToDoService {
	
	private final ToDoRepository toDoRepository;
	
	//유효성 검사를 위한 메서드
	private void validate(final ToDoEntity entity) {
		if(entity == null) {
			log.warn("Entity 는 null 일 수 없음");
			throw new RuntimeException("Entity cannot be null.");
		}

		if(entity.getUserId() == null) {
			log.warn("알수 없는 사용자");
			throw new RuntimeException("Unknown user");
		}
	}
		
	@Override
	public List<ToDoEntity> create(ToDoEntity entity) {
		//유효성 검사
		validate(entity);
		//데이터 삽입
		toDoRepository.save(entity);
		log.info("Entity Id : {} is saved.", entity.getId());
		//userId에 해당하는 전체 데이터 리턴
		return toDoRepository.findByUserId(entity.getUserId());
	}

	@Override
	public List<ToDoEntity> retrieve(String userId) {
		//userId에 해당하는 전체 데이터 리턴
		return toDoRepository.findByUserId(userId);

	}

	@Override
	public List<ToDoEntity> update(ToDoEntity entity) {
		validate(entity);
		final Optional<ToDoEntity> original = toDoRepository.findById(entity.getId());
		original.ifPresent(todo -> {
			todo.setTitle(entity.getTitle());
			todo.setDone(entity.isDone());
			toDoRepository.save(todo);
		});
		//userId에 해당하는 전체 데이터 리턴
		return retrieve(entity.getUserId());

	}

	@Override
	public List<ToDoEntity> delete(ToDoEntity entity) {
		validate(entity); 

		try {
			toDoRepository.delete(entity);
		} catch(Exception e) {
			log.error("error deleting entity ", entity.getId(), e);
			throw new RuntimeException("error deleting entity " + entity.getId());
		}
		return retrieve(entity.getUserId());

	}
	
}
























