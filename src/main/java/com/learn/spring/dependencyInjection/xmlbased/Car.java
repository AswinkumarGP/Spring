package com.learn.spring.dependencyInjection.xmlbased;

public class Car {

    private String model;
    private Tyre tyre;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Tyre getTyre() {
        return tyre;
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    public void drive(){
        System.out.println(model+" :: Zoom...!!");
        tyre.brand();
    }
}
