package com.omertursun.cruddemo;


import com.omertursun.cruddemo.dao.StudentDAO;
import com.omertursun.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner ->{
			//System.out.println("Hello World");
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Create multiple students");
		Student student = new Student("Banana", "Banana", "Banana@gmail.com");
		Student student1 = new Student("Apple", "Apple", "Apple@gmail.com");
		Student student2 = new Student("Cherry", "Cherry", "Cherry@gmail.com");
		System.out.println("Saving Students");
		studentDAO.save(student);
		studentDAO.save(student1);
		studentDAO.save(student2);

	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating student...");
		Student student = new Student("Ahmet", "Ahmet", "Ahmet@gmail.com");
		System.out.println("Savin Student...");
		studentDAO.save(student);
		System.out.println("Successfully created student. Id :" + student.getId());

	}

}
