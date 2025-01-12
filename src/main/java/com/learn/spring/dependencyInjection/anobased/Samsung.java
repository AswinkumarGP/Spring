package com.learn.spring.dependencyInjection.anobased;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Samsung implements Brand{

    public void getBrand() {
        System.out.println("Samsung..!!");
    }
}
