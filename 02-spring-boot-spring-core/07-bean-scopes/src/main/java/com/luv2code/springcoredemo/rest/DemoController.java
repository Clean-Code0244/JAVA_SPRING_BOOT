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
    private  Coach anotherCoach;
    //define a constructor for dependency injection

    @Autowired
    public  DemoController(@Qualifier("baseballClass") Coach thecoach,@Qualifier("baseballClass") Coach theanotherCoach){mycoach = thecoach;
    anotherCoach = theanotherCoach;}

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return mycoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check(){
        return "Comparing beans: myCoach = anotherCoach," + (mycoach == anotherCoach);
    }
}


