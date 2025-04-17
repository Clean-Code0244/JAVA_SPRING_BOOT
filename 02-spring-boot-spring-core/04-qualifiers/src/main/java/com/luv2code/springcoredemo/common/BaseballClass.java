package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballClass implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Hello this is a Baseball Class ";
    }
}
