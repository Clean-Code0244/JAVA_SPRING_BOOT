package com.luv2code.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component

public class BaseballClass implements Coach{


    public BaseballClass(){
        System.out.println("BASEBALL CLASS");
    }

    @Override
    public String getDailyWorkout() {
        return "Hello this is a Baseball Class ";
    }
}
