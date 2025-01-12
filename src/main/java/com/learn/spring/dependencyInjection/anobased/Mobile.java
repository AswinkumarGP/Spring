package com.learn.spring.dependencyInjection.anobased;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Mobile {

    private Brand brand;

    public Brand getBrand() {
        return brand;
    }

    @Autowired
    //@Qualifier("apple")
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void get(){
        brand.getBrand();
    }
}
