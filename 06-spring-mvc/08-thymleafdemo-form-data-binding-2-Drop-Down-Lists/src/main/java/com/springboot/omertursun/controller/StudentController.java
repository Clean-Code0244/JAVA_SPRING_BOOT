package com.springboot.omertursun.controller;

import com.springboot.omertursun.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @GetMapping("/show-student-form")
    public String showForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "student-form";
    }
    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student student, Model model){
        //model.addAttribute("student", student);
        System.out.println("The First Name of student is: " + student.getFirstName() + "The Last Name of student is: " + student.getLastName());
        return "student-confirmation";
    }


}
