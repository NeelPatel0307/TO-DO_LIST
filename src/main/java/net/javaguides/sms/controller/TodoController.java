package net.javaguides.sms.controller;

import net.javaguides.sms.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.sms.service.TodoService;

@Controller
public class TodoController {
	
	private TodoService todoService;

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	
	// handler method to handle list students and return mode and view
	@GetMapping("/user")
	public String listStudents(Model model) {
		model.addAttribute("user", todoService.getAllStudents());
		return "user";
	}
	
	@GetMapping("/user/new")
	public String createStudentForm(Model model) {
		
		// create student object to hold student form data
		User user = new User();
		model.addAttribute("user", user);
		return "create_user";
		
	}
	
	@PostMapping("/user")
	public String saveStudent(@ModelAttribute("user") User user) {
		todoService.saveStudent(user);
		return "redirect:/user";
	}
	
	@GetMapping("/user/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("user", todoService.getStudentById(id));
		return "edit_user";
	}

	@PostMapping("/user/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("user") User user,
			Model model) {
		
		// get student from database by id
		User existingUser = todoService.getStudentById(id);
		existingUser.setId(id);
		existingUser.setTaskName(user.getTaskName());
		existingUser.setDescription(user.getDescription());
		existingUser.setDeadline(user.getDeadline());
		
		// save updated student object
		todoService.updateStudent(existingUser);
		return "redirect:/user";
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/user/{id}")
	public String deleteStudent(@PathVariable Long id) {
		todoService.deleteStudentById(id);
		return "redirect:/user";
	}
	
}
