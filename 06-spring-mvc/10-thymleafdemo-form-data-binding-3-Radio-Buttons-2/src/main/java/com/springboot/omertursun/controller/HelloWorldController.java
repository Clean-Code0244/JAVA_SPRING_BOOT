package com.springboot.omertursun.controller;

import org.springframework.ui.Model;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    @GetMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }
    @RequestMapping("/processForm")
    public String processForm(Model model){
        return "helloworld";
    }
    @RequestMapping("/processFormVersionTwo")
    public String processFormVersionTwo(HttpServletRequest request, Model model){

        String theName = request.getParameter("studentName");
        theName = theName.toUpperCase();
        String result = "Merhaba" + theName;
        model.addAttribute("message",result);
        return "helloworld";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName")String theName, Model model){

        //String theName = request.getParameter("studentName");

        theName = theName.toUpperCase();
        String result = "HEY " + theName;
        model.addAttribute("message",result);
        return "helloworld";
    }

}
