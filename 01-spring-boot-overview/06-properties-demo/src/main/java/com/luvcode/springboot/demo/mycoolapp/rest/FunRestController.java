package com.luvcode.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    //Inject properties for: coach.name , team.name

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;


    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }

    @GetMapping("/workout")
    public String Demo(){
        return "This is just a Demo";
    }

    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach : "+ coachName + "</br></br></br>" + "Team : " + teamName;
    }

}
