package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component

public class TrackCoach implements Coach{

    public TrackCoach(){
        System.out.println("TRACK CLASS");
    }
    @Override
    public String getDailyWorkout() {
        return "Hello this is the Track Coach";
    }
}
