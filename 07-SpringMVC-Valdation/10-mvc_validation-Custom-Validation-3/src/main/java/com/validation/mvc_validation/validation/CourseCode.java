package com.validation.mvc_validation.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


//Helper class that contains business rules / validation logic
@Constraint(validatedBy = CourseCodeConstraintValidator.class)

//Can apply our annotation to a method or field
@Target({ElementType.METHOD,ElementType.FIELD})

//Retain this annotation in the Java class file.
@Retention(RetentionPolicy.RUNTIME)


public @interface CourseCode {

    public String value() default "LUV";
    public String message() default "Invalid Course Code. Must start with LUV";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};

}
