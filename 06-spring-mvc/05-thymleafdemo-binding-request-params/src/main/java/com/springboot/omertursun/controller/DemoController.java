package com.springboot.omertursun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String sayHello(Model model) {
        model.addAttribute("theDate", java.time.LocalDate.now());
        //Returned string must have the same name with the jsf file name
        return "helloworld";
    }
}
