package com.luv2code.springcoredemo;

import org.springframework.stereotype.Component;
//Component Annotation marks the class as a Spring Bean
@Component
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes NOW!!!";
    }

}
