package com.learn.spring.dependencyInjection.anobased;

import org.springframework.stereotype.Component;

@Component
public class Apple implements Brand{

    public void getBrand() {
        System.out.println("Apple..!!!");
    }
}
