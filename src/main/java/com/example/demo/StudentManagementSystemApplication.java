package com.example.demo;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

import jakarta.persistence.Entity;

@SpringBootApplication
public class StudentManagementSystemApplication /* implements CommandLineRunner*/{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

//	@Autowired
//	private StudentRepository repo;
//	@Override
//	public void run(String... args) throws Exception {
//		Student student1= new Student("Senthilkumar","Palani","senthil@gmail.com" );
//		repo.save(student1);
//		Student student2= new Student("Santhoshkumar","Palani","santhosh@gmail.com" );
//		repo.save(student2);
//		Student student3= new Student("Manjula","Palani","Manjula@gmail.com" );
//		repo.save(student3);
//
//		
//	}

}
