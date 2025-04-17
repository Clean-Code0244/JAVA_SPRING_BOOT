package com.omertursun.demo.rest;

import com.omertursun.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {


private List<Student> students ;

@PostConstruct
public void load_data(){
    students = new ArrayList<>();
    students.add(new Student("Ahmet", "Ahmet"));
    students.add(new Student("Mehmet", "Mehmet"));
    students.add(new Student("Ali", "Ali"));
}
    @GetMapping("/students")
    public List<Student> getStudents() {

        return students;
    }
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        return students.get(studentId);
    }
}
