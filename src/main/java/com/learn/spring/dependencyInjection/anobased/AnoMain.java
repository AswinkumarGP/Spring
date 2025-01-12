package com.learn.spring.dependencyInjection.anobased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class AnoMain {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AnoMain.class);
        Mobile m = (Mobile) context.getBean("mobile");
        m.get();
    }
}
