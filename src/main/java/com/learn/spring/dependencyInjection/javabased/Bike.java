package com.learn.spring.dependencyInjection.javabased;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class Bike {

    private Helmet helmet;

    //@Autowired
    public Bike(Helmet helmet) {
        this.helmet = helmet;
    }

    public void ride(){
        System.out.println("Zing...!!");
        helmet.brand();
    }
}
