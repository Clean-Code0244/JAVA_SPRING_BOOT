package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private field for dependency
    private Coach mycoach;

    //define a constructor for dependency injection

    @Autowired
    public  DemoController(@Qualifier("baseballClass") Coach thecoach){
        System.out.println("IN constructor" + getClass().getSimpleName());
        mycoach = thecoach;
}

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return mycoach.getDailyWorkout();
    }

//    @GetMapping("/check")
//    public String check(){
//        return "Comparing beans: myCoach = anotherCoach," + (mycoach == anotherCoach);
//    }
}


