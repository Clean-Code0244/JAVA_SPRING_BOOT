package com.springboot.omertursun.controller;

import com.springboot.omertursun.model.Studnet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudnetController {

    @GetMapping("/show-student-form")
    public String showForm(Model model){
        Studnet studnet = new Studnet();
        model.addAttribute("studnet", studnet);
        return "student-form";
    }


}
