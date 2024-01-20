package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Staff;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService service;

	public StudentController(StudentService service) {
		super();
		this.service = service;
	}
	@GetMapping("/")
	public String Login() {
		return "index";
	}
	
	
	  @PostMapping("/index/success")
	    public String loginSuccess(@ModelAttribute("staff")  Staff staff, Model model) {
		  System.out.println("Entered email: " + staff.getEmail());
          System.out.println("Entered password: " + staff.getPassword());
	        if ("senthil@gmail.com".equals(staff.getEmail()) && "1234".equals(staff.getPassword())) {
	        	
	            return "redirect:/students";  // Change "/students" to the desired URL
	        } else {
	            model.addAttribute("error", "Invalid email or password");
	            return "errorPage";  // Create a Thymeleaf template named errorPage.html
	        }
	    }
	  
	
	
	
	//handler method to handle list students and return mode and view
	@GetMapping("/students")
	public String listStudents(Model model ) {
		model.addAttribute("students", service.getAllStudents());
		return "students";
		
	}
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		//create student object to hold student data
		Student student=new Student();
		model.addAttribute("student",student);
		return "create_student";
		
		
	}
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		service.saveStudent(student);
		return "redirect:/students";
	}
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student",service.getStudentById(id));
		return "edit_student";
	     
		
	}
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student,Model model) {
		//get std from db by id
		Student existingstd=service.getStudentById(id);
		existingstd.setFirstName(student.getFirstName());
		existingstd.setLastName(student.getLastName());
		existingstd.setEmail(student.getEmail());
		
		service.updateStudent(existingstd);
		return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		service.deleteStudentById(id);
		return "redirect:/students";
	}
	
}
