package com.learn.spring.dependencyInjection.xmlbased;

public class Tyre {

    private String brand;

    public Tyre(String brand){
        this.brand = brand;
    }

    public void brand(){
        System.out.println("Tyre :: "+brand);
    }
}
