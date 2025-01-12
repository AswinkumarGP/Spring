package com.learn.spring.dependencyInjection.javabased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "com.learn.spring.dependencyInjection.javabased")
public class JavaConfig {

    @Bean
    public Helmet helmet(){
        return new Helmet();
    }

    @Bean
    public Bike bike(){
        return new Bike(helmet());
    }

}
