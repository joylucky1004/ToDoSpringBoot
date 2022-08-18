package com.joysoft.dto;

import com.joysoft.entity.ToDoEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ToDoDTO {
	private String id;
	private String title;
	private boolean done;

	
	//생성자를 이용해서 Entity를 DTO로 변환
	public ToDoDTO(final ToDoEntity entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.done = entity.isDone();
	}
		
		//DTO 와 Entity 변환을 위한 메서드
		 public static ToDoEntity toEntity(
				 final ToDoDTO dto) {
				return ToDoEntity.builder()
					.id(dto.getId())
					.title(dto.getTitle())
					.done(dto.isDone())
					.build();
			}
		}






























