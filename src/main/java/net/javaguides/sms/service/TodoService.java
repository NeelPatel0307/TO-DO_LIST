package net.javaguides.sms.service;

import java.util.List;

import net.javaguides.sms.entity.User;

public interface TodoService {
	List<User> getAllStudents();
	
	User saveStudent(User user);
	
	User getStudentById(Long id);
	
	User updateStudent(User user);
	
	void deleteStudentById(Long id);
}
