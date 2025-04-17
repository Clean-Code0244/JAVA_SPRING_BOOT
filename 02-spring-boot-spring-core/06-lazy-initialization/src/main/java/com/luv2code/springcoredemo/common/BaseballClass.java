package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BaseballClass implements Coach{


    public BaseballClass(){
        System.out.println("BASEBALL CLASS");
    }

    @Override
    public String getDailyWorkout() {
        return "Hello this is a Baseball Class ";
    }
}
