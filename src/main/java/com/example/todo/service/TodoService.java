package com.example.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.model.TodoEntity;
import com.example.todo.persistence.TodoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TodoService {

	@Autowired
	private TodoRepository repository;
	
	public Optional<TodoEntity> create(final TodoEntity entity) {
		//Validations
		validate(entity);
		repository.save(entity);
		return repository.findById(entity.getId());
	}
}
