package net.javaguides.sms.service.impl;

import java.util.List;

import net.javaguides.sms.entity.User;
import org.springframework.stereotype.Service;

import net.javaguides.sms.repository.TodoRepository;
import net.javaguides.sms.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {

	private TodoRepository todoRepository;
	
	public TodoServiceImpl(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}

	@Override
	public List<User> getAllStudents() {
		return todoRepository.findAll();
	}

	@Override
	public User saveStudent(User user) {
		return todoRepository.save(user);
	}

	@Override
	public User getStudentById(Long id) {
		return todoRepository.findById(id).get();
	}

	@Override
	public User updateStudent(User user) {
		return todoRepository.save(user);
	}

	@Override
	public void deleteStudentById(Long id) {
		todoRepository.deleteById(id);
	}

}
