package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    public TennisCoach(){
        System.out.println("TENNIS CLASS");
    }

    @Override
    public String getDailyWorkout() {
        return "Hello this is a Tennis Class ";
    }
}
