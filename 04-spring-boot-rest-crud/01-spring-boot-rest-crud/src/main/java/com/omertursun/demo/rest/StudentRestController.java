package com.omertursun.demo.rest;

import com.omertursun.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ahmet", "Ahmet"));
        students.add(new Student("Mehmet", "Mehmet"));
        students.add(new Student("Ali", "Ali"));
        return students;
    }
}
