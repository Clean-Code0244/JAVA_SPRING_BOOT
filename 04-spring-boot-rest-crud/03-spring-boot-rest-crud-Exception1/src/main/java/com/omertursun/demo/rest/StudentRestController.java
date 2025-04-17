package com.omertursun.demo.rest;

import com.omertursun.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


        if (studentId < 0 || studentId > students.size()) {
            throw new StudentNotFoundException("Student id " + studentId + " not found");
        }
        return students.get(studentId);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e) {

        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
