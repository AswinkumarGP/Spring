package com.learn.spring.dependencyInjection.javabased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaMain {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        Bike bike = (Bike)context.getBean("bike");
        bike.ride();
    }
}
